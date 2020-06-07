package tomcat;

import standard.HttpServlet;
import standard.HttpServletRequest;
import standard.HttpServletResponse;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StaticResourceServlet extends HttpServlet {
    // 这里需要改成你们自己的目录
    private static final String TOMCAT_HOME = "F:\\比特\\java-code\\java_work\\5-20 Tomcat";

    private String getFilePath(String path) {
        return TOMCAT_HOME + File.separator + "web" + File.separator + path;
    }

    // /gogogo.html
    public boolean isStaticResource(String path) {
        String filePath = getFilePath(path);    // ...\web\gogogo.html
        File file = new File(filePath);
        if (!file.exists()) {
            return false;
        }

        return file.isFile();
    }

    private Map<String, String> mimeType = new HashMap<>();

    {
        mimeType.put(".js", "application/javascript; charset=utf-8");
        mimeType.put(".html", "text/html; charset=utf-8");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 读取静态资源对应的文件
        // 把内容写入到 response 中

        int i = req.getPath().lastIndexOf(".");
        if (i == -1) {
            resp.setContentType("text/html; charset=utf-8");
        } else {
            String suffix = req.getPath().substring(i);
            String contentType = mimeType.get(suffix);
            if (contentType == null) {
                contentType = "text/html; charset=utf-8";
            }
            resp.setContentType(contentType);
        }
        String filePath = getFilePath(req.getPath());
        try (InputStream fileInputStream = new FileInputStream(filePath)) {
            OutputStream respOutputStream = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                respOutputStream.write(buffer, 0, len);
            }
            respOutputStream.flush();
        }
    }
}

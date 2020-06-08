package tomcat;

import java.util.HashMap;
import java.util.Map;

public abstract class WebDescriptor {
    // url-pattern 对应 servlet-name
    protected Map<String, String> urlToName = new HashMap<>();
    // servlet-name 对象 servlet-class
    protected Map<String, String> nameToClass = new HashMap<>();

    public String getServletNameByUrlPattern(String urlPattern) {
        // TODO: web.xml 中的 url-pattern 是支持正则表达式的
        // TODO: 我们没有实现
        return urlToName.get(urlPattern);
    }

    public String getServletClassByServletName(String servletName) {
        return nameToClass.get(servletName);
    }
}

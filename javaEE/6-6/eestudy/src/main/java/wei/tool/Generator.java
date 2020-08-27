package wei.tool;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    private static final boolean OVERWRITE = true;

    private static final String CONFIG_PATH = "generator/config.xml";

    /**
     * 生成工具操作步骤：
     * 1.复制generator的java代码到src/main/java，随便一个包
     * 2.复制generator/config.xml文件到src/main/resources
     * 3.config.xml里边ee-study改成自己的项目名，targetPackage里边根包名称改成自己的
     * 4.生成src/test/resources目录
     * 5.运行Generator中的main方法
     * 6.没有生成代码及xml配置文件的，执行此步骤：把config.xml文件中的"项目名/"去掉，重新执行第5步
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println("--------------------start generator-------------------");
        List<String> warnings = new ArrayList<>();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(CONFIG_PATH);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        DefaultShellCallback callback = new DefaultShellCallback(OVERWRITE);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        warnings.forEach(System.err::println);
        System.out.println("--------------------end generator-------------------");
    }
}
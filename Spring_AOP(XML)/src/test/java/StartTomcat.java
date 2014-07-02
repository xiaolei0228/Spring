import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

/**
 * @version V1.0
 * @Project: Spring
 * @Title:
 * @Package PACKAGE_NAME
 * @Description:
 * @Author xiaolei-0228@163.com
 * @Date 2014/7/2 0002 23:00
 * @Copyright: 2014 ihome.com
 */
public class StartTomcat {
    private static String webrootPath = System.getProperty("webroot.path");   //WEB应用程序路径
    private static String contextPath = System.getProperty("context.path");    //WEB上下文名称


    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.setBaseDir(".");
        tomcat.getHost().setAppBase(webrootPath);

        // Add AprLifecycleListener
        StandardServer server = (StandardServer) tomcat.getServer();
        AprLifecycleListener listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);

        tomcat.addWebapp(contextPath, webrootPath);
        tomcat.start();
        System.out.println("Tomcat 7 启动完毕！");
        tomcat.getServer().await();

    }
}

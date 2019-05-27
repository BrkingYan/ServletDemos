import com.sun.mail.util.MailSSLSocketFactory;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {
 
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Properties props = new Properties();
 
            // 开启debug调试
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
            // 设置邮件服务器主机名
            props.setProperty("mail.host", "smtp.163.com");
            // props.setProperty("mail.port", "465");
            // 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");
 
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
 
            Session session = Session.getInstance(props);
 
            Message msg = new MimeMessage(session);
            msg.setSubject("邮件服务");
            StringBuilder builder = new StringBuilder();
            //            builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
            builder.append("\nhello qxl from ryan");
            builder.append("\n时间 " + new Date());
            msg.setText(builder.toString());
            msg.setFrom(new InternetAddress("15671559233@163.com"));
 
            Transport transport = session.getTransport();
            transport.connect("smtp.163.com", "15671559233@163.com", "123");
 
            transport.sendMessage(msg, new Address[] { new InternetAddress("1063422772@qq.com") });
 
            transport.close();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
 
        request.setAttribute("message", "邮件上传成功");
        request.getServletContext().getRequestDispatcher("/mailSendSucc.jsp").forward(request, response);
 
    }
}


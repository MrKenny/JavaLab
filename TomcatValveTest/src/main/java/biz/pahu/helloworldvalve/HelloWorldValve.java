package biz.pahu.helloworldvalve;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

/**
 * Created by phu on 01.05.2018.
 */
public class HelloWorldValve extends ValveBase {

    private static final Logger logger = Logger.getLogger(HelloWorldValve.class.getName());

    /**
     * {@inheritDoc}
     */

    public void invoke(Request request, Response response) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = request.getRequest();

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            logger.log(Level.INFO, "Header --> {0} Value --> {1}", new Object[]{header, httpServletRequest.getHeader(header)});
        }

        getNext().invoke(request, response);
    }
}

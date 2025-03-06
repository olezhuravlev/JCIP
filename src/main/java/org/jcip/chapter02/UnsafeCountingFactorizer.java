package org.jcip.chapter02;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.jcip.annotations.NotThreadSafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

@NotThreadSafe
@WebServlet("/counter")
public class UnsafeCountingFactorizer extends HttpServlet {

    private long count = 0;

    //    @Override
    //    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        resp.setContentType("text/html");
    //        PrintWriter printWriter = resp.getWriter();
    //        printWriter.write("Hello!");
    //        printWriter.close();
    //    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException {

        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);
        ++count;
        encodeIntoResponse(resp, factors);

        String message = "=====> COUNT: " + count;
        System.out.println(message);

        resp.setContentType("text/html");

        PrintWriter printWriter = resp.getWriter();
        printWriter.write(message);
        printWriter.close();
    }

    void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
    }

    BigInteger extractFromRequest(ServletRequest req) {
        return new BigInteger("7");
    }

    BigInteger[] factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger[]{i};
    }
}

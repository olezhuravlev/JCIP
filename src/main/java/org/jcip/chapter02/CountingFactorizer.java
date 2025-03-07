package org.jcip.chapter02;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.jcip.annotations.ThreadSafe;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

@ThreadSafe
@WebServlet("/counter-safe")
public class CountingFactorizer extends HttpServlet {

    private final AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException {

        BigInteger i = extractFromRequest(req);
        BigInteger[] factors = factor(i);

        count.incrementAndGet();

        encodeIntoResponse(resp, factors);

        String message = "=====> COUNT: " + getCount();
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

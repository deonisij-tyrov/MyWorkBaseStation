package web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Class EncodingFilter
 * <p>
 * Created by yslabko on 08/11/2017.
 */
@WebFilter(urlPatterns = {"/*",}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class EncodingFilter implements Filter {

    private String encoding = "utf-8";

    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);

        response.setContentType("text/html; charset=" + encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null && !"".equals(encodingParam)) {
            encoding = encodingParam;
        }
    }

    public void destroy() {
    }
}

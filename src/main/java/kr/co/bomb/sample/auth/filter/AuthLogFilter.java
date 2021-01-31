package kr.co.bomb.sample.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;



@Component("authLogFilter")
public class AuthLogFilter extends AbstractRequestLoggingFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthLogFilter.class);

    public AuthLogFilter() {
        super();
        this.setIncludeQueryString(true);
        this.setIncludePayload(true);
        this.setIncludeClientInfo(true);
        this.setIncludeHeaders(true);
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logger.debug("..........beforeRequest...............");
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        logger.debug("..........afterRequest...............");
        if ( request.getAttribute("errorLog") != null ) {
            String errorLog = String.valueOf(request.getAttribute("errorLog"));
            String payload = this.getMessagePayload(request);
            errorLog =  String.format(errorLog,payload == null ? "" : "\n"+payload);
            logger.error(errorLog);
        }
    }

}

package ru.returnonintelligence.technobus.intersept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.returnonintelligence.technobus.services.GoogleConnectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author NIKIT on 11.07.2017.
 */
public class GoogleSheetsInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSheetsInterceptor.class);
	@Autowired
	private GoogleConnectionService connection;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		LOGGER.debug("Pre-handle");
		LOGGER.debug(request.getRequestURI());

		// is connected
		if (connection.getCredentials() == null) {
			connection.setSourceUrl(request.getRequestURI());
			response.sendRedirect("/ask");
			return false;
		}
		
		return true;
	}

}

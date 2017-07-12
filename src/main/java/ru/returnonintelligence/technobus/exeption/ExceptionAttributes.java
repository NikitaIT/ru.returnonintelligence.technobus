package ru.returnonintelligence.technobus.exeption;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
/**
 * @author NIKIT on 11.07.2017.
 */
public interface ExceptionAttributes {

	Map<String, Object> getExceptionsAttributes(Exception exeception, HttpServletRequest httprequest,
			HttpStatus httpStatus);
}

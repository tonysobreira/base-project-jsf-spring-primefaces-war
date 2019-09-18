package br.com.controlefinanceiro.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtils {

	private Logger logger;

	@SuppressWarnings("rawtypes")
	private LoggerUtils(Class clazz) {

		try {
			logger = Logger.getLogger(clazz.getName());
		} catch (Exception e) {
			System.out.println("Error in logger");
		}

	}

	@SuppressWarnings("rawtypes")
	public static LoggerUtils getLogger(Class clazz) {
		return new LoggerUtils(clazz);
	}

	public void log(Level level, String message) {
		logger.log(level, message);
	}

	public void info(Object message) {
		logger.info(message.toString());
	}

	public void warn(Object message) {
		logger.warning(message.toString());
	}

}

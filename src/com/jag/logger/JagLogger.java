package com.jag.logger;

import java.util.logging.Level;
import java.util.logging.Logger;


public class JagLogger {
	
	public static void setup() {
		Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
		logger.setLevel(Level.INFO);
		
	}

}

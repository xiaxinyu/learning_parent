package com.learning.design.pattern.adapter;

import org.apache.log4j.Logger;

public class JapanMicrowave implements JapanElectricEquipment{
	private Logger logger = Logger.getLogger(JapanMicrowave.class);
	
	@Override
	public void input110V() {
		logger.info("Running Japanese TV.");
	}

}

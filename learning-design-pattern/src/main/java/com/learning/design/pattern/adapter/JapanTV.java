package com.learning.design.pattern.adapter;

import org.apache.log4j.Logger;

public class JapanTV implements JapanElectricEquipment {
	private Logger logger = Logger.getLogger(JapanTV.class);

	@Override
	public void input110V() {
		logger.info("Running Japanese Microwave.");
	}

}

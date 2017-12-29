package org.learning.design.pattern.adapter;

import org.apache.log4j.Logger;

public class ChineseAdapter implements ChinaElectricEquipment{
	private Logger logger = Logger.getLogger(ChineseAdapter.class);
	private JapanElectricEquipment japanEquipment;
	
	public ChineseAdapter(JapanElectricEquipment japanEquipment){
		this.japanEquipment = japanEquipment;
	}
	
	@Override
	public void input220V() {
		logger.info("Running in Chinese environment.");
		japanEquipment.input110V();
	}

}

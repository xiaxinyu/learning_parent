/**
 * 
 */
/**
 * @author summer.xiasz
 *
 */
package org.learning.design.pattern.adapter;

import org.junit.Test;

public class AdapterTest{
	@Test
	public void testAdapter(){
		ChineseAdapter adapter1 = new ChineseAdapter(new JapanTV());
		adapter1.input220V();
		
		ChineseAdapter adapter2 = new ChineseAdapter(new JapanMicrowave());
		adapter2.input220V();
	}
}
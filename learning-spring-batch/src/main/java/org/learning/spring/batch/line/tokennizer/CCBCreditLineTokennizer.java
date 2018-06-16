package org.learning.spring.batch.line.tokennizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.learning.spring.batch.exception.CCBCreditParseException;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class CCBCreditLineTokennizer extends DelimitedLineTokenizer {
	@Override
	protected List<String> doTokenize(String line) {
		List<String> result = null;
		if (StringUtils.isNotBlank(line)) {
			List<String> items = Arrays.asList(line.split(" "));
			for (String item : items) {
				if (StringUtils.isNotBlank(item)) {
					if (result == null) {
						result = new ArrayList<String>();
					}
					result.add(item);
				}
			}
		} else {
			throw new CCBCreditParseException("Parsed line is blank.");
		}
		return result;
	}
}

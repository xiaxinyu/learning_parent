package org.learning.spring.batch.line.tokennizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.learning.spring.batch.exception.CSVParseException;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class CCBCreditLineTokennizer extends DelimitedLineTokenizer {
	@Override
	protected List<String> doTokenize(String line) {
		int fieldCount = this.names.length;

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

			int resultSize = result.size();
			if (resultSize < fieldCount) {
				throw new CSVParseException(CCBCreditLineTokennizer.class.getName(),
						"CCBDataLine's size less than " + fieldCount, line);
			} else if (resultSize > fieldCount) {
				List<String> newItems = new ArrayList<String>();
				StringBuilder mergeItem = new StringBuilder();
				for (int i = 0; i < resultSize; i++) {
					String resultItem = result.get(i);
					if (i < (fieldCount - 1)) {
						newItems.add(resultItem);
					} else {
						mergeItem.append(resultItem + " ");
					}

					// loop on the last one
					if ((i + 1) == resultSize) {
						newItems.add(mergeItem.toString());
					}
				}
				result = newItems;
			}
		} else {
			throw new CSVParseException(CCBCreditLineTokennizer.class.getName(), "Parsed line is blank.");
		}
		return result;
	}
}

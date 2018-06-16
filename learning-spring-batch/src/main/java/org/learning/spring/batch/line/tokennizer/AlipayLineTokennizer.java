package org.learning.spring.batch.line.tokennizer;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.learning.spring.batch.exception.CSVParseException;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

public class AlipayLineTokennizer extends DelimitedLineTokenizer {
	@Override
	protected List<String> doTokenize(String line) {
		int fieldCount = this.names.length;

		List<String> result = null;
		if (StringUtils.isNotBlank(line)) {
			String[] items = line.split(",");

			int resultSize = items.length;
			if (resultSize < fieldCount) {
				throw new CSVParseException(AlipayLineTokennizer.class.getName(),
						"AlipayDateLine's size less than " + fieldCount, line);
			} else if (resultSize >= fieldCount) {
				String[] newItems = Arrays.copyOfRange(items, 0, fieldCount);
				result = Arrays.asList(newItems);
			}
		} else {
			throw new CSVParseException(AlipayLineTokennizer.class.getName(), "Parsed line is blank.");
		}
		return result;
	}
}

package org.aming.csv.config;

import java.io.Serializable;

public class CsvReaderConfigure implements Serializable {

	private static final long serialVersionUID = -5074695824157339418L;
	
	 private static final char DEFAULT_SEPARATOR = ',';
	    private static final char DEFAULT_QUOTECHAR = '"';
	    private static final char DEFAULT_ESCAAPECHAR = '\\';
	    private static final boolean DEFAULT_STRICT_QUOTES = false;
	    private static final boolean DEFAULT_IGNORE_LEADING_WHITE_SPACE = true;
	    private static final boolean DEFAULT_IGNORE_QUOTATIONS = false;
	    private static final boolean DEFAULT_INGNORE_CASE_HEADERS = false;
	    private static final int DEFAULT_SKIP_LINES = 1;

	    private char separator = DEFAULT_SEPARATOR;
	    private char quoteChar = DEFAULT_QUOTECHAR;
	    private char escapeChar = DEFAULT_ESCAAPECHAR;
	    private boolean strictQuotes = DEFAULT_STRICT_QUOTES;
	    private boolean ignoreLeadingWhiteSpace = DEFAULT_IGNORE_LEADING_WHITE_SPACE;
	    private boolean ignoreQuotations = DEFAULT_IGNORE_QUOTATIONS;
	    private boolean ignoreCaseHeaders = DEFAULT_INGNORE_CASE_HEADERS;
	    private int readSkipLines = DEFAULT_SKIP_LINES ;

	    public char getSeparator() {
	        return separator;
	    }

	    public CsvReaderConfigure setSeparator(char separator) {
	        this.separator = separator;
	        return this;
	    }

	    public char getQuoteChar() {
	        return quoteChar;
	    }

	    public CsvReaderConfigure setQuoteChar(char quoteChar) {
	        this.quoteChar = quoteChar;
	        return this;
	    }

	    public char getEscapeChar() {
	        return escapeChar;
	    }

	    public CsvReaderConfigure setEscapeChar(char escapeChar) {
	        this.escapeChar = escapeChar;
	        return this;
	    }

	    public boolean isStrictQuotes() {
	        return strictQuotes;
	    }

	    public CsvReaderConfigure setStrictQuotes(boolean strictQuotes) {
	        this.strictQuotes = strictQuotes;
	        return this;
	    }

	    public boolean isIgnoreLeadingWhiteSpace() {
	        return ignoreLeadingWhiteSpace;
	    }

	    public CsvReaderConfigure setIgnoreLeadingWhiteSpace(boolean ignoreLeadingWhiteSpace) {
	        this.ignoreLeadingWhiteSpace = ignoreLeadingWhiteSpace;
	        return this;
	    }

	    public boolean isIgnoreQuotations() {
	        return ignoreQuotations;
	    }

	    public CsvReaderConfigure setIgnoreQuotations(boolean ignoreQuotations) {
	        this.ignoreQuotations = ignoreQuotations;
	        return this;
	    }

	    public int getReadSkipLines() {
	        return readSkipLines;
	    }

	    public CsvReaderConfigure setReadSkipLines(int readSkipLines) {
	        this.readSkipLines = readSkipLines;
	        return this;
	    }

		public boolean isIgnoreCaseHeaders() {
			return ignoreCaseHeaders;
		}

		public CsvReaderConfigure setIgnoreCaseHeaders(boolean ignoreCaseHeaders) {
			this.ignoreCaseHeaders = ignoreCaseHeaders;
			return this;
		}
}

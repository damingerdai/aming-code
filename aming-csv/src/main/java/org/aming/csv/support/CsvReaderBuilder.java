package org.aming.csv.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Objects;

import org.aming.csv.config.CsvReaderConfigure;
import org.aming.csv.core.CsvReader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.ICSVParser;

public class CsvReaderBuilder {
	private final CSVReaderBuilder builder;
	private boolean ignoreCaseHeader = true;
	
	public CsvReaderBuilder(final File file) {
		if (Objects.isNull(file) || !file.exists()) {
			throw new IllegalArgumentException("file is required");
		}
		try {
			Reader reader = new FileReader(file);
			this.builder = new CSVReaderBuilder(reader);
		} catch (FileNotFoundException ex) {
			throw new IllegalArgumentException("file is required", ex);
		}
	}

	public CsvReaderBuilder(final Reader reader) {
		if (Objects.isNull(reader)) {
			throw new IllegalArgumentException("reader is required");
		}
		this.builder = new CSVReaderBuilder(reader);

	}

	public CsvReaderBuilder withSkipLines(int skipLines) {
		this.builder.withSkipLines(skipLines);
		return this;
	}
	
	public CsvReaderBuilder withIgnoreCaseHeader(boolean ignoreCaseHeader) {
		this.ignoreCaseHeader = ignoreCaseHeader;
		return this;	
	}

	public CsvReaderBuilder withCSVParser(final ICSVParser icsvParser) {
		this.builder.withCSVParser(icsvParser);
		return this;
	}

	public CsvReaderBuilder withCsvReaderConfigure(CsvReaderConfigure configure) {
		ICSVParser icsvParser = new CSVParserBuilder().withSeparator(configure.getSeparator())
				.withQuoteChar(configure.getQuoteChar()).withEscapeChar(configure.getEscapeChar())
				.withStrictQuotes(configure.isStrictQuotes())
				.withIgnoreLeadingWhiteSpace(configure.isIgnoreLeadingWhiteSpace())
				.withIgnoreQuotations(configure.isIgnoreQuotations()).build();
		return withCSVParser(icsvParser)
				.withIgnoreCaseHeader(configure.isIgnoreCaseHeaders())
				.withSkipLines(configure.getReadSkipLines());
	}

	public CsvReader build() {
		return new CsvReader(this.builder.build(),ignoreCaseHeader);
	}
}

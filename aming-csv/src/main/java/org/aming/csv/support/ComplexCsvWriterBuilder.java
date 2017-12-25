package org.aming.csv.support;

import com.opencsv.CSVWriter;
import org.aming.csv.core.CsvWriter;

import java.io.Writer;
import java.util.Objects;
import java.util.Optional;

/**
 * @author daming
 * @version 2017/12/21.
 */
public class ComplexCsvWriterBuilder implements ICsvWriterBuilder{

    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTECHAR = '"';
    private static final char DEFAULT_ESCAPECHAR = '\u0000';
    private static final String DEFAULT_LINE_END = "\n";
    private static final int DEFAULT_BUFFER_SIZE = 500;

    private final Optional<Writer> writer;
    private char separator;
    private char quotechar;
    private char escapechar;
    private String lineEnd;
    private int bufferSize;
    private String[] headers;

    public ComplexCsvWriterBuilder(Writer writer) {
        super();
        this.writer = Optional.of(writer);
        this.separator = DEFAULT_SEPARATOR;
        this.quotechar = DEFAULT_QUOTECHAR;
        this.escapechar = DEFAULT_ESCAPECHAR;
        this.lineEnd = DEFAULT_LINE_END;
        this.bufferSize = DEFAULT_BUFFER_SIZE;
    }

    public void withSeparator(char separator) {
        this.separator = separator;
    }

    public void withQuotechar(char quotechar) {
        this.quotechar = quotechar;
    }

    public void withEscapechar(char escapechar) {
        this.escapechar = escapechar;
    }

    public void withLineEnd(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    @Override
    public void withBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    @Override
    public void withHeaders(String[] headers) {
        this.headers = headers;
    }

    @Override
    public CsvWriter build() {
        if(Objects.isNull(headers)) {
            headers = new String[0];
        }
        return new CsvWriter(
                new CSVWriter(writer.get(), separator, quotechar, escapechar, lineEnd),
                headers,
                bufferSize
        );
    }
}

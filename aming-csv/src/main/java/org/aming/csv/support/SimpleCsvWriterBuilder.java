package org.aming.csv.support;

import com.opencsv.CSVWriter;
import org.aming.csv.core.CsvWriter;
import org.aming.csv.support.ICsvWriterBuilder;

import java.util.Optional;

/**
 * @author daming
 * @version 2017/12/21.
 */
public class SimpleCsvWriterBuilder implements ICsvWriterBuilder {

    private static final int DEFAULT_BUFFER_SIZE = 500;

    private final Optional<CSVWriter> writer;
    private String[] headers;
    private int bufferSize;

    public SimpleCsvWriterBuilder(CSVWriter writer) {
        super();
        this.writer = Optional.of(writer);
        this.bufferSize = DEFAULT_BUFFER_SIZE;
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
        return new CsvWriter(writer.get(), headers, bufferSize);
    }
}

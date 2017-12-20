package org.aming.csv.core;

import com.opencsv.CSVWriter;

import java.io.Closeable;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author daming
 * @version 2017/12/20.
 */
public class CsvWriter implements Closeable {

    private static final int DEFAULT_BUFFER_SIZE = 500;

    private final Optional<CSVWriter> csvWriter;

    private List<String[]> buffer;
    private Map<String, Integer> headersHolder;

    private int bufferSize = DEFAULT_BUFFER_SIZE;

    public void writeNextLine() {

    }

    public void writeNexLine(String[] line) {
        buffer.add(line);
    }

    public void doWrite() {
        if (buffer.size() > bufferSize) {
            csvWriter.get().writeAll(buffer);
        }
        buffer.clear();
    }

    public void refresh() {
        if (!buffer.isEmpty()) {
            csvWriter.get().writeAll(buffer);
        }
        buffer.clear();
    }

    public void doWriteLine(String[] line) {
        buffer.add(line);
        csvWriter.get().writeAll(buffer);
    }

    public CsvWriter(CSVWriter csvWriter, String[] headers) {
        super();
        this.csvWriter = Optional.of(csvWriter);
        this.buffer = new ArrayList<>( headers != null ? headers.length : 16);
        initHeaders(headers);
    }

    public CsvWriter(CSVWriter csvWriter, String[] headers, int bufferSize) {
        this(csvWriter, headers);
        this.bufferSize = bufferSize;
    }

    protected void initHeaders(String[] headers) {
        if (headers == null) {
            throw new IllegalArgumentException("headers is required");
        }

        if (Objects.isNull(headersHolder)) {
            headersHolder = new HashMap<>(headers.length);
        }
        for (int i = 0; i < headers.length; i++) {
            headersHolder.put(headers[i], i);
        }

        csvWriter.get().writeNext(headers);
    }


    @Override
    public void close() throws IOException {
        refresh();
        csvWriter.get().close();
    }
}

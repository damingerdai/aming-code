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
import java.util.function.Function;

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

    public <T> void writeNextLine(T t, Function<T, String[]> action) {
        writeNextLine(action.apply(t));
    }

    public void writeNextLine(Map<String, String> lineMap) {
        String[] line = new String[lineMap.size()];

        lineMap.forEach( (k, v) -> {
            int index = headersHolder.get(k);
            if(index > 0 && index < line.length) {
                line[index] = v;
            }
        });
        writeNextLine(line);
    }

    public void writeNextLine(String[] line, boolean isWrited) {
        buffer.add(line);
        if(isWrited) {
            refresh();
        }
    }

    public void writeNextLine(String[] line) {
        buffer.add(line);
    }

    public void doWrite() {
        if (buffer.size() > bufferSize) {
            refresh();
        }

    }

    public void refresh() {
        if (!buffer.isEmpty()) {
            csvWriter.get().writeAll(buffer);
            buffer.clear();
        }
    }


    public CsvWriter(CSVWriter csvWriter, String[] headers) {
        this(csvWriter, headers, DEFAULT_BUFFER_SIZE);
    }


    public CsvWriter(CSVWriter csvWriter, String[] headers, int bufferSize) {
        super();
        this.csvWriter = Optional.of(csvWriter);
        init(headers, bufferSize);
    }

    protected void init(String[] headers, int bufferSize) {
        if (Objects.isNull(headers)) {
            throw new IllegalArgumentException("headers is required");
        }

        initBuffer(headers.length, bufferSize);
        initHeaders(headers);
    }

    private void initBuffer(int length, int bufferSize) {
        this.buffer = new ArrayList<>(length);
        this.bufferSize  = bufferSize;
    }

    private void initHeaders(String[] headers) {
        Map<String, Integer> tempMap = new HashMap<>(headers.length);
        for (int i = 0; i < headers.length; i++) {
            headersHolder.put(headers[i], i);
        }
        headersHolder = Collections.unmodifiableMap(tempMap);
        csvWriter.get().writeNext(headers);
    }


    @Override
    public void close() throws IOException {
        refresh();
        csvWriter.get().close();
    }
}

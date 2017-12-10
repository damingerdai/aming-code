package org.aming.csv.core;

import com.opencsv.CSVReader;
import org.aming.csv.support.HeadersHolder;
import org.aming.csv.support.LinesHolder;

import java.io.Closeable;
import java.io.IOException;
import java.util.Optional;

/**
 * @author daming
 * @version 2017/12/9.
 */
public class CsvReader implements Closeable {

    private Optional<CSVReader> csvReader;

    private HeadersHolder headersHolder;

    private LinesHolder linesHolder;

    private boolean closed = false;

    public boolean readNextLine() throws IOException {
        if(closed) {
            throw new RuntimeException("csv reader is closed");
        }

        String[] line = csvReader.get().readNext();
        if(line != null && line.length > 0) {
            linesHolder.nextLine(line);
            if(linesHolder.getIndex() == 1) {
                this.headersHolder = HeadersHolder.getInstance(line);
                System.out.println("headersHolder:" +headersHolder);
            }
            return true;
        }
        return false;
    }

    public String[] getHeaders() {
        if(headersHolder != null) {
            return headersHolder.getHeaders();
        }
        return null;
    }

    public String[] getLines() {
        return linesHolder.getLines();
    }

    public int getRowIndex() {
        return linesHolder.getIndex();
    }

    public CsvReader(CSVReader csvReader) {
        super();
        this.csvReader = Optional.of(csvReader);
        this.linesHolder = LinesHolder.getInstance();
    }


    @Override
    public void close() throws IOException {
        csvReader.get().close();
        closed = true;
    }
}

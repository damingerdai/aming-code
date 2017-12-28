package org.aming.csv.core;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import org.aming.core.utils.CommonsUtils;
import org.aming.csv.support.HeadersHolder;
import org.aming.csv.support.LinesHolder;

import com.opencsv.CSVReader;
import org.aming.csv.utils.LinesHolderUtils;


/**
 * @author daming
 * @version 2017/12/9.
 */
public class CsvReader implements Closeable {
	
	private final Optional<CSVReader> csvReader;
	private boolean closed = false;
	private boolean ignoreCase = false;
    private HeadersHolder headersHolder;
    private LinesHolder linesHolder;
    
    public boolean readNextLine() throws IOException {
    	if(closed) {
    		throw new IOException("csv reader is closed");
    	}
    	
    	String[] lines = csvReader.get().readNext();
    	if (CommonsUtils.isNotEmpty(lines)) {
            linesHolder = LinesHolderUtils.getLinesHolder(linesHolder, lines);

            if (linesHolder.getIndex() == 1) {
                headersHolder = HeadersHolder.getInstance(lines, ignoreCase);
            }

            return true;
        } else {
            return false;
        }
    }

    public String[] getHeaders() {
        if (headersHolder.getHeaders() == null) {
            return new String[0];
        } else {
            return Arrays.copyOf(headersHolder.getHeaders(), headersHolder.getHeaders().length);
        }
    }

    
    public int getIndex(String headerName) throws Exception {
        try {
            return headersHolder.getIndexByName().get(headerName);
        } catch (Exception ex) {
            throw new Exception("fail to get header : " + headerName, ex);
        }
    }
    
    public int getRowIndex() {
    	return linesHolder.getIndex();
    }
    
    public String[] getValues() {
    	String[] lines = linesHolder.getLines();
    	if(Objects.isNull(lines)) {
    		return new String[0];
    	} else {
    		return Arrays.copyOf(lines, lines.length);
    	}
    }
    
    public String getValue(String header) throws Exception {
    	return getValues()[getIndex(header)];
    }
    
    
    public CsvReader(CSVReader csvReader) {
        super();
        this.csvReader = Optional.of(csvReader);
        this.linesHolder = LinesHolder.getInstance();
    }
 

    public CsvReader(CSVReader csvReader, boolean ignoreCase) {
        super();
        this.csvReader = Optional.of(csvReader);
        this.linesHolder = LinesHolder.getInstance();
        this.ignoreCase = ignoreCase;
    }

	@Override
	public void close() throws IOException {
		 csvReader.get().close();
		 this.closed = true;
	}
}

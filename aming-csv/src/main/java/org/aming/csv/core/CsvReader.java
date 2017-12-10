package org.aming.csv.core;

import java.io.Closeable;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import org.aming.csv.support.HeadersHolder;
import org.aming.csv.support.LinesHolder;

import com.opencsv.CSVReader;

/**
 * @author daming
 * @version 2017/12/9.
 */
public class CsvReader implements Closeable {
	
	private final Optional<CSVReader> csvReader;
	private boolean closed = false;
    private HeadersHolder headersHolder;
    private LinesHolder linesHolder;
    
    public boolean readNextLine() throws IOException {
    	if(closed) {
    		throw new IOException("csv reader is closed");
    	}
    	
    	String[] lines = csvReader.get().readNext();
    	if(lines != null && lines.length > 0) {
    		int rowIndex = linesHolder.getRowIndex();
    		linesHolder = LinesHolder.getInstance(lines, rowIndex + 1);
    		if(rowIndex == 0) {
    			initHeaders(lines);  
    		}
    		return true;
    	} else {
    		return false;
    	}
    }

    public String[] getHeaders() {
        if (headersHolder.getHeaders() == null) {
            return null;
        } else {
            String[] clone = new String[headersHolder.getLength()];
            System.arraycopy(headersHolder.getHeaders(), 0, clone, 0, headersHolder.getLength());
            return clone;
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
    	return linesHolder.getRowIndex();
    }
    
    public String[] getValues() {
    	String[] lines = linesHolder.getLines();
    	if(Objects.isNull(lines)) {
    		return null;
    	} else {
    		String[] clone = new String[lines.length];
    		System.arraycopy(lines, 0,  clone, 0,  lines.length);
    		return clone;
    	}
    }
    
    public String getValue(String header) throws Exception {
    	return getValues()[getIndex(header)];
    }
    
    private void initHeaders(String[] headers) {
        headersHolder.setHeaders(headers);
        headersHolder.getIndexByName().clear();
        if (headers != null) {
            headersHolder.setLength(headers.length);
        }

        for (int i = 0; i < headersHolder.getLength(); i++) {
            headersHolder.put(headers[i], i);
        }
    }

    public CsvReader(CSVReader csvReader) {
        super();
        this.csvReader = Optional.of(csvReader);
        this.linesHolder = LinesHolder.getInstance();
    }
    
    public CsvReader(CSVReader csvReader, boolean ignoreCaseHeader) {
    	 super();
         this.csvReader = Optional.of(csvReader);
         this.linesHolder = LinesHolder.getInstance();
         this.headersHolder = HeadersHolder.getHeadersHolder(ignoreCaseHeader);
    }

	@Override
	public void close() throws IOException {
		 csvReader.get().close();
		 this.closed = true;
	}
}

package org.aming.csv.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author daming
 * @version 2017/12/9.
 */
public final class HeadersHolder extends LinesHolder {

    private String[] headers;
    private boolean ignoreCase;
    private Map<String,Integer> indexByName;
    
    @Override
	public String[] getLines() {
    	return getHeaders();
	}
 
	@Override
	public int getRowIndex() {
		return 1;
	}

    public String[] getHeaders() {
        return headers;
    }

    public void setHeaders(String[] headers) {
        this.headers = headers;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Map<String, Integer> getIndexByName() {
        return indexByName;
    }

    public void setIndexByName(Map<String, Integer> indexByName) {
        this.indexByName = indexByName;
    }
    
    public void put(String key, Integer value) {
        if (indexByName == null) {
            indexByName = new HashMap<String, Integer>(this.length);
        }
        if (ignoreCase) {
        	// 忽略大小的话就直接放小写
        	key = key.toLowerCase();
        }
        indexByName.put(key, value);
    }
    
    public Integer get(String key) {
    	if (Objects.isNull(indexByName)) {
    		return -1;
    	} 
    	
    	if(ignoreCase) {
    		// 忽略大小的话就直接放小写
        	key = key.toLowerCase();
    	}
    	return indexByName.get(key);
    }

    private HeadersHolder() {
        super();
        this.headers = new String[0];
        this.length = 0;
        this.indexByName = new HashMap<String, Integer>(length);
    }
    
    
    private HeadersHolder(boolean ignoreCase) {
    	this();
    	this.ignoreCase = ignoreCase;
    }
    

    public static HeadersHolder getHeadersHolder() {
        return new HeadersHolder();
    }
    
    public static HeadersHolder getHeadersHolder(boolean ignoreCase) {
        return new HeadersHolder(ignoreCase);
    }
}

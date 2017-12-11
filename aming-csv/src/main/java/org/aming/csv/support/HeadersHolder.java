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
        String[] clone = new String[headers.length];
        System.arraycopy(headers, 0, clone, 0, headers.length);
        return clone;
    }


    @Override
    public int getLength() {
        return length;
    }

    private void initIndexByName() {
        if(indexByName == null) {
            indexByName = new HashMap<String, Integer>(length);
        }
        for(int i=0; i < headers.length; i++) {
            indexByName.put(headers[i], i);
        }
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
    
    public Map<String, Integer> getIndexByName() {
    	return indexByName;
    }

    public static HeadersHolder getInstance(String[] headers) {
        return new HeadersHolder(headers);
    }
    public HeadersHolder(String[] headers) {
        super();
        this.headers = new String[headers.length];
        System.arraycopy(this.headers, 0, headers, 0, this.headers.length);
        this.length = headers.length;
        initIndexByName();
    }

    
    private HeadersHolder(boolean ignoreCase) {
    	
    	this.ignoreCase = ignoreCase;
    }
    

    
    
    public static HeadersHolder getHeadersHolder(boolean ignoreCase) {
        return new HeadersHolder(ignoreCase);
    }
 
}

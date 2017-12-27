package org.aming.csv.support;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author daming
 * @version 2017/12/9.
 */
public final class HeadersHolder extends LinesHolder {

    private String[] headers;
    private boolean ignoreCase = false;
    private Map<String,Integer> indexByName;
    
    @Override
	public String[] getLines() {
    	return getHeaders();
	}
 
	@Override
	public int getIndex() {
		return 1;
	}
 

    public String[] getHeaders() {
        return Arrays.copyOf(headers, headers.length);
    }


    private void initIndexByName() {
        if(indexByName == null) {
            indexByName = new HashMap<String, Integer>();
        }
        for(int i=0; i < headers.length; i++) {
            indexByName.put(headers[i], i);
        }
    }
    
    public void put(String key, Integer value) {
        if (indexByName == null) {
            indexByName = new HashMap<String, Integer>();
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
    	return Collections.unmodifiableMap(indexByName);
    }


    public HeadersHolder(String[] headers) {
        super(headers, 0);
        initIndexByName();
    }

    
    private HeadersHolder(String[] headers, boolean ignoreCase) {
        super(headers, 0);
    	this.ignoreCase = ignoreCase;
    }

    public static HeadersHolder getInstance(String[] headers) {
        return new HeadersHolder(headers);
    }

    public static HeadersHolder getInstance(String[] headers, boolean ignoreCase) {
        return new HeadersHolder(headers, ignoreCase);
    }
}

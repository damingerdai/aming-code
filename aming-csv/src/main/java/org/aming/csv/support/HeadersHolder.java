package org.aming.csv.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daming
 * @version 2017/12/9.
 */
public final class HeadersHolder {

    private String[] headers;

    private int length;

    private Map<String,Integer> indexByName;

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

    private HeadersHolder() {
        super();
        this.headers = new String[0];
        this.length = 0;
        this.indexByName = new HashMap<String, Integer>(length);
    }

    public static HeadersHolder getHeadersHolder() {
        return new HeadersHolder();
    }
}

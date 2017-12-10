package org.aming.csv.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author daming
 * @version 2017/12/9.
 */
public class HeadersHolder extends LinesHolder{

    private String[] headers;
    private Map<String,Integer> indexByName;
    private boolean init = false;

    @Override
    public String[] getLines() {
        return getHeaders();
    }


    @Override
    public int getIndex() {
        return 0;
    }


    public String[] getHeaders() {
        String[] clone = new String[headers.length];
        System.arraycopy(headers, 0, clone, 0, headers.length);
        return clone;
    }


    @Override
    public void nextLine(String[] nextLines) {

    }


    @Override
    public int getLength() {
        return length;
    }


    public HeadersHolder(String[] headers) {
        super();
        this.headers = new String[headers.length];
        System.arraycopy(this.headers, 0, headers, 0, this.headers.length);
        this.length = headers.length;
        initIndexByName();
    }

    private void initIndexByName() {
        if(indexByName == null) {
            indexByName = new HashMap<String, Integer>(length);
        }
        for(int i=0; i < headers.length; i++) {
            indexByName.put(headers[i], i);
        }
    }

    public static HeadersHolder getInstance(String[] headers) {
        return new HeadersHolder(headers);
    }


}

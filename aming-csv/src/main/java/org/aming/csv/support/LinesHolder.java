package org.aming.csv.support;

/**
 * @author daming
 * @version 2017/12/9.
 */
public class LinesHolder {

    private String[] lines;

    private int index;

    protected int length;

    public String[] getLines() {
        return lines;
    }

    public int getIndex() {
        return index;
    }


    public int getLength() {
        return length;
    }

    public void nextLine(String[] nextLines) {
        lines = new String[nextLines.length];
        System.arraycopy(nextLines, 0, this.lines, 0, nextLines.length);
        index ++;
        length = nextLines.length;
    }

    public LinesHolder() {
        super();
        this.index = 0;
        this.length = 0;
    }

    public static LinesHolder getInstance() {
        return new LinesHolder();
    }

}

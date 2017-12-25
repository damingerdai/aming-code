package org.aming.csv.support;

public class LinesHolder {

	private String[] lines;
	private int rowIndex;
	
	public String[] getLines() {
		return lines;
	}

	public int getRowIndex() {
		return rowIndex;
	}


	public LinesHolder() {
		super();
		lines = new String[0];
		rowIndex = 0;
	}
	

	public static LinesHolder getInstance() {
		return new LinesHolder();
	}
}
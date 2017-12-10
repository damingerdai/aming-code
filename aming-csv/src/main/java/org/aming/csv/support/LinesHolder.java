package org.aming.csv.support;

public class LinesHolder {
	private String[] lines;
	private int rowIndex;
	protected int length;
	
	public String[] getLines() {
		return lines;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public int getLength() {
		return length;
	}

	public LinesHolder() {
		super();
		lines = new String[0];
		length = 0;
		rowIndex = 0;
	}
	
	public LinesHolder(String[] lines, int rowIndex) {
		super();
		this.lines = new String[lines.length];
		System.arraycopy(lines.length, 0, this.lines, 0, lines.length);
		this.length = lines.length;
		this.rowIndex = rowIndex;
	}
	
	public static LinesHolder getInstance(String[] lines, int rowIndex) {
		return new LinesHolder(lines, rowIndex);
	}
	
	public static LinesHolder getInstance() {
		return new LinesHolder();
	}
}

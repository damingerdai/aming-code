package org.aming.csv.support;

import org.aming.core.utils.Assert;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

public class LinesHolder implements Serializable{

	private static final long serialVersionUID = 1420261833594808948L;

	protected final Optional<String[]> lines;
	private final int index;

	public String[] getLines() {
		return Arrays.copyOf(lines.get(), lines.get().length);
	}

	public int getIndex() {
		return index;
	}

	public LinesHolder(String[] lines, int index) {
		super();
		this.lines = Optional.of(lines);
		this.index = index;
	}

	public static LinesHolder getInstance(String[] lines, int index) {
		Assert.notNull(lines, "'lines' is required");
		Assert.notBlank(index, "'index' is requried", (i) -> { return i < 0; } );

		return new LinesHolder(lines, index);
	}

	public static LinesHolder getInstance() {
		return new LinesHolder(new String[0], 0);
	}
}
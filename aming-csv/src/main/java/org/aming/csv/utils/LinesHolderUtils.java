package org.aming.csv.utils;

import org.aming.csv.support.LinesHolder;

/**
 * @author daming
 * @version 2017/12/25.
 */
public class LinesHolderUtils {

    public static LinesHolder getLinesHolder(LinesHolder holder, String[] lines) {
        return LinesHolder.getInstance(lines, holder.getIndex() + 1);
    }
}

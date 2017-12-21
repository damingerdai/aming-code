package org.aming.csv.support;

import org.aming.csv.core.CsvWriter;

/**
 * @author daming
 * @version 2017/12/21.
 */
public interface ICsvWriterBuilder {

    void withBufferSize(int bufferSize);

    void withHeaders(String[] headers);

    CsvWriter build();
}

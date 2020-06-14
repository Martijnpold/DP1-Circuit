package com.mpolder.dp1.parse;

import java.io.IOException;
import java.util.List;

public interface IReader {
    /**
     * Read lines from reader
     *
     * @return List of strings within reader
     * @throws IOException Exception while reading from the reader
     */
    List<String> read() throws IOException;
}

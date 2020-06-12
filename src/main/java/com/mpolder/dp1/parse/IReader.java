package com.mpolder.dp1.parse;

import java.io.IOException;
import java.util.List;

public interface IReader {
    List<String> read() throws IOException;
}

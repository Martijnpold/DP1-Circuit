package com.mpolder.parse;

import java.io.IOException;
import java.util.List;

public interface IReader {
    List<String> read() throws IOException;
}

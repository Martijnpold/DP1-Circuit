package com.mpolder.dp1.test.parse;

import com.mpolder.dp1.parse.FileReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {
    @Test
    public void test_should_read_lines() throws IOException {
        List<String> expected = Arrays.asList(
                "firstLine",
                "secondLine"
        );

        FileReader reader = new FileReader(new File("test-circuits/reader/r1_simple.txt"));
        List<String> lines = reader.read();

        assertEquals(expected, lines);
    }

    @Test
    public void test_should_remove_comments() throws IOException {
        List<String> expected = Arrays.asList(
                "firstLine",
                "secondLine"
        );

        FileReader reader = new FileReader(new File("test-circuits/reader/r2_comments.txt"));
        List<String> lines = reader.read();

        assertEquals(expected, lines);
    }

    @Test
    public void test_should_remove_empty_lines() throws IOException {
        List<String> expected = Arrays.asList(
                "firstLine",
                "secondLine"
        );

        FileReader reader = new FileReader(new File("test-circuits/reader/r3_emptyline.txt"));
        List<String> lines = reader.read();

        assertEquals(expected, lines);
    }

    @Test
    public void test_should_remove_various() throws IOException {
        List<String> expected = Arrays.asList(
                "TestLineTabs",
                "TestLineSpaces",
                "EscapedLineOne",
                "EscapedLineTwo"
        );

        FileReader reader = new FileReader(new File("test-circuits/reader/r4_full.txt"));
        List<String> lines = reader.read();

        assertEquals(expected, lines);
    }
}

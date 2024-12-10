package dynamic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbbreviationTest {

    @Test
    void sampleTestCase0() {
        var result = Result.abbreviation("daBcd", "ABC");
        assertEquals("YES", result);
    }

    @Test
    void sampleTestCase1() {
        var result = Result.abbreviation("Pi", "P");
        assertEquals("YES", result);
    }

    @Test
    void sampleTestCase2() {
        var result = Result.abbreviation("AfPZN", "APZNC");
        assertEquals("NO", result);
    }

    @Test
    void sampleTestCase3() {
        var result = Result.abbreviation("LDJAN", "LJJM");
        assertEquals("NO", result);
    }

    @Test
    void sampleTestCase4() {
        var result = Result.abbreviation("UMKFW", "UMKFW");
        assertEquals("YES", result);
    }

    @Test
    void sampleTestCase5() {
        var result = Result.abbreviation("KXzQ", "K");
        assertEquals("NO", result);
    }

    @Test
    void sampleTestCase6() {
        var result = Result.abbreviation("LIT", "LIT");
        assertEquals("YES", result);
    }

    @Test
    void sampleTestCase7() {
        var result = Result.abbreviation("sYOCa", "YOCN");
        assertEquals("NO", result);
    }
}
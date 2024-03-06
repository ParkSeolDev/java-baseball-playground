package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_2number() {
        String[] strArr = "1,2".split(",");
        assertAll(() -> assertThat(strArr).contains("1"),
            () -> assertThat(strArr).contains("2"));
    }

    @Test
    void split_1number() {
        String[] strArr = "1".split(",");
        assertThat(strArr).contains("1");
    }

    @Test
    void remove_parentheses() {
        String givenStr = "(1,2)";
        String extractedStr = givenStr.substring(1, givenStr.length()-1);
        assertThat(extractedStr).isEqualTo("1,2");
    }
}

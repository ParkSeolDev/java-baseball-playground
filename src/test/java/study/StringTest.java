package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;
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

    @Test
    void charAt() {
        char specificLocationStr = "abc".charAt(0);
        assertThat(specificLocationStr).isEqualTo('a');
    }

    @DisplayName("범위를 넘어서는 인덱스에 접근함")
    @Test
    void charAt_IndexOutOfBounds() {
        String givenStr = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                char specificLocationStr = givenStr.charAt(givenStr.length());
            }).withMessageMatching("String index out of range: 3");
    }
}

package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NumericBallTest {

	@Test
	void numeric_ball_constructor_test() {
		assertDoesNotThrow(() -> {
			new NumericBall(1);
		});
	}

	@Test
	void numeric_ball_constructor_exception_test() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new NumericBall(0);
		});
	}
}

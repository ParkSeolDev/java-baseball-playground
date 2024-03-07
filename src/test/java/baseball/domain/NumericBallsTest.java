package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumericBallsTest {
	@Test
	void numeric_balls_constructor_test() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		assertDoesNotThrow(() -> {
			new NumericBalls(numbers);
		});
	}

	@Test
	void numeric_balls_constructor_exception_test() {
		List<Integer> numbers = List.of(1,2,3,4);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new NumericBalls(numbers);
		});
	}
}

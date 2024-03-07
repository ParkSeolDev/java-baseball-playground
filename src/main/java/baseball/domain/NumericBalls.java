package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class NumericBalls {
	private List<NumericBall> numericBalls;

	public NumericBalls(List<Integer> numbers) {
		validate(numbers);
		List<NumericBall> newBalls = new ArrayList<>();
		for (Integer number : numbers) {
			newBalls.add(new NumericBall(number));
		}
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException();
		}
	}
}

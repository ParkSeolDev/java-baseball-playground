package baseball.domain;

import java.util.Objects;

public class NumericBall {
	private Integer numericBall;
	public NumericBall(Integer number) {
		validate(number);
		this.numericBall = number;
	}

	private void validate(Integer number) {
		if (number < 1 || number > 9) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NumericBall that = (NumericBall)o;
		return Objects.equals(numericBall, that.numericBall);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numericBall);
	}
}

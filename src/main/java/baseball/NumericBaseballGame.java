package baseball;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.NumericBalls;
import baseball.util.RamdomNumberGenerator;

public class NumericBaseballGame {
	private static final Integer RAMDOM_NUMBER_GENERATOR = RamdomNumberGenerator.generate();
	public static void main(String[] args) {
		List<Integer> comNumbers = new ArrayList<>();
		comNumbers.add(RAMDOM_NUMBER_GENERATOR);
		comNumbers.add(RAMDOM_NUMBER_GENERATOR);
		comNumbers.add(RAMDOM_NUMBER_GENERATOR);

		NumericBalls comBalls = new NumericBalls(comNumbers);


	}
}

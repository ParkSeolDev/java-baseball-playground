package baseball;

import static baseball.view.InputView.*;
import static baseball.view.ResultView.*;

import java.util.ArrayList;
import java.util.List;

import baseball.domain.NumericBalls;
import baseball.util.RamdomNumberGenerator;

public class NumericBaseballGame {
	public static void main(String[] args) {
		System.out.println("시작");
		List<Integer> comNumbers = new ArrayList<>();
		comNumbers.add(RamdomNumberGenerator.generate());
		comNumbers.add(RamdomNumberGenerator.generate());
		comNumbers.add(RamdomNumberGenerator.generate());

		NumericBalls comBalls = new NumericBalls(comNumbers);
		NumericBalls myBalls = new NumericBalls();

		do {
			myBalls = new NumericBalls(inputNumbers());
		} while (printResult(myBalls.match(comBalls)).get(0) != 3);

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}
}

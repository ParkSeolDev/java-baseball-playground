package baseball.view;

import java.util.List;

public class ResultView {
	public static List<Integer> printResult(List<Integer> result) {
		if (result.get(0) != 0)
			System.out.println(result.get(0)+"스트라이크");
		if (result.get(1) != 0)
			System.out.println(result.get(1)+"볼");

		if (result.get(0) == 0 && result.get(1) == 0)
			System.out.println("Nothing");

		return result;
	}
}

package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	public static List<Integer> inputNumbers() {
		System.out.println("숫자를 입력해 주세요 : ");
		List<Integer> nums = new ArrayList<>();
		nums.addAll(parse(List.of(SCANNER.next().split(""))));
		return nums;
	}

	private static List<Integer> parse(List<String> strArr) {
		List<Integer> nums = new ArrayList<>();
		for (String str : strArr) {
			nums.add(Integer.parseInt(str));
		}
		return nums;
	}
}

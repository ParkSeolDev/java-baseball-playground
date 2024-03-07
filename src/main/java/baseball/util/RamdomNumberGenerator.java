package baseball.util;

import java.util.Random;

public class RamdomNumberGenerator {
	private static final Random RANDOM = new Random();

	public static Integer generate() {
		return RANDOM.nextInt(9) + 1;
	}
}

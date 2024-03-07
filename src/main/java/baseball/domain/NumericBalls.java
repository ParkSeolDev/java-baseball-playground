package baseball.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumericBalls implements Iterable {
	private List<NumericBall> numericBalls;

	public NumericBalls() {
		numericBalls = new ArrayList<>();
	}

	public NumericBalls(List<Integer> numbers) {
		validate(numbers);
		List<NumericBall> newBalls = new ArrayList<>();
		for (Integer number : numbers) {
			newBalls.add(new NumericBall(number));
		}
		this.numericBalls = newBalls;
	}

	private void validate(List<Integer> numbers) {
		if (numbers.size() != 3) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> match(NumericBalls otherBalls) {
		List<Integer> matchPoints = new ArrayList<>();
		int matchedCnt = matchBall(otherBalls);
		int strikeCnt = strikeCheck(otherBalls);
		matchPoints.add(strikeCnt);
		matchPoints.add(matchedCnt - strikeCnt);
		return matchPoints;
	}

	private Integer matchBall(NumericBalls otherBalls) {
		Map<Integer, Integer> map = new HashMap<>();
		for (NumericBall num : numericBalls) {
			map.put(num.numericBall(), 0);
		}

		int ballCnt = 0;

		Iterator otherIterator = otherBalls.iterator();
		while(otherIterator.hasNext()) {
			NumericBall otherBall = otherIterator.next();
			if (map.containsKey(otherBall.numericBall())) {
				map.put(otherBall.numericBall(), map.get(otherBall.numericBall()) + 1);
			}
		}
		for (Integer value : map.values()) {
			ballCnt += value;
		}
		return ballCnt;
	}

	private Integer strikeCheck(NumericBalls otherBalls) {
		int strikeCnt = 0;
		for (int i = 0; i < numericBalls.size(); i++) {
			if (numericBalls.get(i).equals(otherBalls.numericBall(i))) {
				strikeCnt++;
			}
		}
		return strikeCnt;
	}

	public NumericBall numericBall(int index) {
		return numericBalls.get(index);
	}

	public int size() {
		return numericBalls.size();
	}

	@Override
	public Iterator iterator() {
		return new NumericBallsIterator(this);
	}

	private static class NumericBallsIterator implements Iterator {
		private int index = 0;
		private NumericBalls numericBalls;

		public NumericBallsIterator(NumericBalls numericBalls) {
			this.numericBalls = numericBalls;
		}

		@Override
		public boolean hasNext() {
			return (this.index < this.numericBalls.size());
		}

		@Override
		public NumericBall next() {
			return numericBalls.numericBall(this.index++);
		}
	}
}

package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class NumericBalls implements Iterable {
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

	public List<Integer> match(NumericBalls otherBalls) {
		List<Integer> matchPoints = new ArrayList<>();
		int matchedCnt = matchBall(otherBalls);
		int strikeCnt = strikeCheck(otherBalls);
		matchPoints.add(strikeCnt);
		matchPoints.add(matchedCnt - strikeCnt);
		return matchPoints;
	}

	private Integer matchBall(NumericBalls otherBalls) {
		int ballCnt = 0;
		Iterator otherIterator = otherBalls.iterator();
		for (NumericBall myBall : numericBalls) {
			while(otherIterator.hasNext()) {
				NumericBall otherBall = otherIterator.next();
				if (myBall.equals(otherBall)) {
					ballCnt++;
				}
			}
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

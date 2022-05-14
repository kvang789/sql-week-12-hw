import java.util.Random;

public class TestDemo {

	public int addPostive(int a, int b) {
		if(a < 0 || b < 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		int power = randomInt * randomInt;
		return power;
	}
	public int getRandomInt() {
		Random random = new Random();
		  int randomInt = random.nextInt(10) + 1;
		return randomInt;

	}
}

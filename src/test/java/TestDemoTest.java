import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

class TestDemoTest {
	
	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
	testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if(!expectException) {
			  assertThat(testDemo.addPostive(a, b)).isEqualTo(expected);
			  
			} else {
				assertThatThrownBy(() -> 
			   testDemo.addPostive(a, b)).isInstanceOf(IllegalArgumentException.class);
			}
	}

	static private Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(
				arguments(0, 0, 0, false),
				arguments(-1, -4, 6, true),
				arguments(-6, 4, -2, true),
				arguments(2, 4, 6, false));
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		// Given:
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		// When:
		int fiveSquared = mockDemo.randomNumberSquared();
		
		// Then: 
		assertThat(fiveSquared).isEqualTo(25);
	}
}

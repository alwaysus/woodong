package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class EulerProblemTest {
	private Log log = LogFactory.getLog(EulerProblemTest.class);

	@Test
	public void problem_Number() {
		int baseNum = 10;//2000000;
		int divisor = 2;
		List<Integer> numList = new ArrayList<Integer>(baseNum);
		List<Integer> primeList = new ArrayList<Integer>(baseNum);

		for (int i = 1; i <= baseNum; i++) {
			primeList.add(i);
		}

		while (true) {
			numList = primeList;

			if (divisor >= numList.size()) {
				break;
			}

			for (int value : numList) {
				if (value > divisor && value % divisor == 0) {
					primeList.remove(value);
				}
			}

			if (divisor % 2 == 0) {
				divisor++;
			} else {
				divisor += 2;
			}
		}
	}

	@Test
	public void problem12_HighlyDivisibleTriangularNumber() {
		long value = 0;
		int add = 1;

		while (true) {
			long temp = value;
			int divisor = 2;
			int count = 1;
			int factorCount = 1;

			while (temp > 1) {
				if (temp % divisor == 0) {
					temp /= divisor;
					count++;
				} else {
					factorCount *= count;
					divisor++;
					count = 1;
				}

				if (temp == 1) {
					factorCount *= count;
				}
			}

			if (factorCount > 500) {
				log.info(String.format("%d - %d", value, factorCount));
				break;
			}

			value += add;
			add++;
		}
	}

	@Test
	public void s_problem11_LargestProductInAGrid() {}

	@Test
	public void problem10_SummationOfPrimes() {
		long sum = 2;
		boolean prime = true;

		for (int i = 3; i < 2000000; i += 2) {
			for (int j = 1; j < (i / 2); j += 2) {
				if (j > 1 && i % j == 0) {
					prime = false;
					break;
				}
			}

			if (prime) {
				sum += i;
			}

			prime = true;
		}

		log.info(sum);
	}

	@Test
	public void problem9_SpecialPythagoreanTriplet() {
		for (int c = 1000; c > 0; c--) {
			for (int b = (c - 1); b > 0; b--) {
				for (int a = (b - 1); a > 0; a--) {
					if ((a + b + c) == 1000) {
						if ((c * c) == (a * a) + (b * b)) {
							log.info(a * b * c);
							break;
						}
					}
				}
			}
		}
	}

	@Test
	public void problem8_LargestProductInASeries() {
		long product = 1;
		String productStr = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";

		for (int i = 0; i < 988; i++) {
			long num = 1;
			String temp = productStr.substring(i, i + 13);

			for (int j = 0; j < 13; j++) {
				num *= Integer.valueOf(temp.substring(j, j + 1));
			}

			if (num > product) {
				product = num;
			}
		}

		log.info(product);
	}

	@Test
	public void problem7_10001stPrime() {
		int prime = 1;
		int num = 1;

		for (int i = 3; ; i += 2) {
			for (int j = 1; j < (i / 2); j++) {
				if (j > 1 && i % j == 0) {
					prime = 0;
					break;
				}
			}

			if (prime > 0) {
				prime = i;
				num++;

				if (num == 10001) {
					break;
				}
			}

			prime = 1;
		}

		log.info(prime);
	}

	@Test
	public void problem6_SumSquareDifference() {
		int squareSum = 0;
		int sumSquare = 0;

		for (int i = 1; i <= 100; i++) {
			squareSum += (i * i);
			sumSquare += i;
		}

		log.info((sumSquare * sumSquare) - squareSum);
	}

	@Test
	public void problem5_SmallestMultiple() {
		boolean all = true;
		int result = 20;

		while (true) {
			for (int i = 20; i > 0; i--) {
				if (result % i > 0) {
					all = false;
					break;
				}
			}

			if (all == true) {
				break;
			}

			result += 20;
			all = true;
		}

		log.info(result);
	}

	@Test
	public void problem4_LargestPalindrome() {
		int palindrome = 0;
		int base = 999;

		while (base > 0) {
			String baseStr = String.valueOf(base);
			StringBuilder palindromeStr = new StringBuilder(baseStr).append(new StringBuilder(baseStr).reverse());
			palindrome = Integer.valueOf(palindromeStr.toString());

			for (int i = 999; i >= 100; i--) {
				if (palindrome % i == 0 && (palindrome / i) >= 100 && (palindrome / i) < 1000) {
					base = 0;
					break;
				}
			}

			base--;
		}

		log.info(palindrome);
	}

	@Test
	public void problem3_LargestPrimeFactor() {
		long base = 600851475143L;
		long factor = 2;

		while (factor < base) {
			if (base % factor == 0) {
				base = base / factor;
			} else {
				factor++;
			}
		}

		log.info(factor);
	}

	@Test
	public void problem2_EvenFibonacciNumbers() {
		int prev = 0;
		int next = 1;
		int result = 0;

		while (prev + next < 4000000) {
			int fibonacci = prev + next;

			if (fibonacci % 2 == 0) {
				result += fibonacci;
			}

			prev = next;
			next = fibonacci;
		}

		log.info(result);
	}

	@Test
	public void problem1_MultiplesOf3and5() {
		int result = 0;

		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				result += i;
			}
		}

		log.info(result);
	}
}
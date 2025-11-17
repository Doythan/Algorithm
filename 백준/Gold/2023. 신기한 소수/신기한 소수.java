import java.util.*;
import java.io.*;

public class Main {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	static void dfs(int number, int jarisu) {
		if (jarisu == n) {
			if(isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for (int i=0; i<10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (isPrime(number * 10 + i)) {
				dfs(number*10+i, jarisu + 1);
			}
		}
	}
	
	static boolean isPrime(int num) {
		for (int i=2; i<=num/2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}







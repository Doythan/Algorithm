import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int absA = Math.abs(a);
			int absB = Math.abs(b);
			if (absA != absB) return absA - absB;
			return a - b;
		});
		
		for (int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) {
				if (pq.isEmpty())
					System.out.println("0");
				else
					System.out.println(pq.poll());
			} else {
				pq.add(request);
			}
		}
	}
}
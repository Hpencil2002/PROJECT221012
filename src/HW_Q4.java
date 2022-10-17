import java.util.*;

public class HW_Q4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		
		while (true) {
			int sum = 0;
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
			int n = scanner.nextInt();
			if (n == 0) break;
			
			v.add(n);
			for (int i = 0; i < v.size(); i++) {
				System.out.print(v.get(i) + " ");
				sum += v.get(i);
			}
			System.out.println();
			System.out.println("현재 평균 " + sum / v.size());
		}
		
		scanner.close();
	}

}

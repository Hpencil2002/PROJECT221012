import java.util.*;

public class HW_Q2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Character> array = new ArrayList<Character>();
		
		System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
		for (int i = 0; i < 6; i++) {
			char grade = scanner.next().charAt(0);
			array.add(grade);
		}
		
		double sum = 0;
		for (int i = 0; i < 6; i++) {
			if (array.get(i).equals('A')) sum += 4.0;
			else if (array.get(i).equals('B')) sum += 3.0;
			else if (array.get(i).equals('C')) sum += 2.0;
			else if (array.get(i).equals('D')) sum += 1.0;
			else if (array.get(i).equals('F')) sum += 0;
		}
		System.out.println(sum / 6);
		
		scanner.close();
	}

}

import java.util.*;

class Word2 {
	private String eng;
	private String kor;
	
	public Word2(String eng, String kor) {
		this.eng = eng; this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public String getKor() {
		return kor;
	}
}

public class HW_Q12 {
	Scanner scanner = new Scanner(System.in);
	private String name;
	private Vector<Word> v;
	
	public HW_Q12(String name) {
		this.name = name;
		v = new Vector<Word>();
		
		v.add(new Word("love", "사랑"));
		v.add(new Word("animal", "동물"));
		v.add(new Word("emotion", "감정"));
		v.add(new Word("human", "인간"));
		v.add(new Word("stock", "주식"));
		v.add(new Word("trade", "거래"));
		v.add(new Word("society", "사회"));
		v.add(new Word("baby", "아기"));
		v.add(new Word("honey", "꿀"));
		v.add(new Word("doll", "인형"));
		v.add(new Word("bear", "곰"));
		v.add(new Word("picture", "그림"));
		v.add(new Word("painting", "오류"));
		v.add(new Word("fault", "잘못"));
		v.add(new Word("example", "예시"));
		v.add(new Word("eye", "눈"));
		v.add(new Word("statue", "조각상"));
	}
	private int makeEx(int ex[], int answerIndex) {
		int n[] = {-1, -1, -1, -1};
		int index;
		for (int i = 0; i < n.length; i++) {
			do {
				index = (int)(Math.random()*v.size());
			} while (index == answerIndex || exists(n, index));
			n[i] = index;
		}
		
		for (int i = 0; i < n.length; i++)
			ex[i] = n[i];
		
		return (int)(Math.random()*n.length);
	}
	private boolean exists(int n[], int index) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == index)
				return true;
		}
		return false;
	}
	public void quiz() {
		System.out.println("현재 " + v.size() + "개의 단어가 들어있습니다. -1을 입력하면 테스트를 종료합니다.");
		while (true) {
			int answerIndex = (int)(Math.random()*v.size());
			String eng = v.get(answerIndex).getEng();
			
			int example[] = new int[4];
			
			int answerLoc = makeEx(example, answerIndex);
			example[answerLoc] = answerIndex;
			
			System.out.println(eng + "?");
			for (int i = 0; i < example.length; i++)
				System.out.print("(" + (i + 1) + ")" + v.get(example[i]).getKor() + " ");
			
			System.out.print(":>");
			try {
				int in = scanner.nextInt();
				if (in == -1) {
					System.out.println();
					break;
				}
				
				in -= 1;
				if (in == answerLoc)
					System.out.println("Excellent !!");
				else
					System.out.println("No. !!");
			} catch (InputMismatchException e) {
				scanner.next();
				System.out.println("숫자를 입력하세요 !!");
			}
		}
	}
	private boolean contains(String eng) {
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).getEng().equals(eng))
				return true;
		}
		return false;
	}
	public void insert() {
		System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
		while (true) {
			System.out.print("영어 한글 입력 >> ");
			String eng = scanner.next();
			if (eng.equals("그만")) {
				System.out.println();
				break;
			}
			String kor = scanner.next();
			
			if (contains(eng)) {
				System.out.println(eng + "는 이미 있습니다!");
				continue;
			}
			
			v.add(new Word(eng, kor));
		}
	}
	public void run() {
		System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
		while (true) {
			System.out.print("단어 테스트:1, 단어 삽입:2, 종료:3>> ");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				quiz(); break;
			case 2:
				insert(); break;
			case 3:
				scanner.close();
				System.out.println("\"" + name + "\"를 종료합니다.");
				return;
			}
		}
	}

	public static void main(String[] args) {
		HW_Q12 quiz = new HW_Q12("명품영어");
		quiz.run();
	}

}

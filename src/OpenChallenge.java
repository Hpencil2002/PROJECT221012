import java.util.*;

class Word {
	private String eng;
	private String kor;
	
	public Word(String eng, String kor) {
		this.eng = eng; this.kor = kor;
	}
	public String getEng() {
		return eng;
	}
	public String getKor() {
		return kor;
	}
}

public class OpenChallenge {
	Scanner scanner = new Scanner(System.in);
	Vector<Word> v = new Vector<Word>();
	Random rand = new Random();
	final int MAX_CHOICE = 4;
	int[] question = new int[MAX_CHOICE];
	
	public OpenChallenge() {
		setVector();
		System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
		System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
		game();
	}
	public void game() {
		while (true) {
			setChoice();
			int answerNum = rand.nextInt(4);
			int answerIndex = question[answerNum];
			
			System.out.println(v.get(answerIndex).getEng() + "?");
			
			for (int i = 0; i < question.length; i++) {
				System.out.print("(" + (i + 1) + ")");
				System.out.print(v.get(question[i]).getKor() + " ");
			}
			System.out.print(">> ");
			
			int choice = scanner.nextInt();
			if (choice == -1) {
				System.out.println("\"명품영어\"를 종료합니다...");
				break;
			}
			else if (choice - 1 == answerNum)
				System.out.println("Excellent !!");
			else
				System.out.println("No. !!");
		}
	}
	public void setChoice() {
		for (int i = 0; i < MAX_CHOICE; i++) {
			question[i] = rand.nextInt(v.size());
			for (int j = 0; j < i; j++) 
				if (question[i] == question[j]) {
					i--;
					continue;
				}
		}
	}
	public void setVector() {
		v.add(new Word("constructor", "생성자"));
		v.add(new Word("overriding", "재정의"));
		v.add(new Word("extends", "상속"));
		v.add(new Word("array", "배열"));
		v.add(new Word("string", "문자열"));
		v.add(new Word("character", "문자"));
		v.add(new Word("integer", "정수"));
		v.add(new Word("double", "실수"));
		v.add(new Word("abstract", "추상"));
		v.add(new Word("implements", "구현하다"));
	}

	public static void main(String[] args) {
		new OpenChallenge();
	}

}

import java.util.*;

public class KUT1024 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String F = in.nextLine();
		ArrayList<Character> ops = new ArrayList<>();
		ArrayList<Integer> numbers = new ArrayList<>();
		int number = 0;
		
		for(int i = 0; i < F.length(); i++) {
			char c = F.charAt(i);
			if(c >= '0' && c <= '9') number = number*10 + c-'0';
			else {
				numbers.add(number);
				number = 0;
				ops.add(c);
			}
		}
		numbers.add(number);
		
		int answer = numbers.remove(0);
		while(!numbers.isEmpty()) {
			char op = ops.remove(0);
			int num = numbers.remove(0);
			if(op == '+') answer += num;
			else answer -= num;
		}
		System.out.println(answer);
	}
}

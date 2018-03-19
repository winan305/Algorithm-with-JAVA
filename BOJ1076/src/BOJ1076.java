import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Registance {
	String color, val, mul;
	
	public Registance(String color, String val, String mul) {
		this.color = color;
		this.val = val;
		this.mul = mul;
	}
}

public class BOJ1076 {
	static BufferedReader in;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		ArrayList<Registance> list = new ArrayList<>();
		list.add(new Registance("black", "0", "1"));
		list.add(new Registance("brown", "1", "10"));
		list.add(new Registance("red", "2", "100"));
		list.add(new Registance("orange", "3", "1000"));
		list.add(new Registance("yellow", "4", "10000"));
		list.add(new Registance("green", "5", "100000"));
		list.add(new Registance("blue", "6", "1000000"));
		list.add(new Registance("violet", "7", "10000000"));
		list.add(new Registance("grey", "8", "100000000"));
		list.add(new Registance("white", "9", "1000000000"));
		
		in = new BufferedReader(new InputStreamReader(System.in));
		BigInteger registance = new BigInteger("0");
		
		for(int i = 0; i < 3; i++) {
			String color = in.readLine();
			for(int j = 0; j < 10; j++) {
				Registance item = list.get(j);
				if(item.color.equals(color)) {
					if(i < 2) {
						registance = registance.multiply(new BigInteger("10"));
						registance = registance.add(new BigInteger(item.val));
					}
					else registance = registance.multiply(new BigInteger(item.mul));
				}
			}
		}
		System.out.println(registance);
	}
}

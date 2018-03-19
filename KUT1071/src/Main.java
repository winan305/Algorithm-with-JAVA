import java.io.*;

enum Item {
	Club, Manger, Player, Sponsr, Stadium
}

public class Main {
	public static void main(String[] args) {
		Item item;
		Item i = Item.Manger;
		System.out.println(i.toString());
	}
}


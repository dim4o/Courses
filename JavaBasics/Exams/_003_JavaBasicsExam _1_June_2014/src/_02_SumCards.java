import java.util.ArrayList;
import java.util.Scanner;

//10:27 -- 11:26 --> 1h, 100/100 от втория път. Ня бях предвидил сличая, когато се подава само една карта. 
//Тогава и двата листа остават празни и програмата въща 0, а трябва да връща стойността на картата
//Задачи:
//1. Да се намери по-кратък начин за сумиране на листове
//2. Да се измисли по-кратко решение на задачата
public class _02_SumCards {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String cardsString = input.nextLine();
		String[] cards =  cardsString.split("[S C D H ]+");
		//System.out.println(Arrays.toString(cards));
		ArrayList<Integer> equals = new ArrayList<Integer>();
		ArrayList<Integer> notEquals = new ArrayList<Integer>();
		boolean eq = false;
		for (int i = 0; i < cards.length - 1; i++) {
			
			if (cards[i].equals(cards[i+1])) {
				equals.add(getValue(cards[i]));
				eq = true;
			} else if (eq == true) {
				equals.add(getValue(cards[i]));
				eq = false;
			} else {
				notEquals.add(getValue(cards[i]));
				eq = false;
			}
			if (i == cards.length - 2 && eq == true ) {
				equals.add(getValue(cards[i + 1]));
			}
			if (i == cards.length - 2 && eq == false ) {
				notEquals.add(getValue(cards[i + 1]));
			} 
		}
		//System.out.println(equals.toString());
		//System.out.println(notEquals.toString());
		int sum1 = 0;
		for (Integer integer : equals) {
			sum1+= integer;
		}
		int sum2 = 0;
	    for (Integer integer : notEquals) {
	    	sum2+= integer;
		}
	    if (equals.size() == 0 && notEquals.size() == 0) {
			System.out.println(getValue(cards[0]));
		} else {
			System.out.println(2*sum1+sum2);
		}
	}
	public static int getValue(String card){
		int value = 0;
		switch (card) {
		case "2":value = 2;break;
		case "3":value = 3;break;
		case "4":value = 4;break;
		case "5":value = 5;break;
		case "6":value = 6;break;
		case "7":value = 7;break;
		case "8":value = 8;break;
		case "9":value = 9;break;
		case "10":value = 10;break;
		case "J":value = 12;break;
		case "Q":value = 13;break;
		case "K":value = 14;break;
		case "A":value = 15;break;
		}
		return value;		
	}

}

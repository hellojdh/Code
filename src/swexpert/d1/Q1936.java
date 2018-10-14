package swexpert.d1;

import java.util.Scanner;

public class Q1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String result = "";
		switch (a) {
		case 1: result = b==2?"B":"A"; break;
		case 2:	result = b==3?"B":"A"; break;
		case 3: result = b==1?"B":"A"; break;
		}
		System.out.println(result);
	}
}

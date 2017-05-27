package ru.rambler.skanerxxl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("input number n");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		CorrectBracketSequences cbs = new CorrectBracketSequences();
		cbs.generateCorrectBracketSequences(n);
		cbs.toConsole();
		System.out.println(cbs.size());
	}
}

package ru.rambler.skanerxxl;

import java.util.HashSet;
import java.util.Set;

public class CorrectBracketSequences {

	private Set<String> setSequences;
	private char[] initialSequence;

	public CorrectBracketSequences() {
		/**
		 * HashSet the collection guarantees that there will not be duplicate
		 * sequences
		 */
		this.setSequences = new HashSet<>();
	}

	public int size() {
		return this.setSequences.size();
	}

	public void toConsole() {
		for (String sequences : this.setSequences)
			System.out.println(sequences);
	}

	public Set<String> getSetCorrectBracketSequences() {
		return this.setSequences;
	}

	/**
	 * generate the set correct bracket sequences
	 */
	public void generateCorrectBracketSequences(int n) {
		this.initialSequence = createInitialSequence(n);

		/**
		 * additional variables necessary for permutations of the set
		 */
		int index = 0;
		int[] arrayOfIndexes = new int[initialSequence.length];
		boolean[] arrayBoolen = new boolean[initialSequence.length];

		permutation(index, arrayOfIndexes, arrayBoolen);
	}

	/**
	 * Create an initial sequence with a number n of closing and opening
	 * parentheses
	 */
	private char[] createInitialSequence(int n) {
		int length = n * 2;
		char[] array = new char[length];

		for (int i = 0; i < length; i++) {
			if (i <= n - 1)
				array[i] = '(';
			else
				array[i] = ')';
		}
		return array;
	}

	/**
	 * производим все возможные перестановки множества, для этого используем
	 * рекурсивный метод
	 */
	private void permutation(int index, int[] arrayOfIndexes, boolean[] arrayBoolen) {
		char[] array = new char[initialSequence.length];

		if (index == initialSequence.length) {
			for (int i = 0; i < arrayOfIndexes.length; i++) {
				array[i] = initialSequence[arrayOfIndexes[i]];
			}

			if (checkSequence(array)) {
				setSequences.add(new String(array));
			}

			return;
		}
		for (int i = 0; i < initialSequence.length; i++) {
			if (!arrayBoolen[i]) {
				arrayBoolen[i] = true;
				arrayOfIndexes[index] = i;

				permutation(index + 1, arrayOfIndexes, arrayBoolen);

				arrayBoolen[i] = false;
			}
		}
	}

	/**
	 * производим проверку сгенерированной последовательности на правильность
	 */
	private boolean checkSequence(char[] array) {
		if (array[0] == ')')
			return false;

		if (array[array.length - 1] == '(')
			return false;

		int flag = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '(')
				flag++;
			if (array[i] == ')')
				flag--;
			if (flag == -1) {
				/**
				 * если встречается закрывающяя скобка, для которой нет
				 * соответствующей открывающей то это означает, что скобочное
				 * выражение не правильное
				 */
				return false;
			}

		}
		if (flag > 0)
			return false;

		if (flag == 0)
			return true;

		return false;
	}
}

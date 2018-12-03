/**
 * 
 */
package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pooja
 *need to replace the default file path 
 	Selecting default files with d
 	this will not work unless you replace the default file path
 
 *When running program with large file size, gives error of " java.lang.OutOfMemoryError: Java heap space "
  Run Java with the command-line option -Xmx, which sets the maximum size of the heap.
  To set maximum size of the heap follow these steps:
 1	Right mouse click on

 2	Run As - Run Configuration - Arguments - Vm Arguments, 
	
 3	then add this

	" -Xmx2048m " or more if required.
 *
 */
public class LCSonFiles {

	/**
	 * @param args
	 */

	String T[];

	public static void main(String[] args) {
		String TEXT = null;
		String panel = null;
		Scanner sc = new Scanner(System.in);
		System.out.println(" INFO: You need to enter 2 string or select 2 files");
		System.out.println(" INFO: press f for selecting files");
		System.out.println(" INFO: press d for selecting default files");
		System.out.println("Would you like to enter TEXT? (y/n/d/)=(yes/no/defalt/file)");
		String s = sc.nextLine().toString();
		if (s.equals("y")) {
			System.out.println("Enter TEXT :");
			TEXT = new Scanner(System.in).nextLine();
			TEXT = ReadFileToString.preprocessString(TEXT);
			System.out.println("Enter Panel String :");
			panel = new Scanner(System.in).nextLine();
			panel = ReadFileToString.preprocessString(panel);
			LCS(TEXT, panel);
		} else if (s.equals("d")) {
			//replace the default file path
			System.out.println("Selecting default File for  TEXT:");
			TEXT = ReadFileToString.readingFile("E:/Concordia/Fall/data/The_State_of_Data_Final.txt");
			System.out.println("Selecting default File for Panel String:");
			panel = ReadFileToString.readingFile("E:/Concordia/Fall/data/Panel-The-State-of-Data.txt");
			LCS(TEXT, panel);
		} else if (s.equals("n") || s.equals("f")) {
			System.out.println("Select File for  TEXT:");
			TEXT = FileSelecter.fsDialog();
			System.out.println("Select File for Panel String:");
			panel = FileSelecter.fsDialog();
			LCS(TEXT, panel);
		} else {
			System.out.println("Selecting default TEXT: bipincdesai");
			TEXT = ReadFileToString.preprocessString("bipincdesai");
			System.out.println("Selecting default  Panel String: ebcdicbcd");
			panel = ReadFileToString.preprocessString("ebcdicbcd");
			LCS(TEXT, panel);
		}
	}

	private static void LCS(String TEXT, String panel) {
		if (TEXT.isEmpty() || panel.isEmpty()) {
			System.out.println("null string passed");
		} else {
			char T[] = TEXT.toCharArray();
			System.out.println(Arrays.toString(T));
			char S[] = panel.toCharArray();
			System.out.println(Arrays.toString(S));
			int c[][] = new int[T.length][S.length]; // int table
			char b[][] = new char[T.length][T.length]; // char table

			for (int i = 0; i < T.length; i++) {
				c[i][0] = 0; // set first column to 0
				for (int j = 0; j < S.length; j++) {
					c[0][j] = 0; // set the first row to 0
				}
			}
			for (int i = 1; i < T.length; i++) {
				for (int j = 1; j < S.length; j++) {
					if (S[j] == T[i]) { // compare ith characters of the string
										// S and T
						c[i][j] = c[i - 1][j - 1] + 1;
					} else if (c[i - 1][j] >= (c[i][j - 1] + 1)) {
						c[i][j] = c[i - 1][j];
					} else {
						c[i][j] = c[i][j - 1];
					}
				}
			}

			List<String> ListCS = traverseIntTable(T, S, T.length - 1, S.length - 1, c);
			// store it in set because to remove redundancy
			System.out.print(new HashSet<>(ListCS));
		}
	}

	private static List<String> traverseIntTable(char[] T, char[] S, int col, int row, int[][] c) {
		// TODO Auto-generated method stub
		if (col == 0 || row == 0) { // create a List with 1 empty string and
									// return
			return new ArrayList<>(Collections.nCopies(1, ""));
		}
		// bottom-up
		if (T[col] == S[row]) {
			List<String> l = traverseIntTable(T, S, col - 1, row - 1, c);
			for (int i = 0; i < l.size(); i++) {
				l.set(i, l.get(i) + T[col]);
			}
			return l;
		}
		// In char table check MAX value from value above and on left

		if (c[col - 1][row] > c[col][row - 1]) {
			return traverseIntTable(T, S, col - 1, row, c);
		}
		if (c[col][row - 1] > c[col - 1][row]) {
			return traverseIntTable(T, S, col, row - 1, c);
		}
		// else if MATCH

		List<String> up = traverseIntTable(T, S, col - 1, row, c);
		List<String> right = traverseIntTable(T, S, col, row - 1, c);
		up.addAll(right);
		// append left to top
		return up;
	}
}

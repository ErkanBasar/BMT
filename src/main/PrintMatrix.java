package main;

import java.text.DecimalFormat;

public class PrintMatrix {

	private static void printMatrix(int[][] matrix) {
		
		DecimalFormat fmt = new DecimalFormat("00");

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(fmt.format(matrix[row][col]) + " ");
			}
			System.out.println();
		}
	}
}
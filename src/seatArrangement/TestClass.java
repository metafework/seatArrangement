package seatArrangement;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

public class TestClass {
	static Theatre firstTheatre = new Theatre(5, 5);
	static Scanner scanner = new Scanner(System.in);
	static boolean isDone = false;
	static Exception IllegalInputException = new Exception();

	public static int[] promptForSeat(Scanner scanner) {

		int row = 0;
		int column = 0;
		System.out.println("Which seat do you want to Reserve?");
		System.out.println("Row:");
		// scanner.nextLine();
		try {
			row = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Unexpected input.");

			promptForSeat(scanner);
		}
		// System.out.println(row);
		if (row > 5 || row < 1) {
			System.out.println("Row " + row + " does not exist. Try again");

			promptForSeat(scanner);
		}
		System.out.println("Column:");
		try {
			column = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("Unexpected input.Try again");
			promptForSeat(scanner);
		}
		if (column > 5 || column < 1) {
			System.out.println("Column " + column + " does not exist. Try again");
			promptForSeat(scanner);
		}
		int[] output = { row, column };

		return output;

	}

	public static void terminatorCond(boolean done) throws IOException {
		System.out.println("Enter 1 to exit or 0 to reserve another seat. ");
		try {
			// int inputSelection= scanner.nextInt();
			if (scanner.nextInt() == 0) {
				done = true;
			} else if (scanner.nextInt() == 1) {
				done = false;
				scanner.close();
				System.exit(0);
			}
			if (scanner.nextInt() != 0 && scanner.nextInt() != 1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Unexpected input. Try again");
			terminatorCond(isDone);
		}

	}

	public static void namePrompt(Scanner scanner) throws Exception {
		System.out.println("Please enter seat occupants' name: ");
		String input = scanner.next();
		Pattern pattern = Pattern.compile("^[A-Za-z]++$");
		if (!pattern.matcher(input).matches()) {
			throw new IllegalArgumentException("Invalid String");
		}
	}

	public static void reserver(int[] seat) {
		int seatRow = seat[0] - 1;
		int seatColumn = seat[1] - 1;
		if (firstTheatre.getSeat(seatRow, seatColumn).available) {
			// namePrompt(scanner);
			firstTheatre.setSeatToReserved(seatRow, seatColumn);
			// System.out.println("Seat at row " + (seatRow + 1) + " column " + (seatColumn
			// + 1) + " reserved.");
		} else {
			System.out.println("Seat in unavailable.");
		}
	}

	public static void view(Theatre firstTheatre) {
		System.out.println("   1  2  3  4  5");
		System.out.println("  ______________");
		for (int i = 0; i < firstTheatre.totalRows; i++) {
			System.out.print(i + 1 + "| ");
			for (int j = 0; j < firstTheatre.totalCols; j++) {
				if (firstTheatre.getSeat(i, j).available) {
					System.out.print("O  ");
				} else {
					System.out.print("X  ");
				}
				// System.out.print(firstTheatre.getSeat(i,j).available);
			}
			System.out.println("");

			// System.out.println("_________________");
		}
	}

	public static void main(String[] args) {

		////// Seat tests//////

		/*
		 * Seat firstSeat=new Seat(2,3);
		 * System.out.println(firstSeat.getColNum());
		 */
		// Seat secondSeat=new Seat(1,2);
		// System.out.println(secondSeat.getColNum());
		// System.out.println(firstSeat.getColNum());
		// System.out.println(secondSeat.toString());

		////// Theatre tests/////

		/*
		 * Theatre firstTheatre=new Theatre(5,3);
		 * System.out.println(firstTheatre.getTotalRows());// 5
		 * System.out.println(firstTheatre.getTotalCols());// 3
		 */

		// Theatre firstTheatre=new Theatre(5,5);
		// Scanner scanner=new Scanner(System.in);
		// System.out.print("First theatre output: \n"+firstTheatre.toString());

		// String [][] ftheatreStringMatrix=firstTheatre.seatMatrixStrRep();
		/*
		 * System.out.println("   1  2  3  4  5");
		 * System.out.println("  ______________");
		 * for(int i=0;i<firstTheatre.totalRows;i++) {
		 * System.out.print(i+1+"| ");
		 * for(int j=0;j<firstTheatre.totalCols;j++) {
		 * if (firstTheatre.getSeat(i,j).available) {
		 * System.out.print("O  ");
		 * }else {System.out.print("X  ");}
		 * //System.out.print(firstTheatre.getSeat(i,j).available);
		 * }
		 * System.out.println("");
		 * 
		 * //System.out.println("_________________");
		 * }
		 */
		// boolean alwaysTrue=true;
		while (!isDone) {
			view(firstTheatre);
			reserver(promptForSeat(scanner));
			try {
				namePrompt(scanner);
				view(firstTheatre);
				terminatorCond(isDone);
			} catch (Exception e) {
				System.out.println("Illegal input");
			}

		}
		// scanner.close();
		// view(firstTheatre);

	}

}

package seatArrangement;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TestClass {
	static Theatre firstTheatre=new Theatre(5,5);
	static Scanner scanner=new Scanner(System.in);
	public static int[] promptForSeat(Scanner scanner) {
		
		int row=0;
		int column=0;
		System.out.println("Row:");
		//scanner.nextLine();
		try{
			row=scanner.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Unexpected input.");
			
			promptForSeat(scanner);
		}
		//System.out.println(row);
		if (row>5||row<1) {
			System.out.println("Row " + row +" does not exist. Try again" );
			
			promptForSeat(scanner);
		}
		System.out.println("Column:");
		try{
			column=scanner.nextInt();
		}catch(Exception e) {
			System.out.println("Unexpected input.Try again");
			promptForSeat(scanner);
		}
		if (column>5||column<1) {
			System.out.println("Column " + column +" does not exist. Try again" );
			promptForSeat(scanner);
		}
		int []output= {row,column};
		
		return output;
		
	}
	public static void namePrompt() {
		Scanner scanner=new Scanner(System.in);
		
		
		scanner.close();
	}
	public static void reserver(int [] seat) {
		int seatRow=seat[0]-1;
		int seatColumn=seat[1]-1;
		if (firstTheatre.getSeat(seatRow, seatColumn).available) {
			firstTheatre.setSeatToReserved(seatRow, seatColumn);
			System.out.println("Seat at row " +(seatRow+1)+" column "+(seatColumn+1)+ " reserved.");
		}else {
			System.out.println("Seat in unavailable.");
		}
	}
	public static void view(Theatre firstTheatre) {
		System.out.println("   1  2  3  4  5");
		System.out.println("  ______________");
		for(int i=0;i<firstTheatre.totalRows;i++) {
			System.out.print(i+1+"| ");
			for(int j=0;j<firstTheatre.totalCols;j++) {
				if (firstTheatre.getSeat(i,j).available) {
					System.out.print("O  ");
				}else {System.out.print("X  ");}
				//System.out.print(firstTheatre.getSeat(i,j).available);
			}
			System.out.println("");
			
			//System.out.println("_________________");
		}
	}

	public static void main(String[] args) {
		
		//////Seat tests//////
		
		/*Seat firstSeat=new Seat(2,3);
		System.out.println(firstSeat.getColNum());
		*/
		//Seat secondSeat=new Seat(1,2);
		//System.out.println(secondSeat.getColNum());
		//System.out.println(firstSeat.getColNum());
		//System.out.println(secondSeat.toString());
		
		//////Theatre tests/////
		
		/*Theatre firstTheatre=new Theatre(5,3);
		System.out.println(firstTheatre.getTotalRows());// 5
		System.out.println(firstTheatre.getTotalCols());// 3*/
		
		//Theatre firstTheatre=new Theatre(5,5);
		//Scanner scanner=new Scanner(System.in);
		//System.out.print("First theatre output: \n"+firstTheatre.toString());
		
		//String [][] ftheatreStringMatrix=firstTheatre.seatMatrixStrRep();
		/*System.out.println("   1  2  3  4  5");
		System.out.println("  ______________");
		for(int i=0;i<firstTheatre.totalRows;i++) {
			System.out.print(i+1+"| ");
			for(int j=0;j<firstTheatre.totalCols;j++) {
				if (firstTheatre.getSeat(i,j).available) {
					System.out.print("O  ");
				}else {System.out.print("X  ");}
				//System.out.print(firstTheatre.getSeat(i,j).available);
			}
			System.out.println("");
			
			//System.out.println("_________________");
		}	*/
		//boolean alwaysTrue=true;
		while(true) {
			view(firstTheatre);
			System.out.println("Which seat do you want to Reserve?");
			
			reserver(promptForSeat(scanner));
			
		}
		//scanner.close();
		//view(firstTheatre);
		
	}

}

package seatArrangement;

import java.util.Arrays;

public class Theatre {
	int totalCols;
	int totalRows;
	Seat [][] seatMatrix=new Seat[totalRows][totalCols];
	
	
	public Theatre() {
		totalRows=this.totalRows;
		totalCols=this.totalCols;
		Seat [][] seatMatrix=this.seatMatrix;
		
	}
	
	public Theatre(int rows, int cols) {
		this.totalRows=rows;
		this.totalCols=cols;
		this.seatMatrix=seatMatrixGen();
	}
	
	//Create matrix of seats in the theatre.
	public Seat[][] seatMatrixGen(){
		Seat [][] seatMatrix=new Seat[totalRows][totalCols];
		for (int i=0;i<this.totalRows;i++) {
			for(int j=0;j<this.totalCols;j++) {
				Seat seat=new Seat(i+1,j+1);
				seatMatrix[i][j]=seat;
			}
		}
		return seatMatrix;
	}
	
	//Create string representation of seats in the theatre.
	public String [][] seatMatrixStrRep(){
		String [][] seatMatrixStr=new String [this.totalRows][this.totalCols];
		for(int i=0;i<this.totalRows;i++) {
			for(int j=0;j<this.totalCols;j++) {
				//seatMatrixStr[i][j]=this.seatMatrix[i][j].toString();
				if(this.seatMatrix[i][j].isAvailable()) {
					seatMatrixStr[i][j]=seatMatrixStr[i][j]+" (Open)";
				}else {seatMatrixStr[i][j]=seatMatrixStr[i][j]+" (N/A )";}
			}
		}
		return seatMatrixStr;
	}
	
	public Seat getSeat(int row,int col) {
		return this.seatMatrix[row][col];
	}
	
	public void setSeatToReserved(int row,int col) {
		this.seatMatrix[row][col].setavailable(false);
	}
	public String toString() {
		return Arrays.deepToString(seatMatrixStrRep());
	}
	public int getTotalCols() {
		return totalCols;
	}

	public void setTotalCols(int totalCols) {
		this.totalCols = totalCols;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
}

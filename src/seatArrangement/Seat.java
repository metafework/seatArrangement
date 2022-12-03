package seatArrangement;

public class Seat {
	
	boolean available;
	int rowNum;
	int colNum;
	
	public Seat() {
		available=true;
		rowNum=this.rowNum;
		colNum=this.colNum;
		
	}
	
	public Seat(int row,int col) {
		available=true;
		rowNum=row;
		colNum=col;	}
	
	public String toString() {
		String stringRepres="|R"+this.rowNum+"C"+this.colNum+" ";
		
		return stringRepres;
	}
	

	public boolean isAvailable() {
		return this.available;
	}

	public void setavailable(boolean available) {
		this.available = available;
	}

	public int getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColNum() {
		return this.colNum;
	}

	public void setColNum(int colNum) {
		this.colNum = colNum;
	}
	
	
	
}

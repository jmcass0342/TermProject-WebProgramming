package finalProject.entity;


public class Program {
	private int id;
	private int day1;
	private int day2;
	private int day3;
	
	public Program() {
		id = -1;
		day1 = -1;
		day2 = -1;
		day3 = -1;
	}

	public Program(int id, int day1, int day2, int day3) {
		this.id = id;
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getDay1() {
		return day1;
	}




	public void setDay1(int day1) {
		this.day1 = day1;
	}




	public int getDay2() {
		return day2;
	}




	public void setDay2(int day2) {
		this.day2 = day2;
	}




	public int getDay3() {
		return day3;
	}


	public void setDay3(int day3) {
		this.day3 = day3;
	}	

}

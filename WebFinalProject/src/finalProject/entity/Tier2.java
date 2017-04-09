package finalProject.entity;

public class Tier2 {
	private int id;
	private int exercise1;
	private int exercise2;
	private int exercise3;
	
	public Tier2() {
		this.id = -1;
		this.exercise1 = 0;
		this.exercise2 = 0;
		this.exercise3 = 0;
	}
	
	public Tier2(int id, int exercise1, int exercise2, int exercise3) {
		this.id = id;
		this.exercise1 = exercise1;
		this.exercise2 = exercise2;
		this.exercise3 = exercise3;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExercise1() {
		return exercise1;
	}

	public void setExercise1(int exercise1) {
		this.exercise1 = exercise1;
	}

	public int getExercise2() {
		return exercise2;
	}

	public void setExercise2(int exercise2) {
		this.exercise2 = exercise2;
	}

	public int getExercise3() {
		return exercise3;
	}

	public void setExercise3(int exercise3) {
		this.exercise3 = exercise3;
	}
	
}

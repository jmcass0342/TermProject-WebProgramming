package finalProject.entity;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private int expertise;
	private int daysOfWorkout;
	private boolean isAdmin;
	
	public User() {
		this.id = -1;
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		this.email = null;
		this.expertise = 0;
		this.daysOfWorkout = 0;
		this.isAdmin = false;
	}
	
	public User(int id, String firstName, String lastName, String userName, String password, String email,
			int expertise, int daysOfWorkout, boolean isAdmin) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.expertise = expertise;
		this.daysOfWorkout = daysOfWorkout;
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExpertise() {
		return expertise;
	}

	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}

	public int getDaysOfWorkout() {
		return daysOfWorkout;
	}

	public void setDaysOfWorkout(int daysOfWorkout) {
		this.daysOfWorkout = daysOfWorkout;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}

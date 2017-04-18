package finalProject.logicLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import finalProject.entity.Exercise;
import finalProject.entity.HasProgram;
import finalProject.entity.Program;
import finalProject.entity.Tier1;
import finalProject.entity.Tier2;
import finalProject.entity.Tier3;
import finalProject.entity.User;
import finalProject.entity.Workout;
import finalProject.persistenceLayer.Demo;
public class ShowDemo {
	
	private Demo demo = null;
	
	public ShowDemo() throws SQLException{
		demo = new Demo();
	}
	
	public List<User> getUsers() throws SQLException{
		List<User> users = new ArrayList<User>();
		ResultSet rs = demo.getUsers();
		 while( rs.next() ) {
         	User user = new User();
         	user.setId(rs.getInt(1));
         	user.setFirstName(rs.getString(2));
         	user.setLastName(rs.getString(3));
         	user.setUserName(rs.getString(4));
         	user.setPassword(rs.getString(5));
         	user.setEmail(rs.getString(6));
         	user.setExpertise(rs.getInt(7));
         	user.setDaysOfWorkout(rs.getInt(8));
         	user.setAdmin(rs.getBoolean(9));
         	users.add(user);
         }
	
		return users;
		
	}
	
	
	public List<User> getValidation(String username, String password) throws SQLException{
		List<User> users = new ArrayList<User>();
		ResultSet rs = demo.getUserLogin(username, password);
		 while( rs.next() ) {
         	User user = new User();
         	user.setId(rs.getInt(1));
         	user.setFirstName(rs.getString(2));
         	user.setLastName(rs.getString(3));
         	user.setUserName(rs.getString(4));
         	user.setPassword(rs.getString(5));
         	user.setEmail(rs.getString(6));
         	user.setExpertise(rs.getInt(7));
         	user.setDaysOfWorkout(rs.getInt(8));
         	user.setAdmin(rs.getBoolean(9));
         	users.add(user);
         }
	
		return users;
		
	}
	
	public List<Exercise> getExercises() throws SQLException{
		List<Exercise> exercises = new ArrayList<Exercise>();
		ResultSet rs = demo.getExercise();
		 while( rs.next() ) {
         	Exercise exercise = new Exercise();
         	exercise.setId(rs.getInt(1));
         	exercise.setExerciseName(rs.getString(2));
         	exercise.setVideo(rs.getString(3));
         	exercise.setTier(rs.getInt(4));
         	exercises.add(exercise);
         }
	
		return exercises;
	}
	
	public List<Tier1> getTier1() throws SQLException{
		List<Tier1> tiers = new ArrayList<Tier1>();
		ResultSet rs = demo.getTier1();
		 while( rs.next() ) {
         	Tier1 tier = new Tier1();
         	tier.setId(rs.getInt(1));
         	tier.setExercise1(rs.getInt(2));
         	tier.setExercise2(rs.getInt(3));
         	tiers.add(tier);
         }
	
		return tiers;
	}
	
	public List<Tier2> getTier2() throws SQLException{
		List<Tier2> tiers = new ArrayList<Tier2>();
		ResultSet rs = demo.getTier2();
		 while( rs.next() ) {
         	Tier2 tier = new Tier2();
         	tier.setId(rs.getInt(1));
         	tier.setExercise1(rs.getInt(2));
         	tier.setExercise2(rs.getInt(3));
         	tier.setExercise3(rs.getInt(3));
         	tiers.add(tier);
         }
	
		return tiers;
	}
	
	public List<Tier3> getTier3() throws SQLException{
		List<Tier3> tiers = new ArrayList<Tier3>();
		ResultSet rs = demo.getTier3();
		 while( rs.next() ) {
         	Tier3 tier = new Tier3();
         	tier.setId(rs.getInt(1));
         	tier.setExercise1(rs.getInt(2));
         	tier.setExercise2(rs.getInt(3));
         	tier.setExercise3(rs.getInt(3));
         	tiers.add(tier);
         }
	
		return tiers;
	}
	
	public List<Workout> getWorkout() throws SQLException{
		List<Workout> workouts = new ArrayList<Workout>();
		ResultSet rs = demo.getWorkout();
		 while( rs.next() ) {
         	Workout workout = new Workout();
         	workout.setId(rs.getInt(1));
         	workout.setTier1Id(rs.getInt(2));
         	workout.setTier2Id(rs.getInt(3));
         	workout.setTier3Id(rs.getInt(4));
         	workouts.add(workout);
         }
	
		return workouts;
	}
	
	public List<Workout> getWorkoutById(int workoutId) throws SQLException{
		List<Workout> workouts = new ArrayList<Workout>();
		ResultSet rs = demo.getWorkoutById(workoutId);
		 while( rs.next() ) {
         	Workout workout = new Workout();
         	workout.setId(workoutId);
         	workout.setTier1Id(rs.getInt(1));
         	workout.setTier2Id(rs.getInt(2));
         	workout.setTier3Id(rs.getInt(3));
         	workouts.add(workout);
         }
	
		return workouts;
	}
	
	
	public List<Program> getPrograms() throws SQLException{
		List<Program> programs = new ArrayList<Program>();
		ResultSet rs = demo.getPrograms();
		 while( rs.next() ) {
         	Program program = new Program();
         	program.setId(rs.getInt(1));
         	program.setDay1(rs.getInt(2));
         	program.setDay2(rs.getInt(3));
         	program.setDay3(rs.getInt(4));
         	programs.add(program);
         }
	
		return programs;
	}
	
	public List<HasProgram> getHasPrograms() throws SQLException{
		List<HasProgram> programs = new ArrayList<HasProgram>();
		ResultSet rs = demo.getHasPrograms();
		 while( rs.next() ) {
         	HasProgram program = new HasProgram();
         	program.setId(rs.getInt(1));
         	program.setUserId(rs.getInt(2));
         	program.setProgramId(rs.getInt(3));
         	program.setStartDate(rs.getDate(4));
         	program.setEndDate(rs.getDate(5));
         	programs.add(program);
         }
	
		return programs;
	}
	
	// check here
	public List<HasProgram> checkProgram(int userId) throws SQLException{
		List<HasProgram> check = new ArrayList<HasProgram>();
		ResultSet rs = demo.checkUserProgram(userId);
		 while( rs.next() ) {
	         	HasProgram program = new HasProgram();
	         	program.setId(rs.getInt(1));
	         	program.setUserId(userId);
	         	program.setProgramId(rs.getInt(2));
	         	program.setStartDate(rs.getDate(3));
	         	program.setEndDate(rs.getDate(4));
	         	check.add(program);
	         }
		return check;
	}
	
	// check here
	public List<Program> getProgramById(int programId) throws SQLException{
		List<Program> check = new ArrayList<Program>();
		ResultSet rs = demo.getProgramById(programId);
		 while( rs.next() ) {
	         	Program program = new Program();
	         	program.setId(programId);
	         	program.setDay1(rs.getInt(1));
	         	program.setDay2(rs.getInt(2));
	         	program.setDay3(rs.getInt(3));
	         	check.add(program);
	         }
		return check;
	}
	
	public List<Tier1> getTier1ById(int tier1Id) throws SQLException{
		List<Tier1> check = new ArrayList<Tier1>();
		ResultSet rs = demo.getTier1ById(tier1Id);
		 while( rs.next() ) {
	         	Tier1 tier = new Tier1();
	         	tier.setId(tier1Id);
	         	tier.setExercise1(rs.getInt(1));
	         	tier.setExercise2(rs.getInt(2));
	         	check.add(tier);
	         }
		 
		 
		System.out.println("From function tier1: " + check.isEmpty());
		return check;
	}
	
	public List<Tier2> getTier2ById(int tier2Id) throws SQLException{
		List<Tier2> check = new ArrayList<Tier2>();
		ResultSet rs = demo.getTier2ById(tier2Id);
		 while( rs.next() ) {
	         	Tier2 tier = new Tier2();
	         	tier.setId(tier2Id);
	         	tier.setExercise1(rs.getInt(1));
	         	tier.setExercise2(rs.getInt(2));
	         	tier.setExercise3(rs.getInt(3));
	         	check.add(tier);
	         }
		 System.out.println("From function tier2: " + check.isEmpty());
		return check;
	}
	
	
	public List<Tier3> getTier3ById(int tier3Id) throws SQLException{
		List<Tier3> check = new ArrayList<Tier3>();
		ResultSet rs = demo.getTier3ById(tier3Id);
		 while( rs.next() ) {
	         	Tier3 tier = new Tier3();
	         	tier.setId(tier3Id);
	         	tier.setExercise1(rs.getInt(1));
	         	tier.setExercise2(rs.getInt(2));
	         	tier.setExercise3(rs.getInt(3));
	         	check.add(tier);
	         }
		 System.out.println("From function tier3: " + check.isEmpty());
		return check;
	}
	
	public List<Exercise> getExerciseById(int exerciseId) throws SQLException{
		List<Exercise> check = new ArrayList<Exercise>();
		ResultSet rs = demo.getExerciseById(exerciseId);
		 while( rs.next() ) {
	         	Exercise exercise = new Exercise();
	         	exercise.setId(exerciseId);
	         	exercise.setExerciseName(rs.getString(1));
	         	exercise.setVideo(rs.getString(2));
	         	exercise.setTier(rs.getInt(3));
	         	check.add(exercise);
	         }
		return check;
	}
	
	public List<Exercise> getExerciseByTier(int tier) throws SQLException{
		List<Exercise> check = new ArrayList<Exercise>();
		ResultSet rs = demo.getExerciseByTier(tier);
		 while( rs.next() ) {
	         	Exercise exercise = new Exercise();
	         	exercise.setId(rs.getInt(1));
	         	exercise.setExerciseName(rs.getString(2));
	         	exercise.setVideo(rs.getString(3));
	         	exercise.setTier(tier);
	         	check.add(exercise);
	         }
		return check;
	}
	
	
	public String getTierExercises(int tier) throws SQLException{
		String check = null;
		ResultSet rs = demo.getTierExercises(tier);
		 while( rs.next() ) {
	         	check = "Exercise 1: " + rs.getString(1) + " <br>Exercise 2: " + rs.getString(2) +"<br>TierId: "+ tier +"<br><br>";
	         	System.out.println(check);
	         }
		return check;
	}
	
	public String getOtherTierExercises(int tier, int tierNumber) throws SQLException{
		String check = null;
		ResultSet rs = demo.getOtherTierExercises(tier, tierNumber);
		 while( rs.next() ) {
	         	check = "Exercise 1: " + rs.getString(1) + " <br>Exercise 2: " + rs.getString(2) + "<br>Exercise 3: " + rs.getString(3) +"<br>TierId: "+ tier + "<br><br>";
	         	System.out.println(check);
	         }
		return check;
	}
	
	public int addUser(String firstName, String lastName, String userName, String password, String email, int difficulty, int days){
		return demo.addUser(firstName, lastName, userName, password, email, difficulty, days);
			
	}
	
	
	public List<HasProgram> checkIfProgram(int userId) throws SQLException{
		List<HasProgram> check = new ArrayList<HasProgram>();
		ResultSet rs = demo.checkIfProgram(userId);
		 while( rs.next() ) {
	         	HasProgram program = new HasProgram();
	         	program.setId(rs.getInt(1));
	         	program.setUserId(userId);
	         	program.setProgramId(rs.getInt(2));
	         	program.setStartDate(rs.getDate(3));
	         	program.setEndDate(rs.getDate(4));
	         	check.add(program);
	         }
		return check;
		
	}
	public int assignProgram(int userId , int programId){
		return demo.assignProgram(userId, programId);
	}
	
	public int insertExercise(String name, String link, int tier){
		return demo.insertExercise(name, link, tier);
	}
	
	public int insertTier1(int exercise1,int exercise2){
		return demo.insertTier1(exercise1, exercise2);
	}
	
	public int insertTier2(int exercise1,int exercise2, int exercise3){
		return demo.insertTier2(exercise1, exercise2, exercise3);
	}
	
	public int insertTier3(int exercise1,int exercise2, int exercise3){
		return demo.insertTier3(exercise1, exercise2, exercise3);
	}
	
	public int insertWorkout(int tier1, int tier2, int tier3){
		return demo.insertWorkout(tier1, tier2, tier3);
	}
	
	public int insertProgram(int day1, int day2, int day3){
		return demo.insertProgram(day1, day2, day3);
	}
	
	public int updateAdminProfile(int userId, String firstname, String lastname, String username, String password, String email){
		return demo.updateAdminProfile(userId, firstname, lastname, username, password, email);
	}
	
	public int deleteUsers(int userId){
		return demo.deleteUsers(userId);
	}
	
	public int deleteUserPrograms(int userId){
		return demo.deleteUserPrograms(userId);
	}
	
	public void disconnect(){
		demo.disconnect();
	}
	
	
	
}

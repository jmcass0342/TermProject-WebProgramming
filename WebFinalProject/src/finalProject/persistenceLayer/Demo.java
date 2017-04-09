package finalProject.persistenceLayer;


 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import finalProject.persistenceLayer.DbUtils;
public class Demo {
	
	private Connection conn = null;
	
	
	public Demo() throws SQLException{
		conn = DbUtils.connect();
	}
	
	public ResultSet getUsers(){
	 	String selectMovies = "select * from  Users";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getPrograms(){
	 	String selectMovies = "select * from program";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getHasPrograms(){
	 	String selectMovies = "select * from hasProgram";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUserLogin(String username, String password){
	 	String selectMovies = "select * from  Users where username = '" + username + "' and password = '" + password + "'";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getTier1(){
	 	String selectMovies = "select * from  tier1";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getTier2(){
	 	String selectMovies = "select * from  tier2";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getTier3(){
	 	String selectMovies = "select * from  tier3";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getWorkout(){
	 	String selectMovies = "select * from  workout";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	

	public ResultSet getExercise(){
	 	String selectMovies = "select * from  exercises";
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public int addUser(String firstName, String lastName, String userName, String password, String email, int difficulty, int days){
		StringBuilder insertUser = new StringBuilder();
		insertUser.append("insert into Users values ( ");
		insertUser.append("LAST_INSERT_ID(), ");
		insertUser.append("'" + firstName +"', ");
		insertUser.append("'" + lastName +"', ");
		insertUser.append("'" + userName +"', ");
		insertUser.append("'" + password +"', ");
		insertUser.append("'" + email +"', ");
		if(difficulty == 0){
			insertUser.append("NULL, ");
		}else{
			insertUser.append(difficulty +", ");
		}
		if(days == 0){
			insertUser.append("NULL, ");
		}else{
			insertUser.append(days+ ", ");
		}
		insertUser.append("0 )");
		Statement stmt2 = null;
	 	int result = 0;
	 	System.out.println(insertUser.toString());
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
			
		
			
	       if( stmt2.executeUpdate( insertUser.toString() ) == 1) { // statement returned a result
	    	   result = 1;
	       }else{
	    	   result =0;
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public int assignProgram(int userId, int programId){
		String assign = "insert into hasProgram values (last_insert_id(), " + userId + ", " + programId +  ", CURDATE(), DATE_ADD(CURDATE(), INTERVAL 1 WEEK))";
		
		Statement stmt2 = null;
	 	int result = 0;
	 	System.out.println(assign);
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
			
		
			
	       if( stmt2.executeUpdate( assign ) == 1) { // statement returned a result
	    	   result = 1;
	       }else{
	    	   result =0;
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	//work here to check if user has a program and a program for this week
	public ResultSet checkUserProgram(int userId){
		ResultSet rs = null;
		Statement stmt2 = null;
		String check = "select h.id, programId, startDate, endDate from program p, hasProgram h where h.userId = " + userId + " and h.programId = p.id and "
				+ "h.startDate <= CURDATE() and h.endDate >= CURDATE()";
		
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( check ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	public ResultSet getProgramById(int programId){
		ResultSet rs = null;
		String getProgram = "select day1, day2, day3 from program where id = " + programId;
		Statement stmt2 = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( getProgram ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public ResultSet getWorkoutById(int workoutId){
	 	String selectMovies = "select tier1Id, tier2Id, tier3Id from  workout where id = " + workoutId;
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}


	public ResultSet getTier1ById(int tier1Id){
	 	String selectMovies = "select exercise1, exercise2 from  tier1 where id = " + tier1Id;
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getTier2ById(int tier2Id){
	 	String selectMovies = "select exercise1, exercise2, exercise3 from  tier2 where id = " + tier2Id;
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	public ResultSet getTier3ById(int tier3Id){
	 	String selectMovies = "select exercise1, exercise2, exercise3 from  tier3 where id = " + tier3Id;
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	
	public ResultSet getExerciseById(int exercisesId){
	 	String selectMovies = "select exerciseName, video, tier from  exercises where id = " + exercisesId;
	 	Statement stmt2 = null;
	 	ResultSet rs = null;
		try {
			stmt2 = conn.createStatement();
			 // retrieve the persistent objects
	       //
	       if( stmt2.execute( selectMovies ) ) { // statement returned a result
	          rs = stmt2.getResultSet();
	        
	       }
	  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	//select * from program where endDate > DATE_SUB(CURDATE(), INTERVAL 3 WEEK);
	
	public void disconnect(){
		try{
			conn.close();
		}catch(SQLException e){
			System.out.println("error");
		}
	}
	
}

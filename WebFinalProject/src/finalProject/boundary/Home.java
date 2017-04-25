package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalProject.entity.User;
import finalProject.entity.Workout;
import finalProject.entity.Exercise;
import finalProject.entity.HasProgram;
import finalProject.entity.Program;
import finalProject.entity.Tier1;
import finalProject.entity.Tier2;
import finalProject.entity.Tier3;
import finalProject.entity.Tip;
import finalProject.session.Session;
import finalProject.session.SessionManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import finalProject.logicLayer.LoginValidation;
import finalProject.logicLayer.ShowDemo;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
	static  String         userHomeTemplateName = "WelcomeUser.ftl";
	static  String         adminHomeTemplateName = "WelcomeAdmin.ftl";
	static  String         failureTemplateName = "UpdateFailure.ftl";
	private Map<String, Object> root = new HashMap<String,Object>();
	   private Configuration cfg;
	   
	   
	   /*
	    *  init method used to setup different things when 
	    *  servlet first run. In this case, set up is done for
	    *  freemarker templates
	    * (non-Javadoc)
	    * @see javax.servlet.GenericServlet#init()
	    */
	    public void init() 
	    {
	    	// Prepare the FreeMarker configuration;
	        // - Load templates from the WEB-INF/templates directory of the Web app.
	        //
	        cfg = new Configuration();
	        cfg.setServletContextForTemplateLoading(
	                getServletContext(), 
	                "WEB-INF/templates"
	                );
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession    httpSession = null;
	        String         ssid = null;
	        Session        session = null;
		
	       
		httpSession = request.getSession();
		
	        if( httpSession == null ) {       // not logged in!
	        	root.put("reason", "Session expired or illegal; please log in" );
	        	setUpTemplate(request,response,failureTemplateName);
	        }
	        
	        ssid = (String) httpSession.getAttribute( "ssid" );
	        if( ssid == null ) {       // assume not logged in!
	        	root.put( "reason", "Session expired or illegal; please log in" );
	        	setUpTemplate(request,response,failureTemplateName);
	        }

	        session = SessionManager.getSessionById( ssid );
	        if( session == null ){
	        	root.put("reason", "Session expired or illegal; please log in" );
	        	setUpTemplate(request,response,failureTemplateName);
	        }
	        
	        User user = session.getUser();
	        if( user == null ) {
	        	root.put( "reason", "Session expired or illegal; please log in" );
	        	setUpTemplate(request,response,failureTemplateName);   
	        }
	        
	        
	        root.put("username", user.getFirstName());
	        
	        try {
				ShowDemo demo = new ShowDemo();
				root.put("randomTips", demo.getRandomTips());
				
				List<HasProgram> programForWeek = demo.checkProgram(user.getId());
				if(!programForWeek.isEmpty()){ // check there is a program for the week
					List<Program> program = demo.getProgramById(programForWeek.get(0).getProgramId());
					List<Workout> workout = new ArrayList<Workout>();
					List<Tier1> tier1 = null;
					List<Tier2> tier2 = null;
					List<Tier3> tier3 = null;
					List<List<Exercise>> days = new ArrayList<List<Exercise>>();
					
					if(program.get(0).getDay1() != 0){
						workout.add(demo.getWorkoutById(program.get(0).getDay1()).get(0));
						tier1 = demo.getTier1ById(workout.get(0).getTier1Id());
						tier2 = demo.getTier2ById(workout.get(0).getTier2Id());
						tier3 = demo.getTier3ById(workout.get(0).getTier3Id());
						
						
						
						System.out.println(workout.get(0).getTier1Id());
						System.out.println(workout.get(0).getTier2Id());
						System.out.println(workout.get(0).getTier3Id());
						List<Exercise> temp = new ArrayList<Exercise>();
						for(int i = 0; i < 3 ; i++ ){
							if(i == 0){
								temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
								temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
								System.out.println(tier1.isEmpty());
								
							}else if(i == 1 ){
								temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
								temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
								temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
								System.out.println(tier2.isEmpty());
								
							}else{
								temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
								temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
								temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
								System.out.println(tier3.isEmpty());
								
							}
						}
						days.add(temp);
						System.out.println("Day1 Id: " + workout.get(0).getId());
					}
					if(program.get(0).getDay2() != 0){ // get day 2 workout
							workout.add(demo.getWorkoutById(program.get(0).getDay2()).get(0));
							tier1 = demo.getTier1ById(workout.get(1).getTier1Id());
							tier2 = demo.getTier2ById(workout.get(1).getTier2Id());
							tier3 = demo.getTier3ById(workout.get(1).getTier3Id());
							List<Exercise> temp = new ArrayList<Exercise>();
							for(int i = 0; i < 3 ; i++ ){
								if(i == 0){
									temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
									temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
								}else if(i == 1 ){
									temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
									temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
									temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
								}else{
									temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
									temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
									temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
								}
							}
							days.add(temp);
							System.out.println("Day2 Id: " + workout.get(1).getId());
						}
						if(program.get(0).getDay3() != 0){ //get day3 workout
											workout.add(demo.getWorkoutById(program.get(0).getDay3()).get(0));
											tier1 = demo.getTier1ById(workout.get(2).getTier1Id());
											tier2 = demo.getTier2ById(workout.get(2).getTier2Id());
											tier3 = demo.getTier3ById(workout.get(2).getTier3Id());
											List<Exercise> temp = new ArrayList<Exercise>();
											for(int i = 0; i < 3 ; i++ ){
												if(i == 0){
													temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
													temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
												}else if(i == 1 ){
													temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
													temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
													temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
												}else{
													temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
													temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
													temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
												}
											}
											days.add(temp);
											System.out.println("Day3 Id: " + workout.get(2).getId());
						}
						
				
					System.out.println("workouts: " + days.size());
					for(int i =0; i < days.size() ; i++){
						root.put("program" + (i+1), days.get(i));
					}
					 if(user.isAdmin()){
				        	setUpTemplate(request,response,adminHomeTemplateName);
				        }else{
				        	setUpTemplate(request,response,userHomeTemplateName);
				        }
				}
				else{
					
					if(user.isAdmin()){
			        	setUpTemplate(request,response,adminHomeTemplateName);
			        }else{
			        	setUpTemplate(request,response,userHomeTemplateName);
			        }
					
				}
				demo.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        
	        
	  
	       
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession 	httpSession = null;
		String			ssid = null;
		Session 		session = null;
		String 			username = null;
		String 			password = null;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		try {
			ShowDemo showTwo = new ShowDemo();
			root.put("randomTips", showTwo.getRandomTips());
			showTwo.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		httpSession = request.getSession();
		ssid = (String) httpSession.getAttribute("ssid");
		if(ssid != null) {
			System.out.println("Already have ssid: "+ssid);
			session = SessionManager.getSessionById(ssid);
			System.out.println("Connection: "+session.getConnection());
		} else
			System.out.println("ssid is null");
		
		
		
		if(session == null) {
			try{
				session = SessionManager.createSession();
			}catch(Exception e){
				System.out.println("error3");
				return;
			}
		}
		
		System.out.println(username);
		System.out.println(password);
		if(username == null || password == null || username.equals("") || password.equals("")) {
			System.out.println("Missing user name or password");
			return;
		}
		
		
		try{
			LoginValidation validate = new LoginValidation();
			ssid = validate.validate(session, username, password);
			if(ssid == null || ssid.equalsIgnoreCase("error")){
				System.out.println("Error1");
				root.put("reason", "Failed to login");
				root.put("user", null);
				setUpTemplate(request,response, failureTemplateName);
			} else if (ssid == null || ssid.equalsIgnoreCase("error")) {
				System.out.println("Error2");
				root.put("user", null);
				root.put("reason", "Failed to login");
				setUpTemplate(request,response, failureTemplateName);
			}else{
				System.out.println("Obtained ssid: "+ssid);
				httpSession.setAttribute("ssid", ssid);
				System.out.println("Connection: "+session.getConnection());
				ShowDemo show = new ShowDemo();
				if(!show.getValidation(username,password).isEmpty()){
					User user = show.getValidation(username, password).get(0);
					show.disconnect();
					if(user.isAdmin()){
						root.put("username", user.getFirstName());
						setUpTemplate(request,response,adminHomeTemplateName);
					}else{
						
						root.put("username", user.getFirstName());
						root.put("user", user);
							
				  
						try {
							ShowDemo demo = new ShowDemo();
							root.put("randomTips", demo.getRandomTips());
							
							
							System.out.println("userId at login: " + user.getId());
							
							List<HasProgram> programForWeek = demo.checkProgram(user.getId());
							if(!programForWeek.isEmpty()){ // check there is a program for the week
								List<Program> program = demo.getProgramById(programForWeek.get(0).getProgramId());
								List<Workout> workout = new ArrayList<Workout>();
								List<Tier1> tier1 = null;
								List<Tier2> tier2 = null;
								List<Tier3> tier3 = null;
								List<List<Exercise>> days = new ArrayList<List<Exercise>>();
								
								if(program.get(0).getDay1() != 0){
									workout.add(demo.getWorkoutById(program.get(0).getDay1()).get(0));
									tier1 = demo.getTier1ById(workout.get(0).getTier1Id());
									tier2 = demo.getTier2ById(workout.get(0).getTier2Id());
									tier3 = demo.getTier3ById(workout.get(0).getTier3Id());
									
									
									
									System.out.println(workout.get(0).getTier1Id());
									System.out.println(workout.get(0).getTier2Id());
									System.out.println(workout.get(0).getTier3Id());
									List<Exercise> temp = new ArrayList<Exercise>();
									for(int i = 0; i < 3 ; i++ ){
										if(i == 0){
											temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
											temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
											System.out.println(tier1.isEmpty());
											
										}else if(i == 1 ){
											temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
											temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
											temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
											System.out.println(tier2.isEmpty());
											
										}else{
											temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
											temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
											temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
											System.out.println(tier3.isEmpty());
											
										}
									}
									days.add(temp);
									System.out.println("Day1 Id: " + workout.get(0).getId());
								}
								if(program.get(0).getDay2() != 0){ // get day 2 workout
										workout.add(demo.getWorkoutById(program.get(0).getDay2()).get(0));
										tier1 = demo.getTier1ById(workout.get(1).getTier1Id());
										tier2 = demo.getTier2ById(workout.get(1).getTier2Id());
										tier3 = demo.getTier3ById(workout.get(1).getTier3Id());
										List<Exercise> temp = new ArrayList<Exercise>();
										for(int i = 0; i < 3 ; i++ ){
											if(i == 0){
												temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
												temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
											}else if(i == 1 ){
												temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
												temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
												temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
											}else{
												temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
												temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
												temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
											}
										}
										days.add(temp);
										System.out.println("Day2 Id: " + workout.get(1).getId());
									}
									if(program.get(0).getDay3() != 0){ //get day3 workout
														workout.add(demo.getWorkoutById(program.get(0).getDay3()).get(0));
														tier1 = demo.getTier1ById(workout.get(2).getTier1Id());
														tier2 = demo.getTier2ById(workout.get(2).getTier2Id());
														tier3 = demo.getTier3ById(workout.get(2).getTier3Id());
														List<Exercise> temp = new ArrayList<Exercise>();
														for(int i = 0; i < 3 ; i++ ){
															if(i == 0){
																temp.add(demo.getExerciseById(tier1.get(0).getExercise1()).get(0));
																temp.add(demo.getExerciseById(tier1.get(0).getExercise2()).get(0));
															}else if(i == 1 ){
																temp.add(demo.getExerciseById(tier2.get(0).getExercise1()).get(0));
																temp.add(demo.getExerciseById(tier2.get(0).getExercise2()).get(0));
																temp.add(demo.getExerciseById(tier2.get(0).getExercise3()).get(0));
															}else{
																temp.add(demo.getExerciseById(tier3.get(0).getExercise1()).get(0));
																temp.add(demo.getExerciseById(tier3.get(0).getExercise2()).get(0));
																temp.add(demo.getExerciseById(tier3.get(0).getExercise3()).get(0));
															}
														}
														days.add(temp);
														System.out.println("Day3 Id: " + workout.get(2).getId());
									}
									
							
								System.out.println("workouts: " + days.size());
								for(int i =0; i < days.size() ; i++){
									root.put("program" + (i+1), days.get(i));
								}
								
							}
							else{
								
									root.put("program1",null);
									root.put("program2",null);
									root.put("program3",null);
								
								
							}
							demo.disconnect();
							
							setUpTemplate(request,response, userHomeTemplateName);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
			
	}

		
	

	public void setUpTemplate(HttpServletRequest request, HttpServletResponse response, String templateToDisplay){
		Template resultTemplate = null;
		BufferedWriter toClient = null;
		 // Load templates from the WEB-INF/templates directory of the Web app.
        //
        try {
            resultTemplate = cfg.getTemplate( templateToDisplay );
        } 
        catch (IOException e) {
            try {
				throw new ServletException( "ShowMainOfficerWindow.doGet: Can't load template in: " + templateDir + ": " + e.toString());
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        // Prepare the HTTP response:
        // - Use the charset of template for the output
        // - Use text/html MIME-type
        //
        try {
			toClient = new BufferedWriter( new OutputStreamWriter( response.getOutputStream(), resultTemplate.getEncoding() ) );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        response.setContentType("text/html; charset=" + resultTemplate.getEncoding());
        
        
        try {
            try {
				resultTemplate.process( root, toClient );
				toClient.flush();
				 toClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 
        catch (TemplateException e) {
            try {
				throw new ServletException( "Error while processing FreeMarker template", e);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
	}// end of setUpTemplate function
}

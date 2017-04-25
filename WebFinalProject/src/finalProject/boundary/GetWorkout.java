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

import finalProject.entity.Program;
import finalProject.entity.User;
import finalProject.logicLayer.ShowDemo;
import finalProject.session.Session;
import finalProject.session.SessionManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class GetWorkout
 */
@WebServlet("/GetWorkout")
public class GetWorkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
	static  String         signUpTemplateName = "GetWorkout.ftl";
	static  String         failureTemplateName = "Failure.ftl";
	static  String         successTemplateName = "Success.ftl";
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
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession    httpSession = null;
	       
	        String         username = null;
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
	        username = user.getUserName();
	        
	        System.out.println(username);
	        try {
				ShowDemo demo = new ShowDemo();
				if(demo.checkProgram(user.getId()).isEmpty()){
					List<Program> programs = demo.getPrograms();
					List<Program> filtered = new ArrayList<Program>();
					for(int i = 0; i < programs.size(); i++){
						if(user.getDaysOfWorkout() == 1){
							if(programs.get(i).getDay1() != 0 && programs.get(i).getDay2() == 0 && programs.get(i).getDay3() == 0){
								filtered.add(programs.get(i));
							}	
						}else if(user.getDaysOfWorkout() == 2){
							if(programs.get(i).getDay1() != 0 && programs.get(i).getDay2() != 0 && programs.get(i).getDay3() == 0){
								filtered.add(programs.get(i));
							}	
						}else if(user.getDaysOfWorkout() == 3){
							if(programs.get(i).getDay1() != 0 && programs.get(i).getDay2() != 0 && programs.get(i).getDay3() != 0){
								filtered.add(programs.get(i));
							}	
						}
					}
					
					
					
					int random = 0;
					
					for(int i = 0 ; i < 10 ; i++){
						random = (int)(Math.random() * filtered.size() + 0);
						System.out.println("random: " + random);
					}
					System.out.println("final random: " + random);
					if(demo.assignProgram(user.getId(), filtered.get(random % filtered.size()).getId()) == 1){
						root.put("reason", "Success you have a workout!");
						setUpTemplate(request,response,successTemplateName);
					}else{
						root.put("reason", "Error assigning workout");
						setUpTemplate(request,response,failureTemplateName);
					}
				}
				else{
					root.put("reason", "You already have a workout for this week!");
					setUpTemplate(request,response,failureTemplateName);
				}
				
				demo.disconnect();
			} catch (SQLException e) {
				e.printStackTrace();
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

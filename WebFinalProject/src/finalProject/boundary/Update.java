package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
	static  String         failureTemplateName = "UpdateFailure.ftl";
	static  String         successTemplateName = "UpdateSuccess.ftl";
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
	        
	        String firstName = request.getParameter("firstName");
	        user.setFirstName(firstName);
	        
	        
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String difficulty = request.getParameter("difficulty");
			String days = request.getParameter("days");
			int numericalDifficulty;
			int numericalDays;
			
			if(difficulty == null || difficulty.equals("")){
				numericalDifficulty = 0;
			}else{
				numericalDifficulty = Integer.parseInt(difficulty);
			}
			
			if(days == null || days.equals("")){
				numericalDays = 0;
			}else{
				numericalDays = Integer.parseInt(days);
			}
			
			try {
				ShowDemo demo = new ShowDemo();
				if(demo.updateUser(firstName, lastName, username, password, email, numericalDifficulty, numericalDays) == 1){
					System.out.println("success");
					root.put("reason", "Update succesful");
					setUpTemplate(request,response,successTemplateName);
				}else{
					System.out.println("failed");
					root.put("reason", "Update failed");
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
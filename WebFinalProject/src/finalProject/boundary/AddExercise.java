package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalProject.entity.User;
import finalProject.logicLayer.ShowDemo;
import finalProject.session.Session;
import finalProject.session.SessionManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class AddWorkout
 */
@WebServlet("/AddExercise")
public class AddExercise extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
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
        
        String name = request.getParameter("name");
    	String video = request.getParameter("video");
    	String tier = request.getParameter("tier");
        
        try{
        	ShowDemo demo = new ShowDemo();
        	System.out.println(name);
        	System.out.println(video);
        	System.out.println(tier);
        	if(demo.insertExercise(name, video, Integer.parseInt(tier)) == 1){
        		root.put("reason", "exercise added");
        		setUpTemplate(request,response,successTemplateName);
        	}else{
        		root.put("reason", "exercise cannot be added");
        		setUpTemplate(request,response,failureTemplateName);
        	}
        	demo.disconnect();
        }catch(SQLException e){
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
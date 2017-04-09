package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import finalProject.entity.User;
import finalProject.logicLayer.LoginValidation;
import finalProject.logicLayer.ShowDemo;
import finalProject.session.Session;
import finalProject.session.SessionManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static  String         templateDir = "WEB-INF/templates";
	static  String         resultTemplateName = "WelcomeUser.ftl";
	static  String         resultAdminTemplateName = "WelcomeAdmin.ftl";
	static  String         logoutTemplateName = "Goodbye.ftl";
	static  String         failureTemplateName = "Failure.ftl";
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
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession 	httpSession = null;
		String			ssid = null;
		Session 		session = null;
		String 			username = null;
		String 			password = null;
		
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		
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
				setUpTemplate(request,response, failureTemplateName);
			} else if (ssid == null || ssid.equalsIgnoreCase("error")) {
				System.out.println("Error2");
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
						root.put("username", user.getUserName());
						setUpTemplate(request,response,resultAdminTemplateName);
					}else{
						root.put("username", user.getUserName());
						setUpTemplate(request,response, resultTemplateName);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession    httpSession = null;
	     String         ssid = null;
		httpSession = request.getSession( false );
        if( httpSession != null ) {
            ssid = (String) httpSession.getAttribute( "ssid" );
            if( ssid != null ) {
                System.out.println( "Already have ssid: " + ssid );
                Session session = SessionManager.getSessionById( ssid );
                if( session == null ) {
                    System.out.println( "Session expired or illegal; please log in" );
                    return; 
                }
                LoginValidation logout = new LoginValidation();
              
                try {
                	System.out.println(ssid);
                	logout.logout(ssid);
                    httpSession.removeAttribute("ssid");
                    httpSession.invalidate();
                    System.out.println( "Invalidated http session" );
                }
                catch( Exception e ) {
                    e.printStackTrace();
                }
            }
            else
                System.out.println( "ssid is null" );
        }
        else
            System.out.println( "No http session" );
        
        
        setUpTemplate(request,response,logoutTemplateName);
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

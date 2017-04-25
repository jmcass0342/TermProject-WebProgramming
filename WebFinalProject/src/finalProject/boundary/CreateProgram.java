package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalProject.entity.Workout;
import finalProject.logicLayer.ShowDemo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class CreateProgram
 */
@WebServlet("/CreateProgram")
public class CreateProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
	static  String         tiersTemplateName = "Tiers.ftl";
	static  String         programTemplateName = "BuildProgram.ftl";
	static  String         failureTemplateName = "adminFailure.ftl";
	static  String         successTemplateName = "adminSuccess.ftl";
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
		try {
			ShowDemo demo = new ShowDemo();
			List<Workout> workouts = demo.getWorkout();
			root.put("workouts", workouts);
			setUpTemplate(request,response,programTemplateName);
			demo.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String read1 = request.getParameter("day1").replaceAll(",", "");
		String read2 = request.getParameter("day2").replaceAll(",", "");
		String read3 = request.getParameter("day3").replaceAll(",", "");
		
		int day1 = Integer.parseInt(read1);
		int day2 =0;
		int day3 = 0;
		if(read2.equalsIgnoreCase("null") || read2 == null){
			day2 = 0;
		}else{
			day2 = Integer.parseInt(read2);
		}
		
		if(read3.equalsIgnoreCase("null") || read2 == null){
			day3 = 0;
		}else{
			day3 = Integer.parseInt(read3);
		}
	
		try {
			ShowDemo demo = new ShowDemo();
			if(demo.insertProgram(day1, day2, day3) == 1){
				root.put("reason", "adding a program");
				setUpTemplate(request,response,successTemplateName);
			}else{
				root.put("reason", "cannot a program");
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

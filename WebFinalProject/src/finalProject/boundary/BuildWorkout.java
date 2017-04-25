package finalProject.boundary;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import finalProject.entity.Tier1;
import finalProject.entity.Tier2;
import finalProject.entity.Tier3;
import finalProject.logicLayer.ShowDemo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class BuildWorkout
 */
@WebServlet("/BuildWorkout")
public class BuildWorkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static  String         templateDir = "WEB-INF/templates";
	static  String         tiersTemplateName = "Tiers.ftl";
	static  String         buildTemplateName = "BuildWorkout.ftl";
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
			List<Tier1> tier1 = demo.getTier1();
			List<Tier3> tier3 = demo.getTier3();
			List<Tier2> tier2 = demo.getTier2();
			List<String> exercisesTier1 = new ArrayList<String>();
			List<String> exercisesTier2 = new ArrayList<String>();
			List<String> exercisesTier3 = new ArrayList<String>();
			for(int i = 0; i < tier1.size(); i++){
				exercisesTier1.add(demo.getTierExercises(tier1.get(i).getId()));
			}
			
			for(int i =0 ; i < tier2.size(); i++){
				exercisesTier2.add(demo.getOtherTierExercises(tier2.get(i).getId(),2));
			}
			
			for(int i =0 ; i < tier3.size(); i++){
				exercisesTier3.add(demo.getOtherTierExercises(tier3.get(i).getId(),3));
			}
			
			root.put("tier1",tier1);
			root.put("string1", exercisesTier1);
			root.put("tier2",tier2);
			root.put("string2", exercisesTier2);
			root.put("tier3",tier3);
			root.put("string3", exercisesTier3);
			setUpTemplate(request,response,buildTemplateName);
			demo.disconnect();
			//setUpTemplate(request,response,buildTemplateName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			int tier1Id = Integer.parseInt(request.getParameter("getId1").replaceAll(",", ""));	
			int tier2Id = Integer.parseInt(request.getParameter("getId2").replaceAll(",", ""));
			int tier3Id = Integer.parseInt(request.getParameter("getId3").replaceAll(",", ""));
			ShowDemo demo = new ShowDemo();
			if(demo.insertWorkout(tier1Id, tier2Id, tier3Id) == 1){
				root.put("reason", "added workout");
				setUpTemplate(request,response,successTemplateName);
			}else{
				root.put("reason", "cannot add workout");
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

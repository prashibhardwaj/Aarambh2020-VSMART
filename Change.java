

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Change
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String vehicleid=request.getParameter("vehicleid");
		String speed=request.getParameter("speed");
		String ridemode=request.getParameter("ridemode");
		String suspension=request.getParameter("suspension");
		String pressure=request.getParameter("pressure");
		String fuelleft=request.getParameter("fuelleft");
		String enginetemp=request.getParameter("enginetemp");
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartvehicle","root","1234");
			String qr="SELECT * FROM admin1 WHERE vehicleid='"+vehicleid+"' AND speed>='"+speed+"' AND ridemode='"+ridemode+"'AND suspension='"+suspension+"'AND pressure<='"+pressure+"'AND fuelleft<='"+fuelleft+"'AND enginetemp>='"+enginetemp+"';";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);

		

			
			
			if(rs.next())
					{
			out.println("RECORD FOUND YOUR SPECIFICATIONS HAS MATCHED WITH OWNER");

					}
			else
			{
				out.println("RECORD NOT FOUND YOUR SPECIFICATIONS ARE NOT MATCHED WITH OWNER ");
				out.println("VEHICLE STOPPED!!!!!!!!");
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

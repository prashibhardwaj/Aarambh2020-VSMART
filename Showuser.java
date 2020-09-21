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
 * Servlet implementation class Show
 */
@WebServlet("/Showuser")
public class Showuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smartvehicle","root","1234");
			String qr="select * from admin1";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align=center border=1px>");
				out.println("<tr><th>ID</th><th>SPEED</th><th>RIDEMODE</th><th>SUSPENSION</th><th>PRESSURE</th><th>FUELLEFT</th><th>ENGINETEMP</th></tr>");
				do
				{
					String vehicleid=rs.getString("vehicleid");
					String speed=rs.getString("speed");
					String ridemode=rs.getString("ridemode");
					String suspension=rs.getString("suspension");
					String pressure=rs.getString("pressure");
					String fuelleft=rs.getString("fuelleft");
					String enginetemp=rs.getString("enginetemp");
					out.println("<tr>");
					out.println("<td>");
					out.println(vehicleid);
					out.println("</td>");
					out.println("<td>");
				out.println(speed);
					out.println("</td>");
					out.println("<td>");
					out.println(ridemode);
					out.println("</td>");
					out.println("<td>");
					out.println(suspension);
					out.println("</td>");
					
					out.println("<td>");
					out.println(pressure);
					out.println("</td>");
					out.println("<td>");
					out.println(fuelleft);
					out.println("</td>");
					out.println("<td>");
					out.println(enginetemp);
					out.println("</td>");
					out.println("<td>");
					out.println("<a href=change.html>CHANGE  </a>");
					out.println("</td>");
					

					
					
					
					out.println("</tr>");
				}while(rs.next());
				out.println("</table>");
			}
			else
			{
				out.println("NO RECORDS FOUND");
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}
	}

}





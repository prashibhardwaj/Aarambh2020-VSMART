
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
			String qr="update admin1 set speed=?,ridemode=?,suspension=?,pressure=?,fuelleft=?,enginetemp=? where vehicleid=?";
			PreparedStatement ps=con.prepareStatement(qr);
			String vehicleid=request.getParameter("vehicleid");
			String speed=request.getParameter("speed");
			String ridemode=request.getParameter("ridemode");
			String suspension=request.getParameter("suspension");
			String pressure=request.getParameter("pressure");
			String fuelleft=request.getParameter("fuelleft");
			String enginetemp=request.getParameter("enginetemp");
			
		
			ps.setString(7,vehicleid);
			ps.setString(1, speed);
			ps.setString(2, ridemode);
			ps.setString(3, suspension);
			ps.setString(4, pressure);
			ps.setString(5,fuelleft);
			ps.setString(6,enginetemp);
			
			
			
			
			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("UPDATE");
			}
			else
			{
				out.println("NOT UPDATED");
			}
			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}

}

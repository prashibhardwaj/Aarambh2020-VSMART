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
 * Servlet implementation class AddPro
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String qr="insert into admin1 values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, vehicleid);
			ps.setString(2, speed);
			ps.setString(3, ridemode);
			ps.setString(4, suspension);
			ps.setString(5, pressure);
			ps.setString(6, fuelleft);
			ps.setString(7, enginetemp);

			
			int i=ps.executeUpdate();
			if(i>0)
			{
				out.println("ADDED");
			}
			else
			{
				out.println("NOT ADDED");
			}
			con.close();
		} catch (Exception e) {
			out.println(e);
		}
	}

}


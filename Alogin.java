import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
@WebServlet("/Alogin")
public class Alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String vehicleid=request.getParameter("vehicleid");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/smartvehicle","root","1234");
			String qr="SELECT * FROM admin WHERE id='"+id+"' AND pwd='"+pwd+"' AND vehicleid='"+vehicleid+"';";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);

			
			
			if(rs.next())
					{
				response.sendRedirect("adminhome.html");

					}
			else
			{
				out.println("RECORD NOT FOUND");
			}
			
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}

			
		
		
	}

}

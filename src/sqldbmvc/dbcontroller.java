package sqldbmvc;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dbcontroller
 */
@WebServlet("/dbcontroller")
public class dbcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<DbReader> readers = new ArrayList<DbReader>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dbcontroller() {
        super();
        
    	readers.add(new IkeaReader());
    	readers.add(new ScpReader());
    	readers.add(new BearReader());
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uSearch = request.getParameter("uSearch");
		ArrayList<String> results = new ArrayList<String>();
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3307/scpdb", "root", "");
			for(DbReader r : readers) {
				results.addAll(r.Read(uSearch, connection));
			}
			for(String s : results) {
				response.getWriter().append(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

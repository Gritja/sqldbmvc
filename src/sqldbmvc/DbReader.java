package sqldbmvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class  DbReader {
	public ArrayList<String> Read(String keyword, Connection connection) {
		String[] parts = keyword.split(" ");
		Statement s;
		ArrayList<String> results = new ArrayList<String>();
		try {
			s = connection.createStatement();
		
			
		for(String part : parts) {
			ResultSet rs = s.executeQuery(GetQuery(part));
			while (rs.next()) {
				results.add(GetResultAsString(rs));
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}
	
	protected String TryGetValue(String key, ResultSet rs) throws SQLException{
		String result = rs.getString(key);
		return result != null ? result : "";
	}
	
	abstract String GetQuery(String keyword);
	abstract String GetResultAsString(ResultSet resultSet) throws SQLException;
}

package sqldbmvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IkeaReader extends DbReader {

	@Override
	String GetQuery(String keyword) {
		// TODO Auto-generated method stub
		return "SELECT * FROM ikea_names WHERE name LIKE '%" + keyword + "%'";
	}

	@Override
	String GetResultAsString(ResultSet resultSet) throws SQLException {
		return resultSet.getString("name") + ": " + TryGetValue("description", resultSet);
	}	
}

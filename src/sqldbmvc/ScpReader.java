package sqldbmvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScpReader extends DbReader{

	@Override
	String GetQuery(String keyword) {
		return "SELECT * FROM masterscplist WHERE Title LIKE '%" + keyword + "%'";
	}

	@Override
	String GetResultAsString(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return resultSet.getString("Title") + ":  " + TryGetValue("SCP", resultSet) + TryGetValue("rating", resultSet);
	}
}

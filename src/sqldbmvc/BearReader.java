package sqldbmvc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BearReader extends DbReader {

	@Override
	String GetQuery(String keyword) {
		return "SELECT * FROM bearbase WHERE Character LIKE '%" + keyword + "%'";
	}

	@Override
	String GetResultAsString(ResultSet resultSet) throws SQLException {
		return resultSet.getString("Character") + ": " + TryGetValue("Origin", resultSet);
	}
	
}

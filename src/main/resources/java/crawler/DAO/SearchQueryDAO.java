package crawler.DAO;

import java.sql.Connection;
import java.sql.ResultSet;

public class SearchQueryDAO {
	
	private static Connection connection = MySQLConnector.createConnection("EmailCrawlerDB", "root", "");
	
	public static ResultSet getPendingQuery() {
		return MySQLConnector.executeQuery(connection, "select * from Search where search_progress = 'pending' ORDER BY search_id LIMIT 1", false);
	}
	
	public static void updateToProcessing(String search_id) {
		MySQLConnector.executeQuery(connection, "UPDATE Search SET search_progress = 'processing' WHERE search_id = " + search_id + ";", true);
	}
	
	public static void updateToComplete(String search_id) {
		MySQLConnector.executeQuery(connection, "UPDATE Search SET search_progress = 'completed' WHERE search_id = " + search_id + ";", true);
	}
	
	public static void updateToFailed(String search_id) {
		MySQLConnector.executeQuery(connection, "UPDATE Search SET search_progress = 'completed' WHERE search_id = " + search_id + ";", true);
	}
}
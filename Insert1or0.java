package bill_calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert1or0 {

//  獨立測試用
//	public static void main(String[] args) {
//		InsertIntoDatabase IID = new InsertIntoDatabase();
//		IID.insertExpense("dog",45.45, "dog");
//	}

	// 注意,下面區塊要換成本地帳密與資料庫名
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bill?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "12345678";
	
	void insert1or0(int imported_num, String imported_sharer_name) {
		Connection conn = null;
		Statement stmt = null;
		String name = imported_sharer_name;
		int num = imported_num;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query to create a table
			System.out.println("Updating data...");
			stmt = conn.createStatement();

			String sql = "UPDATE EXPENSES " +
						"SET %s = 1" +
						"WHERE num = %d".formatted(name, num);

			stmt.executeUpdate(sql);
			System.out.println("data inserted successfully...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("SQL Exception:");
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("Exception:");
			e.printStackTrace();
		} finally {
			// Finally block to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				System.out.println("Failed to close Statement.");
				se2.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				System.out.println("Failed to close Connection.");
				se.printStackTrace();
			}
		}

		System.out.println("End~~~~!");
	}
};

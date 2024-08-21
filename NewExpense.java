package bill_calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewExpense {

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
	
	void insertExpense(int imported_num) {
		Connection conn = null;
		Statement stmt = null;
		int num = imported_num;
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute a query to create a table
			System.out.println("Inserting a new expense...");
			stmt = conn.createStatement();

			String sql = "INSERT INTO EXPENSES " +
						"VALUES (%d, '', 0.0, '',0,0,0);".formatted(num);

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

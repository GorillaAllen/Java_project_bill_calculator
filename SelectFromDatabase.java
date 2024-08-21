package bill_calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectFromDatabase {

  //獨立測試用
	public static void main(String[] args) {
//		SelectFromDatabase SFD = new SelectFromDatabase();
//		SFD.selectFrom(1, "dog", 1.23);
	}
	//注意,下面區塊要換成本地帳密與資料庫名
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bill?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "12345678";
    
    String selectFrom() {
    	Connection conn = null;
    	Statement stmt = null;
    	//int num = imported_num; 持續開發可能需要
    	//String expense = imported_expense;
    	//double amount = imported_amount;
    	int new_num;
    	String new_expense;
    	double new_amount;
    	String pre_paid = "";
    	
    try {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Execute a query to create a table
        System.out.println("Selecting data...");
        stmt = conn.createStatement();

        String sql = "SELECT * from expenses ";
                  // + "Where num = %d;".formatted(num);
        
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
//        	new_num  = rs.getInt("num");
//            new_expense = rs.getString("expense");
//            new_amount = rs.getDouble("amount");
// 
//            System.out.print("序號:" + new_num);
//            System.out.print(" 品項名:" + new_expense);
//            System.out.print(" 金額:" + new_amount);
//            System.out.print("\n");
        	pre_paid = rs.getString("name");
        }
        
        rs.close();
        conn.close();
        stmt.close();

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
            if (stmt != null) stmt.close();
        } catch (SQLException se2) {
            System.out.println("Failed to close Statement.");
            se2.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException se) {
            System.out.println("Failed to close Connection.");
            se.printStackTrace();
        }
    }

    System.out.println("End~~~~!");
	return pre_paid;
}};
    

	

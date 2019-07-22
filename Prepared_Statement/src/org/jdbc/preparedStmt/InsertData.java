package org.jdbc.preparedStmt;

import java.sql.*;

public class InsertData {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String qry="insert into data.student values(?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class load and registerd");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Connection established with db server");
		
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform created");
			
			/*Set the value for placeholder*/
			
			pstmt.setInt(1,1);
			pstmt.setString(2,"abc");
			pstmt.setDouble(3,67.78);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,2);
			pstmt.setString(2,"bcd");
			pstmt.setDouble(3,67.78);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,3);
			pstmt.setString(2,"efg");
			pstmt.setDouble(3,67.78);
			pstmt.executeUpdate();
			System.out.println("Data inserted into database");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Closed all costly resources");
		}
		
		
	}

}

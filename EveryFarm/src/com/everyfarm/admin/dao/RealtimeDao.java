package com.everyfarm.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.everyfarm.admin.dto.AuctionApprovalDto;

public class RealtimeDao {

	private Connection con;
	
	public RealtimeDao() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "kh";
			String password ="kh";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("ERROR: Account connection");
			e.printStackTrace();
		}
	}
		
	public int submit(String auc_id, String auc_name, String auc_init, String auc_curr, String auc_reg, String auc_end, String auc_cnt) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String stock_sql = " INSERT INTO STOCK VALUES(CHATSEQ.NEXTVAL,?,?, SYSDATE) ";
		String auction_sql = " INSERT INTO CHAT VALUES(CHATSEQ.NEXTVAL,?,?, SYSDATE) ";
		
		try {
			pstm = con.prepareStatement(stock_sql);
			pstm.setString(1, auc_id);
			pstm.setString(2, auc_name);
			return pstm.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("ERROR: sql exe");
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
			} catch (SQLException e) {
				System.out.println("ERROR close");
				e.printStackTrace();
			}
		}
		return -1;
	}
	
}

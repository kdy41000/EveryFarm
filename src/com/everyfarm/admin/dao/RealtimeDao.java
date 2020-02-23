package com.everyfarm.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.everyfarm.admin.dto.AuctionApprovalDto;

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
	
	public int insert(List<AuctionApprovalDto> list) {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO BIKE_TB "
				+ " VALUES(?,?,?,?,?,?,?) ";
		try {
			pstm = con.prepareStatement(sql);
			for(int i=0; i<list.size(); i++) {
				AuctionApprovalDto dto = list.get(i);
				// list[0], list[1]... Dto 객체를 만듬
				pstm.setString(1, null);
				pstm.setInt(2, 0);
				pstm.setString(3, null);
				pstm.setString(4, null);
				pstm.setInt(5, 0);
				
				pstm.addBatch(); 
			}
			System.out.println("3.query" + sql);
			
			int[]result = pstm.executeBatch();
			System.out.println("4.execute");
			
			for(int i=0; i<result.length; i++) {
				if(result[i]==-2) {
					res++;
				}
			}
			if(res == list.size()) { 
				con.commit();
			} else {
				con.rollback();
			} 
			
		} catch (SQLException e) {
			System.out.println("ERROR 3,4");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	public int delete() {
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " DELETE FROM BIKE_TB ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. queury " + sql);
			res = pstm.executeUpdate();
			System.out.println("4. execute");
			if(res>0) {
				con.commit();
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR 3,4");
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

}

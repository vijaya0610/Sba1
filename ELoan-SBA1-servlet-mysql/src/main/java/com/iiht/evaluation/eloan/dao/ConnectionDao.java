package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.LoanInfoDisplay;

public class ConnectionDao<UserDetails> {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ConnectionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	public  Connection connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public void addLoan( String ApplicationNumber, String LoanName,String LoanAmount, String ApplicationDate, 
			String BusinessStructure, String BillingIndicator, String ContactAddress, String Email,String ContactNumber,  String LoanNumber, String TaxPayer) throws SQLException,ClassNotFoundException {
		String sql = "insert into userdb.applicationdetails values(?,?,?,str_to_date(?,'%m-%d-%Y'),?,?,?,?,?,?,?)";
		this.connect(); 
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		//id will be auto-increment in database
		//str_to_date('07-25-2012','%m-%d-%Y')

		pstmt.setString(1, ApplicationNumber);
		pstmt.setString(2, LoanName);
		pstmt.setString(3, LoanAmount);		
		pstmt.setString(4, ApplicationDate);		
		pstmt.setString(5, BusinessStructure);		
		pstmt.setString(6, BillingIndicator);		
		pstmt.setString(7, ContactAddress);	
		pstmt.setString(8, Email);
		pstmt.setString(9, ContactNumber);				
		pstmt.setString(10, LoanNumber);
		pstmt.setString(11, TaxPayer);
		
		pstmt.execute();
		pstmt.close();
		this.disconnect();
	}
	
	// put the relevant DAO methods here..
	
	
	public void registernewuserdao (String userid, String username, String userpassword) throws SQLException,ClassNotFoundException {
		String sql = "insert into sukanya.userinfo values(?,?,?)";
		this.connect(); 
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, username);
		pstmt.setString(3, userpassword);
		
		pstmt.execute();
		pstmt.close();
		this.disconnect();	
				
	}
	
	
	
		
				
	
	
	public List<LoanInfoDisplay> getLoanRecords() throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		String sql = "select * from sukanya.loaninfo";
		this.connect();
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		List<LoanInfoDisplay> loandetails = new ArrayList<LoanInfoDisplay>();
		while(rs.next()) {
			LoanInfoDisplay loaninfo1 = new LoanInfoDisplay(rs.getString("ApplicationNumber"), rs.getString("LoanName"), rs.getString("LoanAmount"), rs.getString("ApplicationDate"), rs.getString("BusinessStructure"), 
					rs.getString("BillingIndicator"), rs.getString("ContactAddress"), rs.getString("Email"), rs.getString("ContactNumber"), rs.getString("LoanNumber"), rs.getString("TaxPayer"));
			loandetails.add(loaninfo1);		
		}
				
		rs.close();
		stmt.close();
		this.disconnect();		
		return loandetails;
		
	}
	
	

}

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

public class ConnectionDao2<AdminDetails> {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ConnectionDao2(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

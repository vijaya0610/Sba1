package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.LoanInfoDisplay;




@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ConnectionDao connDao;
	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	@SuppressWarnings("rawtypes")
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		
	
		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName=registernewuser(request,response);
				break;
			case "validate":
				viewName=validate(request,response);
				break;
			case "placeloan":
				viewName=placeloan(request,response);
				break;
			case "application1":
				viewName=application1(request,response);
				break;
			case "editLoanProcess"  :
				viewName=editLoanProcess(request,response);
				break;
			case "registeruser":
				viewName=registerUser(request,response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;	
			case  "displaystatus" :
				viewName=displaystatus(request,response);
				break;
			default : viewName = "notfound.jsp"; break;	
			}
		} catch (Exception ex) {
			
			throw new ServletException(ex.getMessage());
		}
			RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
			dispatch.forward(request, response);
	}
	private String validate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		/* write the code to validate the user */
		
		return "userhome1.jsp";
	}
	
	
	
	private  String placeloan(HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
		// TODO Auto-generated method stub
		//public  addLoan(String LoanName, String ApplicationNumber, String loanAmount, String ApplicationDate, String BusinessStructure, String BillingIndicator, String ContactAddress, String ContactNumber, String status, String email, String TaxPayer) throws SQLException,ClassNotFoundException {
		
		try {
		
		String ApplicationNumber=request.getParameter("ApplicationNumber");
		String LoanName = request.getParameter("LoanName");
		String LoanAmount=request.getParameter("LoanAmount");
		String ApplicationDate = request.getParameter("ApplicationDate");
		String BusinessStructure=request.getParameter("BusinessStructure");
		String BillingIndicator=request.getParameter("BillingIndicator");
		String Taxpayer=request.getParameter("Taxpayer");
		String ContactAddress=request.getParameter("ContactAddress");
		String ContactNumber=request.getParameter("ContactNumber");
		//String status=request.getParameter("status");
		String Email=request.getParameter("Email");
		String LoanNumber = request.getParameter("LoanNumber");
		
		this.connDao.addLoan(ApplicationNumber,LoanName, LoanAmount, ApplicationDate, BusinessStructure, BillingIndicator, ContactAddress, ContactNumber,Email,LoanNumber,Taxpayer);
		 
		
		return "listall.jsp";
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new ClassNotFoundException(e.getMessage());
		} catch (SQLException e) {
			// TODO: handle exception
			throw new SQLException(e.getMessage());
		}
		
	}
	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write the code to display the loan application page */
		
		return null;
	}
	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to edit the loan info */
		
		return null;
	}
	private String registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		/* write the code to redirect page to read the user details */
		return null;
	}
	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/* write the code to create the new user account read from user 
		   and return to index page */
		
		try {
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");
			String userpassword = request.getParameter("userpassword");
			this.connDao.registernewuserdao(userid, username, userpassword);
			//List<ProductMaster> products = this.productMasterDao.getProductRecords();
				// put data into request object (to share with view page)
				//request.setAttribute("products", products);
				return "index.jsp";
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new ClassNotFoundException(e.getMessage());
		} catch (SQLException e) {
			// TODO: handle exception
			throw new SQLException(e.getMessage());
		}
	}

	
	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */
		
		return null;
	}
	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		/* write the code the display the loan status based on the given application
		   number 
		*/
		try {
			
			List<LoanInfoDisplay> loandetails = this.connDao.getLoanRecords();
					// put data into request object (to share with view page)
					request.setAttribute("LoanDetails", loandetails);
					return null;
				
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				throw new ClassNotFoundException(e.getMessage());
			} catch (SQLException e) {
				// TODO: handle exception
				throw new SQLException(e.getMessage());
			}
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to editloan page */
		return null;
	}

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		
		return null;
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write a code to return to trackloan page */
		
		
		return null;
	}
}
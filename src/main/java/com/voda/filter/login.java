package com.voda.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.voda.entities.SchoolClass;
import com.voda.entities.student;
import com.voda.entities.subject;
import com.voda.entities.teacher;
import com.voda.utility.HibernateUtility;
import com.voda.DAO.*;

@WebServlet("/login")
public class login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private StudentDAO studentdao ;

    public login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		String error = "Incorrect credentials";
		request.setAttribute("error", error);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		Connection con = null ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vodafone?autoReconnect=true&useSSL=false",
					"root", "root123");
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}
		try {
		String sql = "select * from loginuser where email = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			{
				if(rs.getString(2).equals(password))
					{response.sendRedirect("class");}
				else {
					response.sendRedirect("index.jsp?error=Invalid Credentials");
				  }
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

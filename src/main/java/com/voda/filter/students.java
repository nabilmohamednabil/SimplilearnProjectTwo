package com.voda.filter;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/students")
public class students extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private StudentDAO studentdao ;

    public students() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

	     	this.studentdao =  new StudentDAO();
			List<student> mystudentlist = new ArrayList<student>();	 		
			mystudentlist=this.studentdao.GetAllStudents() ;
			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			request.setAttribute("mylist", mystudentlist);
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}

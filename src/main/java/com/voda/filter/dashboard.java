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

@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private SchoolClassDAO classdao ; 
    private StudentDAO studentdao ;
    private SubjectDAO subjectdao ;
    private TeacherDAO teacherdao ;
    

    public dashboard() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

			this.classdao   =  new SchoolClassDAO();	
			List<SchoolClass> myclasslist = new ArrayList<SchoolClass>();	 
			List<subject> mysubjectlist = new ArrayList<subject>();	 
			List<teacher> myteacherlist = new ArrayList<teacher>();	 
			
			myclasslist=this.classdao.GetAllClassess() ;
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
			request.setAttribute("myclasslist", myclasslist);
			request.setAttribute("mysubjectlist", mysubjectlist);
			request.setAttribute("myteacherlist", myteacherlist);
			dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
		

}

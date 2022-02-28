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

@WebServlet("/class")
public class first extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private SchoolClassDAO classdao ; 
    private StudentDAO studentdao ;
    private SubjectDAO subjectdao ;
    private TeacherDAO teacherdao ;
    private String asubject  = "" ;
    private String aclass  = "" ;
    private String ateacher  = "" ;
    private String ateachertoclass  = "" ;
    private String ateachertosubject  = "" ;
    
    
    public first() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		/*		
			student st1 = new student();
			st1.setStudentName("mohmaed khalil");
			student st2 = new student();
			st2.setStudentName("ahmed khalil");
			student st3 = new student();
			st3.setStudentName("haithum khalil");			
			List<student> studentList = new ArrayList<student>();			
			studentList.add(st1);
			studentList.add(st2);
			studentList.add(st3);		
			SchoolClass c1 = new SchoolClass();
			c1.setClassName("class1-A1");
			c1.setStudents(studentList);
			c1.setSubjects(SubjectList);
			c1.setTeachers(TeacherList);			
			t1.setSubjects(SubjectList);
			t2.setSubjects(SubjectList);
			t3.setSubjects(SubjectList);
			t4.setSubjects(SubjectList);		
			st1.setSchoolClass(c1);
			st2.setSchoolClass(c1);
			st3.setSchoolClass(c1);		
			session.beginTransaction();		
			session.save(c1);
            session.getTransaction().commit();
            sf.close();
         */
		 /*
		    SubjectDAO  subjectDao = new SubjectDAO( );
		    subject sub1 = new subject();
		    sub1.setSubjectName("chemistry");
		    subjectDao.add(sub1);		    
		    subjectDao.assign("english"  ,  "class2-A3" );		    
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
		*/   
		//   response.sendRedirect("login.jsp");
			this.classdao   =  new SchoolClassDAO();	
			this.subjectdao =  new SubjectDAO();
			this.teacherdao =  new TeacherDAO();
			List<SchoolClass> myclasslist = new ArrayList<SchoolClass>();	 
			List<subject> mysubjectlist = new ArrayList<subject>();	 
			List<teacher> myteacherlist = new ArrayList<teacher>();	 
			myclasslist=this.classdao.GetAllClassess() ;
			mysubjectlist =this.subjectdao.GetAllsubjects() ;
			myteacherlist =this.teacherdao.GetAllteachers() ;
			
			//this.subjectdao.assign("english"  ,  "class2-A3" );	
			 
			 
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("myclasslist", myclasslist);
			request.setAttribute("mysubjectlist", mysubjectlist);
			request.setAttribute("myteacherlist", myteacherlist);
			dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		this.classdao = new SchoolClassDAO();	
		this.subjectdao = new SubjectDAO();
		this.teacherdao = new TeacherDAO();
		
		SchoolClass xy =  new SchoolClass();
        teacher teach  =  new teacher();
		subject sub    =  new subject();
		
		String teacher = request.getParameter("teacher");
		String Subject = request.getParameter("Subject");
		String clas = request.getParameter("class");
		

	   if(clas != null) {	 
		   try {
			   xy.setClassname(clas); this.classdao.add(xy);
			   response.sendRedirect("class");
		    }
		   catch (Exception ex) {
			   response.sendRedirect("class?error3=Added Before");
		     }
		   }
		   
	   if(Subject != null) {
		   try {
		   sub.setSubjectname(Subject); this.subjectdao.add(sub);
		   response.sendRedirect("class");
		   }catch (Exception ex) {
			   response.sendRedirect("class?error=Added Before");
		     }
		   }
		 
	   if(teacher != null) {
		   try {
			   teach.setTeachername(teacher);this.teacherdao.add(teach);
			   response.sendRedirect("class");
	   }catch (Exception ex) {
		   response.sendRedirect("class?error2=Added Before");
	   }
		   }
		
		this.asubject = (String) request.getParameter("assignsubject");
		this.aclass = (String) request.getParameter("assignclass");
		this.ateacher = (String) request.getParameter("assignteacher");
		this.ateachertoclass = (String) request.getParameter("assignteachertoclass");
		this.ateachertosubject = (String) request.getParameter("assignteachertosubject");

		if( this.asubject != null && this.aclass != null ) {
			System.out.println("assignsubject is " + asubject + "......assignclass is .." + aclass );
			try{ 
				xy.setClassname(this.aclass);
				sub.setSubjectname(this.asubject);
				this.subjectdao.assign(sub, xy);
			    response.sendRedirect("class");
			}
			catch(Exception ex) {  response.sendRedirect("class?error4=Assigned Before");}
		}
		
		if( this.ateacher != null && this.ateachertoclass != null && this.ateachertosubject != null) {

	        try{
	        	String a = this.ateacher;
	        	String b = this.ateachertoclass;
	        	String c = this.ateachertosubject;
	        	this.teacherdao.assign(a,b,c);
	            response.sendRedirect("class");
	        }	        
	        catch(Exception ex) {response.sendRedirect("class?error5=Assigned Before");}
		}
		
	}
	
}

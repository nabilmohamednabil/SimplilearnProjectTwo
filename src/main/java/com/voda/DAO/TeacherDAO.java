package com.voda.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.voda.entities.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.voda.entities.*;
import com.voda.utility.HibernateUtility;

public class TeacherDAO {

	private  SessionFactory sf ;
	private  Session session  ;
	
	public TeacherDAO() {

	     this.sf  = HibernateUtility.get();
		
      }
	public void add (teacher su) {	
		 this.session = this.sf.openSession(); 
	     this.session.beginTransaction();		
	     this.session.save(su);
	     this.session.getTransaction().commit();
	     this.session.close();
	};
	
	public void assign ( String TeacherName , String ClassName , String SubjectName) {
		
		 this.session = this.sf.openSession(); 
		 this.session.beginTransaction();
		 
		 subject sub = new subject() ;
		 SchoolClass class1 = new SchoolClass();
		 teacher tech = new teacher();
		 
		 Query query        = this.session.createQuery("from subject where subjectname=:name");
		 query.setParameter("name" , SubjectName);
		 List<subject> lis =  query.list();		 
		 if(!lis.isEmpty())  { sub = (subject)lis.get(0); }
		 
		 Query query2        = this.session.createQuery("from teacher where teachername=:name");
		 query2.setParameter("name" , TeacherName);
		 List<teacher> Teacherlis =  query2.list();		 
		 if(!Teacherlis.isEmpty())  { tech = (teacher)Teacherlis.get(0); }
		 
		 Query query1        = this.session.createQuery("from SchoolClass where classname=:name");
		 query1.setParameter("name" , ClassName);
		 List<SchoolClass> mylis =  query1.list();		 
		 if(!mylis.isEmpty())  { class1 = (SchoolClass)mylis.get(0); }
		 
		 List<SchoolClass> classlist = new ArrayList<SchoolClass>();
		 if( tech.getClassess() != null) { 
			 classlist =tech.getClassess() ; 
			 if(! classlist.contains(class1))classlist.add(class1);  
		   }
		 else { classlist.add(class1); } ;
	     		 
	
		 List<subject> Sublist = new ArrayList<subject>();
		 if( tech.getSubjects() != null) { 
			 Sublist =tech.getSubjects() ; 
			 if(! Sublist.contains(sub)) Sublist.add(sub);  
			}
		 else { Sublist.add(sub); } ;
		 tech.setClassess(classlist);
	     tech.setSubjects(Sublist);
	     this.session.update(tech);
         this.session.getTransaction().commit();
	     this.session.close();
	
	}
	
	public List<teacher> GetAllteachers (){
	     this.session       = this.sf.openSession(); 
	     this.session.beginTransaction();
		 Query query        = this.session.createQuery("from teacher");
		 List<teacher> lis =  query.list();	
		 this.session.getTransaction().commit();
	     this.session.close();
		 return lis ;			
    }
	
	public void SessionClose() {
		this.session.close() ;

	}
	
}

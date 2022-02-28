package com.voda.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.voda.entities.*;
import com.voda.utility.HibernateUtility;


    public class StudentDAO {

	private  SessionFactory sf ;
	private  Session session  ;
	
	public StudentDAO() {

	     this.sf  = HibernateUtility.get();
	 
}
	
	
	public void add (student su) {	
		 this.session = this.sf.openSession();
	     this.session.beginTransaction();		
	     this.session.save(su);
	     this.session.getTransaction().commit();
	     this.session.close();
	    
	};
	
	
	public List<student> GetAllStudents(){
		 this.session = this.sf.openSession();
		 this.session.beginTransaction();	
		 Query query        = this.session.createQuery("from student");
		 List<student> lis =  query.list();	
		 this.session.getTransaction().commit();
	     this.session.close();
		 return lis ;
		
	}
	
	public void SessionClose() {
		this.session.close() ;

	}
	
}

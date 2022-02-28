package com.voda.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.voda.entities.*;
import com.voda.utility.HibernateUtility;

public class SubjectDAO {
	
	private  SessionFactory sf ;
	private  Session session  ;
	
	public SubjectDAO() {

	     this.sf  = HibernateUtility.get();
	
	}

	
	public void add (subject su) {	 
		 this.session = this.sf.openSession(); 
	     this.session.beginTransaction();		
	     this.session.save(su);
	     this.session.getTransaction().commit();
	     this.session.close();
	
	};
	
	public void assign ( subject SubjectName , SchoolClass ClassName) {
		System.out.println("SubjectName is " + SubjectName + "......ClassName is .." + ClassName );
		 this.session = this.sf.openSession(); 
		 this.session.beginTransaction();
		 subject sub = new subject() ;
		 SchoolClass class1 = new SchoolClass();
		 Query query        = this.session.createQuery("from subject where subjectname=:namee");
		 query.setParameter("namee" , SubjectName.getSubjectname());
		 List<subject> lis =  query.list();
		 if(!lis.isEmpty())  { sub = (subject)lis.get(0); }
		 Query query1        = this.session.createQuery("from SchoolClass where classname=:name");
		 query1.setParameter("name" , ClassName.getClassname());
		 List<SchoolClass> mylis =  query1.list();
		 if(!mylis.isEmpty())  { class1 = (SchoolClass)mylis.get(0); }
		 List<SchoolClass> classlist = new ArrayList<SchoolClass>();
		 if( sub.getClassess() != null) { 
			 classlist =sub.getClassess() ; 
			 if(! classlist.contains(class1)) classlist.add(class1);  
			 }
		 else { classlist.add(class1); } ;
	     sub.setClassess(classlist);			 
	
	
	    // this.session.update(sub);
         this.session.getTransaction().commit();
	     this.session.close();
	    
	}
	public List<subject> GetAllsubjects (){
	     this.session       = this.sf.openSession(); 
	     this.session.beginTransaction();	
		 Query query        = this.session.createQuery("from subject");
		 List<subject> lis =  query.list();	
		 this.session.getTransaction().commit();
	     this.session.close();
		 return lis ;			
    }
	public void SessionClose() {
		this.session.close() ;
	
	}

}

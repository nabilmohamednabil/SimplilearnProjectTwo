package com.voda.DAO;
import com.voda.entities.*;
import com.voda.utility.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.proxy.* ;


public class SchoolClassDAO {

	private  SessionFactory sf ;
	private  Session session  ;
	
	public SchoolClassDAO () {

	     this.sf  = HibernateUtility.get();
		
    }
	
	public void operation() {
		teacher t1 = new teacher();
		t1.setTeachername("nabil mohamed");
		teacher t2 = new teacher();
		t1.setTeachername("nabil mohamed");
		teacher t3 = new teacher();
		t1.setTeachername("nabil mohamed");
		teacher t4 = new teacher();
		t1.setTeachername("nabil mohamed");
		
		
		subject s1 = new subject();
		s1.setSubjectname("math");
		subject s2 = new subject();
		s1.setSubjectname("arabic");
		subject s3 = new subject();
		s1.setSubjectname("english");
		subject s4 = new subject();
		s1.setSubjectname("french");
		
		student st1 = new student();
		st1.setStudentname("mohmaed khalil");
		student st2 = new student();
		st2.setStudentname("ahmed khalil");
		student st3 = new student();
		st3.setStudentname("haithum khalil");
		
		List<teacher> TeacherList = new ArrayList<teacher>();
		List<subject> SubjectList = new ArrayList<subject>();
		List<student> studentList = new ArrayList<student>();
		TeacherList.add(t1);
		TeacherList.add(t2);
		TeacherList.add(t3);
		TeacherList.add(t4);
		
		SubjectList.add(s1);
		SubjectList.add(s2);
		SubjectList.add(s3);
		SubjectList.add(s4);
		
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
		
		this.session = this.sf.openSession(); 
		session.beginTransaction();	
		/*
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(st1);
		session.save(st2);
		session.save(st3);
	    */		
		SchoolClass c1 = new SchoolClass();
		c1.setClassname("class1-A1");
		c1.setStudents(studentList);
		c1.setSubjects(SubjectList);
		c1.setTeachers(TeacherList);
	     this.session.getTransaction().commit();
	     this.session.close();
	}
	public void add (SchoolClass su) throws Exception {	 
		 this.session = this.sf.openSession(); 
	     this.session.beginTransaction();	
	     this.session.save(su);
	     this.session.getTransaction().commit();
	     this.session.close();

	};
	
	public List<SchoolClass> GetAllClassess (){
		     this.session       = this.sf.openSession(); 
		     this.session.beginTransaction();	
			 Query query        = this.session.createQuery("from SchoolClass");
			 List<SchoolClass> lis =  query.list();
			 this.session.getTransaction().commit();
		     this.session.close();
			 return lis ;			
	}
	
	public void SessionClose() {
		this.session.close() ;

	}
	
		
}

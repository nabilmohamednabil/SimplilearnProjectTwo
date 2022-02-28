package com.voda.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn ;

@Entity
@Table(name="student")
public class student {
	
	public student() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column(name="StudentName")
	public String studentname ;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="class_id")
	private SchoolClass schoolclass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public SchoolClass getSchoolclass() {
		return schoolclass;
	}

	public void setSchoolclass(SchoolClass schoolclass) {
		this.schoolclass = schoolclass;
	}



	
	
}

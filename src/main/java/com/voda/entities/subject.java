package com.voda.entities;
import javax.persistence.Entity;
import javax.persistence.Table;

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
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn ;

@Entity
@Table(name="subject")
public class subject {
	
	
	public subject() {};
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column(name="SubjectName")
	public String subjectname ;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="ClassSubject",
			joinColumns=@JoinColumn(name="subject_id"),
			inverseJoinColumns=@JoinColumn(name="class_id")
			)	
	private List<SchoolClass> classess;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="TeacherSubject",
			joinColumns=@JoinColumn(name="subject_id"),
			inverseJoinColumns=@JoinColumn(name="teacher_id")
			)	
	private List<teacher> teachers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public List<SchoolClass> getClassess() {
		return classess;
	}

	public void setClassess(List<SchoolClass> classess) {
		this.classess = classess;
	}

	public List<teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<teacher> teachers) {
		this.teachers = teachers;
	}

	
	
}

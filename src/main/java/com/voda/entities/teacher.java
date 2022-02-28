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
@Table(name="teacher")
public class teacher {
	
	
	public teacher() {};
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column(name="TeacherName")
	public String teachername ;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="ClassTeacher",
			joinColumns=@JoinColumn(name="teacher_id"),
			inverseJoinColumns=@JoinColumn(name="class_id")
			)	
	private List<SchoolClass> classess;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="TeacherSubject",
			joinColumns=@JoinColumn(name="teacher_id"),
			inverseJoinColumns=@JoinColumn(name="subject_id")
			)	
	private List<subject> subjects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public List<SchoolClass> getClassess() {
		return classess;
	}

	public void setClassess(List<SchoolClass> classess) {
		this.classess = classess;
	}

	public List<subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<subject> subjects) {
		this.subjects = subjects;
	}
	
	
	

}

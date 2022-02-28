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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn ;

@Entity
@Table(name="SchoolClass")
public class SchoolClass {
	
	public SchoolClass() {}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id ;
	
	@Column(name = "ClassName")
	public String classname ;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="ClassTeacher",
			joinColumns=@JoinColumn(name="class_id"),
			inverseJoinColumns=@JoinColumn(name="teacher_id")
			)	
	private List<teacher> teachers;

	
	@ManyToMany(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(
			name="ClassSubject",
			joinColumns=@JoinColumn(name="class_id"),
			inverseJoinColumns=@JoinColumn(name="subject_id")
			)	
	private List<subject> subjects;
	
	@OneToMany(mappedBy="schoolclass",
			   cascade= {CascadeType.ALL},
			   fetch=FetchType.EAGER)
	private List<student> students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public List<teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<teacher> teachers) {
		this.teachers = teachers;
	}

	public List<subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<subject> subjects) {
		this.subjects = subjects;
	}

	public List<student> getStudents() {
		return students;
	}

	public void setStudents(List<student> students) {
		this.students = students;
	}
	
	
	
}

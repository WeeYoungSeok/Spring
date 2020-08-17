package com.test05;

public class Engineer {

	private Emp emp;
	private String dept;

	public Engineer() {
	}

	public Engineer(Emp emp, String dept) {
		this.emp = emp;
		this.dept = dept;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp + "\t부서 : " + dept;
	}

}

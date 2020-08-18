package com.test01;

public class Score {

	private String name;
	private int kor;
	private int eng;
	private int math;


	public Score() {
	}

	public Score(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return kor + eng + math;
	}

	

	public double getAvg() {
		return (double) (getSum() / 3);

	}

	

	public String getGrade() {
		 String res = "";
	      switch ((int) getAvg() / 10) {

	      case 10:
	      case 9:
	         res = "A";
	         break;
	      case 8:
	         res = "B";
	         break;
	      case 7:
	         res = "C";
	         break;
	      case 6:
	         res = "D";
	      default:
	         res = "F";
	      }
	      return res;
	   }


	

	@Override
	public String toString() {
		return "이름 : " + name + " \t국어 : " + kor + " \t영어 : " + eng + " \t수학 : " + math + " \t총점 : " + getSum() + " \t 평균 : "
				+ getAvg() + " \t등급 : " + getGrade();
	}
	
	
	
	
}

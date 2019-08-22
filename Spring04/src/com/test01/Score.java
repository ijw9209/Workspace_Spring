package com.test01;

import java.io.ObjectInputStream.GetField;
import java.util.List;

public class Score {

	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score() {
	}
	public Score(String name , int kor , int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
		return kor + math + eng;
	}
	
	public double getAvg() {
		return (double)(getSum()/3);
	}
	
	public String getGrade() {
		
		switch ((int)(getAvg() / 10)) {
		case 10:
			return "A";	
		case 9:
			return "A";	
		case 8:
			return "B";	
		case 7:
			return "C";	
		case 6:
			return "D";	
		case 5:
			return "E";	
		default:
			return "F";
		}
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Score [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ getSum() + ", avg=" + getAvg() + ", grade=" + getGrade() + "]";
	}
	
	public void setScore(List<Score> score) {
		System.out.println("setScore() 호출");
		
		for(Score sc : score) {
			System.out.println(sc);
		}
		//하나는 리스트안에서 이너빈으로 하나는 ref 값을 가지고 넣어서호출
	}
	
}

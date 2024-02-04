package com.dongsung.ch02;


//1. 프라이빗 필드로 year mont day 만듬.
//2. Source - > Generate Getters and Setters 추가.

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
	@Override
	public String toString() {
		return "MyDate [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	//3.투 스트링도 하나 만들어 줌. source-  > Generate toString()
	
	//4. 다 했으면 YoillTerRequestParam2 넘어가서 date로 다 바꿔줌
 
}

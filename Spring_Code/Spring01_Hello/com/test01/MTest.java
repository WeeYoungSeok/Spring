package com.test01;

public class MTest {
// 강결함 바로 Bean으로 연결
// 다른언어 추가할때 불편함
	public static void main(String[] args) {
		MessageBean bean = new MessageBean();
		bean.sayHello("Spring");
	}
}
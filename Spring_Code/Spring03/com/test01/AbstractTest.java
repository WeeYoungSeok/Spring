package com.test01;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {

	public abstract String dayInfo();
	// 나 자신을 객체로 만들어서 리턴해줄게!! 
	// 리턴타입이 자기 자신
	public static AbstractTest getInstance() {
		// 메모리에 단하나의 객체만 존재하게 만드는 것
		// 부를때마다 같은 주소값을 가지는 객체를 불러옴 (이미 만들어져있는것을 불러옴)
		
		GregorianCalendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		// 상속받는 클래스들
		// 다형성으로 인해서 자식객체가 부모타입으로 자동형변환 됨
		}
		
		return null;
	}
}

package com.wee.weestagram;

public class ConstantDemo {

	/*
	 * class Fruit {
	 * public static final Fruit APPLE = new Fruit(); 
	 * public static final Fruit PEACH = new Fruit(); 
	 * public static final Fruit BANANA = new Fruit();
	 *  }
	 */
	
	// enum은 사실 클래스다. 고로 생성자를 가질 수 있다.
	enum Fruit {
		// APPLE, PEACH, BANANA; 이거는 생성자 호출
		
		APPLE("red"), PEACH("pink"), BANANA("yellow");
		// 이것은 생성자 호출할때 매개변수를 갖는 생성자에게 부여된다
		// red,pink,yellow 등
		// 이 color는 스위치문에서 가져올 수 있다.
		
		// enum도 클래스이기 때문에 필드값을 가질수 있다.
		public String color;
		
		// 메소드 생성도 가능하다.
		public String getColor() {
			return this.color;
		}

		// 클래스 네임과 같은 메소드는 생성자이다.
		// enum도 마찬가지다.
		Fruit(String color) {
			System.out.println("생성자 호출" + this);
			this.color = color;
			// this.color의 color는 전역변수고
			// color는 지역변수를 의미
			// 전역변수보다 지역변수가 우선순위가 높기때문에
			// 전역변수는 this라고 명시해주어야한다.
		}

		/*
		 Fruit() {
		 	System.out.pringln("생성자 호출" + this);
		 }
		 */
		// 실행해보면
		/*
		 * 생성자 호출APPLE 
		 * 생성자 호출PEACH 
		 * 생성자 호출BANANA 
		 * 57kcal
		 * 결과값이다. 
		 */
		// 이유는 위의 class Fruit와 같은 의미를 필드가 가지고 있기 때문에
		// new Fruit가 3번 호출이 되었기 때문에 생성자가 3번 호출된다.
	}

	enum Company {
		GOOGLE, APPLE, ORACLE;
	}

	public static void main(String[] args) {
		/*
		Fruit type = Fruit.APPLE;
		switch (type) {
		case APPLE:
			// 결과는 같다.
			// 하지만 구현 방법은 다르다.
			System.out.println(57 + "kcal, color " + Fruit.APPLE.getColor());
			//System.out.println(57 + "kcal, color " + Fruit.APPLE.color);
			// 여기서 이런식으로 가져오면 된다.
			break;
		default:
			break;
		}
		*/
		
		for (Fruit f : Fruit.values()) {
			// values는 enum Fruit안에 있는 필드를 하나씩 꺼내서 f에 담아준다.
			System.out.println(f + " " + f.getColor());
			// 마치 배열처럼 상수들을 하나씩 꺼내서 처리할 수 있는 기능도 제공한다.
		}
	}
}

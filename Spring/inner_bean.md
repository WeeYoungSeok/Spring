### Inner Bean

- Score

```java
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

	public String toString() {
		return "이름 : " + name + " \t국어 : " + kor + " \t영어 : " + eng + " \t수학 : " + math + " \t총점 : " + getSum() + " \t 평균 : "
				+ getAvg() + " \t등급 : " + getGrade();
	}
```



- MTest

```java
public class MTest {

	public static void main(String[] args) {
		ApplicationContext factory =
				new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");		
}
```



- BeanTest

```java
public class BeanTest {
	public BeanTest() {
		System.out.println("기본 생성자!!");
	}

public void setScore(List<Score> list) {
		System.out.println("setScore(List<Score> list) 호출");
		for (Score sc : list) {
			System.out.println(sc);
		}
	}
}
```



- applicationContext.xml

```xml
<bean id="beanTest" class="com.test01.BeanTest">
    <property name="score">
			<list>
				<bean class="com.test01.Score">
					<constructor-arg name="name" value="위영석" />
					<constructor-arg name="kor" value="40" />
					<constructor-arg name="eng" value="60" />
					<constructor-arg name="math" value="70" />
				</bean>

				<bean class="com.test01.Score">
					<property name="name" value="박정은"></property>
					<property name="kor" value="90"></property>
					<property name="eng" value="60"></property>
					<property name="math" value="70"></property>
				</bean>
				<ref bean="score" />
			</list>
		</property>
</bean>

<bean id="score" class="com.test01.Score">
		<property name="name" value="한지용"></property>
		<property name="kor" value="55"></property>
		<property name="eng" value="60"></property>
		<property name="math" value="70"></property>
	</bean>
```

> inner bean이랑 bean안에서 bean을 또 쓰는 형태를 의미한다.
>
> 먼저 BeanTest라는 객체를 생성해준 뒤 그 안에서 setScore라는 함수를 호출하기위해 property를 선언했고 그리고 list안에 또 다시 Score라는 객체를 만들어서 list에 담아준 형태가 된다. list안에서 inner bean으로 객체를 생성할수도 있고 BeanTest의 bean밖에서 새로운 Score객체를 생성하여 setter injectino을 한 객체를 불러와 리스트에 담는것도 가능하다.

 
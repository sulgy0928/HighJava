package PracticeP;


class Tv{ //클래스 생성.(티비.)
	//Tv의 속성(전역변수)
	String color;		// 색상
	boolean power;		// 전원상태(on/off)
	int channel;		// 채널
	
	//Tv의 기능(메서드)
	//void power() {power = !power; }  	//전원
	void channelUP()	{ ++channel;}	//채널 업
	void channelDOWN()	{ --channel;}	//채널 다운
	
	
	
}


class TvTest{
	public static void main(String[] args) {
		Tv t;					//Tv 인스턴스를 참조하기 위한 변수 t를 선언
		t = new Tv();			//Tv 인스턴스를 생성한다.
		t.channel=7;			//Tv 인스턴스의 메서드 channel의 값을 7로 한다.
		t.channelDOWN();		//Tv 인스턴스메서드의 chnnelDown()을 호출한다.
		t.channelDOWN();
		t.channelDOWN();
		t.channelUP();
		t.channelUP();
		t.channelUP();
		System.out.println("현재채널 : " + t.channel + " 번");
	
		
	
	
	}

}






















































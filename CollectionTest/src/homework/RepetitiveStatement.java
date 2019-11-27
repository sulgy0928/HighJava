package homework;

import java.util.Scanner;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 *  << for 문 >>
		 *  - for(int i=1; i<=10; i++){}
		 *  - for(1부터 10까지 1씩 증가하면서 반복 ){}
		 */
//
//		for(int i = 1; i <= 10; i++){
//			//for(초기화; 조건식; 증감식){}
//			//초기화: 조건식과 증감식에 사용할 변수 초기화
//			//조건식: 연산결과가 true이면 블럭 안의 내용을 수행한다.
//			//증감식: 변수를 증가/감소시켜 반복문을 제어한다.
//			System.out.println(i + "번째 반복");
//			//초기화한 변수를 블럭 안에서 사용할 수 있다.
//		}
//		
//		int sum = 0; //1부터 10까지 합계를 저장
//		
//		sum += 1;
//		sum += 2;
//		sum += 3;
//		sum += 4;
//		sum += 5;
//		sum += 6;
//		sum += 7;
//		sum += 8;
//		sum += 9;
//		sum += 10;
//		System.out.println(sum);
//		
//		sum = 0;
//		//반복문을 사용하면 규칙이 있는 반복되는 작업을 짧게 표현할 수 있다.
//		for(int i = 1; i <= 100; i++){
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for(int i = 100; i >= 1; i--){ //100부터 1까지 1씩 감소하면서 반복한다.
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		//1부터 100까지 짝수의 합을 구해보자.
//		
//		sum = 0;
//		for(int i = 0; i <= 100; i += 2){
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for(int i = 1; i <= 100; i++){
//			if(i % 2 == 0){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//		
//		
//		//★ 1부터 100까지 홀수의 합을 구해주세요.
//		
//		sum = 0;
//		for(int i = 1; i <= 100; i += 2){
//			sum += i;
//		}
//		System.out.println(sum);
//		
//		sum = 0;
//		for(int i = 1; i <= 100; i++){
//			if(i % 2 == 1){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
//		
//		
//		
//		//구구단을 출력해보자.
//		/*
//		 * 2 * 1 = 2
//		 * 2 * 1 = 4
//		 * 2 * 1 = 6 
//		 * 2 * 1 = 8
//		 * ...
//		 */
//		
//		for(int i = 1; i <= 9; i++){
//			System.out.println("2 * " + i + " = " + i * 2);
//		}
//		
//		
//		//★ 7단을 출력해보자.
//		
//		System.out.println("7단");
//		
//		for(int i = 1; i <= 9; i++){
//			System.out.println("7 * " + i + " = " + i * 7);
//		}
//	
//	
//		for(int j = 2; j <= 9; j++){ // 주로 변수이름은 i부터 사용.i j k 순서
//			for(int i = 1; i <= 9; i++){
//				System.out.println(j + " * " + i + " = " + i *j);
//			}
//		}
//		
//		
//
//		//★ 구구단 전체의 짝수단의 홀수줄만 출력해주세요.
//		
//		for(int j = 2; j <= 9; j += 2){
//			for(int i = 1; i <= 9; i += 2){
//				System.out.println(j + " * " + i + " = " + j * i);
//			}
//		}
//			System.out.println("if");
//		
//		for(int j = 2; j <= 9; j++){
//			if(j % 2 == 0){
//			for(int i = 1; i <= 9; i += 2){
//				if(i % 2 == 1){
//				System.out.println(j + " * " + i + " = " + j * i);
//				}
//			}
//			}
//		}
//		
//		//★ 구구단 전체를 가로로 출력해주세요.
//		/*
//		 * 2 * 1 = 2	3 * 1 = 3	4 * 1 = 4	...
//		 * 2 * 2 = 4	3 * 2 = 6	4 * 2 = 8	...
//		 */
//		
//		
//		for(int j = 1; j <= 9; j++){
//			for(int i = 2; i <= 9; i++){
//			System.out.print(i + " * " + j + " = " + i * j + "\t");
//			}
//		System.out.println();
//		}
//	
//	
//		/*
//		 * << while 문 >>
//		 * - while(조건식){}
//		 * - 조건식의 결과가 true인 동안 계속해서 반복
//		 * - 반복횟수를 알 수 없을 때 사용한다. 
//		 */
//	
//		Scanner s = new Scanner(System.in);
//	
//		while(true){
//			System.out.println("몇 단을 출력할까요?(0:종료)");
//			int dan = Integer.parseInt(s.nextLine());
//			
//			if(dan == 0){
//				System.out.println("종료되었습니다.");
//				break;
//			}
//			
//			for(int i = 1; i <= 9; i++){
//				System.out.println(dan + " * " + i + " = " + dan + i);
//			}
//		}
//	
//	
//		/*
//		 * << do-while 문 >>
//		 * - do{ }while(조건식);
//		 * - 최소한 한번의 수행을 보장한다. 
//		 */
//	
//		
//		
//		//숫자 맞추기 게임을 만들어보자.
//		
//		int answer = (int)(Math.random() * 100) + 1;
//		//1~100 사이의 랜덤 수를 발생시킨다.
//		int input = 0;
//		
//		do{
//			System.out.println("1 ~ 100 사이의 수를 입력해주세요.");
//			input = Integer.parseInt(s.nextLine());
//			
//			if(answer < input) {
//				System.out.println(input + "보다 작습니다.");
//			}else if(input < answer){
//				System.out.println(input + "보다 큽니다.");
//			}else{
//				System.out.println("정답입니다!");
//			}
//		}while(input != answer); //세미콜론을 붙여야 한다.
//		
////		
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		
//		//이름붙은 반복문
//		outer: for(int i = 2; i <= 9; i++){
//			for(int j = 1; j <= 9; j++){
//				if(j == 5){
////					break; //가장 가까운 반복문 하나를 빠져나간다.
////					break outer; //outer이라는 이름의 반복문을 빠져나간다.
////					continue; //가장 가까운 반복문의 현재 반복 회차를 빠져나간다. (증감식으로 간다.)
//					continue outer; //outer라는 이름의 현재 반복회차를 빠져나간다. (outer의 증감식으로 간다.)
//				}
//				System.out.println( i + " * " + j + " = " + i * j);
//			}
//			System.out.println();
//		}
//	
//		
		/*
		 * 123
		 * 
		 * 135 1S 1B 1O
		 * 126 2S 0B 1O
		 * 219 0S 2B 1O
		 */
		
		/*
		 * 136	0S 1B 2O
		 * 217	1S 1B 0O
		 * 123	0S 1B 2O
		 * 318	1S 0B 2O
		 * 517	1S 2B 2O
		 * 
		 * 
		 * 715	3S
		 */
		
		
/*		int ans_1 = (int)(Math.random() * 9) + 1;
		int ans_2 = (int)(Math.random() * 9) + 1;
		int ans_3 = (int)(Math.random() * 9) + 1;
			
		
			do{	if(ans_1 == ans_2){
					ans_2 = (int)(Math.random() * 9) + 1;
				}else
					ans_2 = ans_2;
			}while(ans_1 == ans_2);		
			
			
			do{ if(ans_1 == ans_3 || ans_2 == ans_3){
					ans_3 = (int)(Math.random() * 9) + 1;
				}else
					ans_3 = ans_3;
			}while(ans_1 == ans_3 || ans_2 == ans_3);

			
			
		int inp_1 = 0;
		int inp_2 = 0;
		int inp_3 = 0;
		
		
		
			System.out.println("세 자리 수를 맞추는 야구 게임입니다.");
		do{
			System.out.println("첫 번째 숫자를 입력해주세요.");
			
				inp_1 = 0;
				inp_2 = 0;
				inp_3 = 0;
				
				inp_1 = Integer.parseInt(s.nextLine());
				
				if(ans_1 == inp_1) {
					System.out.println("1S 0B 0O");
				}else if(ans_2 == inp_1){
					System.out.println("0S 1B 0O");
				}else if(ans_3 == inp_1){
					System.out.println("0S 1B 0O");
				}else{
					System.out.println("0S 0B 1O");
				}
			
			System.out.println("두 번째 숫자를 입력해주세요.");
				
				inp_2 = Integer.parseInt(s.nextLine());
				
				if(ans_1 == inp_2) {
					System.out.println("0S 1B 0O");
				}else if(ans_2 == inp_2){
					System.out.println("1S 0B 0O");
				}else if(ans_3 == inp_2){
					System.out.println("0S 1B 0O");
				}else{
					System.out.println("0S 0B 1O");
				}
			
			System.out.println("세 번째 숫자를 입력해주세요.");
				
				inp_3 = Integer.parseInt(s.nextLine());
			
				if(ans_1 == inp_3) {
					System.out.println("0S 1B 0O");
					System.out.println("다시 한 번 시도해주세요.");
				}else if(ans_2 == inp_3){
					System.out.println("0S 1B 0O");
					System.out.println("다시 한 번 시도해주세요.");
				}else if(ans_3 == inp_3){
					System.out.println("1S 0B 0O");
					System.out.println("다시 한 번 시도해주세요.");
				}else if(inp_1 != ans_1 && inp_2 != ans_2 && inp_3 != ans_3){
					System.out.println("0S 0B 1O");
					System.out.println("다시 한 번 시도해주세요.");				
				}else{
					System.out.println("축하합니다. 정답입니다.");
				}
			}while(inp_1 != ans_1 && inp_2 != ans_2 && inp_3 != ans_3);*/
		
			Scanner s = new Scanner(System.in);
		
			int input = 0;
		
			int a1, a2, a3;
			a1 = (int)(Math.random() * 9) + 1;
			
			do{
				a2 = (int)(Math.random() * 9) + 1; 
			}while(a1 == a2); //두 값이 같을 때
			
			do{
				a3 = (int)(Math.random() * 9) + 1;
			}while(a3 == a1 || a3 == a2);
			
			System.out.println(a1);
			System.out.println(a2);
			System.out.println(a3);
			
	/*		Scanner s = new Scanner(System.in);*/
			int count = 0;
			while(true){
				System.out.println("3자리 숫자를 입력해주세요.");
				int input_1 = Integer.parseInt(s.nextLine());
				int i3 = input_1 % 10;
				input_1 /= 10;
				int i2 = input_1 % 10;
				input_1 /= 10;
				int i1 = input_1;
				System.out.println(i1);
				System.out.println(i2);
				System.out.println(i3);
				
				int strike = 0;
				int ball = 0;
				int out = 0;
				
				if(a1 == i1) strike++;
				if(a2 == i2) strike++;
				if(a3 == i3) strike++;
				
				if(a1 == i2 || a1 == i3) ball++;
				if(a2 == i1 || a2 == i3) ball++;
				if(a3 == i1 || a3 == i2) ball++;
				
				out = 3 - strike - ball;
				
				System.out.println(++count + "차 시도(" + i1 + i2 + i3 + " ) : " +
									strike + "S " + ball + "B " + out + "O");
				System.out.println("----------------------");
				if(strike == 3){
					System.out.println("정답입니다!");
					break;
				}
											
				
			}
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
}





















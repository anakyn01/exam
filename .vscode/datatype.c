#include <stdio.h>
int a = 5;//아무곳에서나 사용함 5층 4층 3층

void fn(){ //나는 주사파가 아니기 때문에 불러야만 움직임 "함수는 호출만 실행되는 코드블럭"
    a = a + 3; //8 지역변수
}

int main(){

    a = a + 5; //a는 5가 sabe 되어 있으므로 5+5 10이되고 10을 1라는 변수에 저장
    fn(); //fn이라는 사용자 정의 함수
    printf("%d", a);
    char a; int b = 4; float c, d;
    double e=1.1, f=2.4;

    //전역변수 : 어떤 블록에도 속하지 않는 변수
    return 0;

}
/*
자료형(Data type)
- 자료형은 프로그래밍 언어에서 실수, 정수 자료형과 같은 여러종류의 데이터를 식별하는 형태

자료형에 유형
문자형(character) 선언형식 char
정수형(Integer) int
부동 소수점형(Floating point) float double

식별자 identifier : 변수,상수,함수등 서로 구분하기 위해서 사용되는 이름
식별자 표기법
Camel Case => inputFunction
Pascal Case => PascalCase
Snake Case => input_function
Hungarian Case => nScore 식별자 표기시에 두어에 자료형을 붙이는 표기법
cSingleChar

변수(Variable)의 개념
- 저장하고자하는 어떤 값이 있을때 그 값을 주기억장치에 기억하기 위한 공간
- 자료형과 변수명을 작성하여 변수를 생성하는 과정

int a[10 ] = ;

변수선언 variable declaration 변수나 함수가 있을을 알려주는 행위
초기화하지 않는경우 => 자료형 변수명;
초기화하는 경우 => 자료형 변수명 = 초깃값
*/

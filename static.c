#include<stdio.h>

void fn() {
    static int a = 3;//static변수는 블록 내외부와 상관없이 선언할수 있는 변수
    //프로그램이 시작되면 변수가 생성되고 프로그램이 종료되면 변수가 소멸
    //최초 초기화 를 한번만 수행
    a = a + 1;
    printf("%d\n", a);
    printf("표준입출력 함수 printf 이다 \n \t");
}

int main(){
    fn(); //4 
    fn(); //5 증가한것이 아니라 초기화를 안한것이다
    printf("Hello\tC\nWorld");
    return 0;
}
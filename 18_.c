#include <stdio.h>

void main(){
    char *p = "KOREA"; //01234
    printf("%s\n", p); //전체 문자열 KOREA
    printf("%s\n", p+3); //EA 시작점과 끝점
    printf("%c\n", *p); //K
    printf("%c\n", *(p+3)); //E
    printf("%c\n", *p + 2);
    //'K'의 ASC||코드 값이 75 + 2 = 77 M
}
#include <stdio.h>

int main(){
    char a[] = "Art"; //'A''r''t''\0'
//a[0{A}],a[1{r}],a[2{t}],a[3{\0}]
    char* p = NULL;
//p는 "char가 있는 주소를 가리키는 변수  Null은 아직 아무것도 가리키지 않음을 의미"
    p = a;//문자열 전체지먼 포인터로 쓰일때는 a[0]의 주소로 자동 변환
 //a 는 &a[0]의 주소를 가르킴   
//p = &a[0]의 주소를 가리킴

printf("%s\n", a);//Art
printf("%c\n" *p);//A
printf("%c\n" *a);//A

for(int i=0; a[i] != '\0'; i++)
    printf("%c",a[i])
}
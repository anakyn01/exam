#include <stdio.h>

struct good{
    char name[10];
    int age;
};

void main(){
    struct good s[] = {"kim",28,"Lee",38,"Seo",50,"Park",35};
    
    struct good *p;
    p = s;//p는 구조체 배열 s의 첫번째 요소 주소, 즉 &s[0]을 가르킴
    p++;//순서에서 하나를 증가
    printf("%s\n", p -> name);
    printf("%d\n", p -> age);
}
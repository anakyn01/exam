#include <stdio.h>
void main(){
    int i =0, c = 0;
    while (i < 10){
    i++;
    c *= i;
    }
    printf("%d", c); 
    //c가 0이므로 어떤수를 곱해도 0이 됩니다
}
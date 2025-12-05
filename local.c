#include <stdio.h>
int main(){
    int a = 3, b=4;
    {
        int a = 5;
         printf("%d %d\n", a, b);//54
    }
    printf("%d %d\n", a, b);
    return 0;
}
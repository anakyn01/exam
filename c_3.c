#include <stdio.h>
int main() {
    char* a = "qwer";
    char* b = "qwtety";
for(int i=0; a[i] !="\0"; i++){
    for(int j =0; b[j] !="\0"; j++){
        if(a[i] == b[j]) printf("%c",a[i])
    }
}

}

/*q  q = q
w  w = w
e  t
r  e
\0 t
   y 
   \0

abc
cbarrrrr

순서로 비교하지 않고 전부 검색하여 매칭되는걸 찾는다
   
*/
#include <stdio.h>

//자기보다 근 값이 몇개 있는지 세어서 순위를 매기는 코드

void main{

    int []result = int[5];//배열이 몇개가 들어가는지
    int []arr = [77,32,10,99,50];//주어진 배열

    for(int i=0; i<5; i++){
        result[i] = 1;//arr[i] 개별의 순위 가장큰값이 순위 1
        //result[i] = 1 시작하는 이유는 자기 자신을 포함한 순위 개념이기 때문에
        for(int j=0; j<5; j++){
            if(arr[i] < arr[j]) result[i]++
        }
    }
    for(int k=0; k < 5; k++){
        printf(result[k]);
    }


}
/*
각 원소별 계산과정
i =0 -> arr[0] = 77
77 < 99 -> 참 1번 증가 1 + 1 = 2

i = 1 -> arr[1] =32 
result[1] = 1 + 3 = 4

i = 2 -> arr[2] = 10 5
1 + 4 = 5

i = 3 -> arr[3] = 99 1
result[3] = 1 

i = 4 -> arr[4] = 50 3
50 < 77 -> true 1
50 < 99 -> true 1
*/
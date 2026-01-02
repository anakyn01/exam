int main(){
    //이 예제는 시험 문제에 자주 출제되는 악마의 c 배열과 포인터 문제 입니다

    int ary[3]; //정수 3개를 저장할 배열
    int s = 0; //합계를 저장할 변수
    *(ary + 0) = 1; //ary[0] = 1;
    ary[1] = *(ary+0) + 2; //ary[1] = 1 + 2 = 3
    ary[2] = *ary + 3;//ary[2] = ary[0] + 3 = 1 + 3 = 4

    for (int i =0; i < 3; i++){
        s = s +ary[i];
    }

    printf("%d", s)

}

int main(){
    int res; //정수형 변수 res를 시작합니다
    res = mp(2, 10);//2 ^ 10 
    //mp(2, 10)함수를 호출하여 결과를 res에 저장합니다
    printf("%d", res);
    //res에 저장된 값을 정수 형태로 화면에 출력
    return 0;
}

int mp(int base, int exp){
    //지수(exponent)  base ^ exp를 계산하는 함수
    int res = 1;//결과를 저장할 변수를 1로 초기화
    for(int i=0; i < exp; i++){
        //i는 0부터 시작하여 i가 exp(10보다 작을 동안)
        res = res * base;
        //한번 반복할때 마다 res *= base를 실행
    }
    return res;
}
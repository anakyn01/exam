#include <stdio.h>
#define SIZE 3
// 아래는 고정 크기 원형 큐 를 구현한 프로그램 입니다
//front는 dequeue위치를 rear는 enqueue[삽입]위치를 나타냅니다
typedef struct {
    int a[SIZE];
    int front;
    int rear;
} Queue;

//아래는 원형큐에서 삽입연산을 수행하는 코드입니다
void enq(Queue* q, int val){
/*
Queue* q Queue 구조체의 포인터 입니다
큐를 가르키는 포인터로 함수안에서 큐의 내용(front, rear, a[]) 등을 수정할수 있다
int val 큐에 삽입할 데이터의 값
*/
q -> a[q -> rear] = val;
//q -> a : 큐구조체 안의 배열
//q -> rear : 현재 rear(뒤쪽인덱스)를 가리키는 멤버변수
//rear위치에 새로운 값을 삽을 한다는 의미

q -> rear = (q -> rear + 1) % SIZE;
/*
큐의 크기를 사이즈라 할때 rear인덱스를 다음위치로 이동시키되 배열의 끝에 도달하면 
다시 0으로 돌아가게 합니다
즉 원형으로 돌아가게 (mod 연산)을 하는것

size 현재 rear 계산식 새로운 rear
5    0        (0 + 1) % 5     1
5    3        (3 + 1) % 5     4
5    4        (4 + 1) % 5     0 -> 배열의 처음으로 돌아감
*/
}

//dequeue (=삭제/출력 연산)
int deq(Queue* q){
    int val = q -> a[q -> front];
//큐의 맨앞에 있는 데이터를 꺼냅니다
    q -> front = (q->front + 1) % SIZE;
//배열에서 프론트위치의 값을 가져옵니다
    return val;
//그값을 val이라는 임시변수에 저장합니다
}

int main(){
    Queue q = {{0}, 0, 0};
    enq(&q, 1); enq(&q, 2); deq(&q); enq(&q, 3);

    int first = deq(&q);
    int second = deq(&q);
    printf("%d 그리고 %d", first, second);

    return 0;
}
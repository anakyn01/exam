/*
이코드는 상속과 메서드 오버라이딩 그리고 재귀호출
핵심 포인트 child는 parent를 상속한다
타입은 Parent이지만 실제 객체는 Child이므로
Child에 compute()가 실행된다

동적 바인딩(Dynamic Binding)

숫자가 1이하이면 그냥 그 숫자를 바로 반환
숫자가 2이상이면 자기 자신을 두번 부른다
하나는 num -1 하나는 num -3
*/

class Parent{
    public int compute(int num){
        if(num <= 1) return num;
        return compute(num-1) + compute(num-2);
    }
}
class Child extends Parent{
    public int compute(int num){
        if(num <= 1) return num;//n이 1이하 -> 바로 n을 리턴 0, 1
        //compute(1) -> 1, compute(0) -> 0, compute(-1) -> -1
        return compute(num-1) + compute(num-3);
        /*
        4 -1 + 4 -3 = 4
        3-2[1] + 3 -3[0] = 1
        2-1[1] + 3 -3[0] = 1
1-3[-2] + 3 - 1[2] = 0 =1
0-1[-1] + 3- 0 [3] = -2 = 0

        */
        //n이 2이상일때 (n-1) (n-3) 두 갈래로 재귀호출
        /*
compute(4) -> compute(3) -> compute(1)
compute(3) -> compute(2) -> compute(0)
compute(2) -> compute(1) -> compute(-1)



        단계별로 값 채워 넣기
        compute(4)가 compute(3)에게 전화함 
        compute(3)은 compute(2)와 compute(0)에게 전화
        compute(2)는 compute(1)과 compute(-1)에게 전화

        숫자를 줄이면서 친구에게 부탁하는 함수
        컴퓨터4가 두친구에게 부탁한다
        숫자에서 1을 뺀 친구 compute(3)
        숫자에서 3을 뺀 친구 compute(1)

        그래서 컴퓨트 뒤에 (3)(1)이 붙는다
        */
    }
}

public class Exam_19 {
    public static void main(String[] args){
//메인에서 실제로 실행되는 객체 겉보기 타입은 Parent 실제 Child
        Parent obj = new Child();
        System.out.print(obj.compute(4));
        //따라서 프린트에서 obj.compute(4)를 호출하면 child의 컴퓨트가 실행됨
        //이것이 동적 바인딩
        //답이 1이 나오는 이유는 compute(4)는 compute(3)과 compute(1)을 더하는데

    }
}

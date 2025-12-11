//상속과 메서드 오버라이딩의 기본 예제입니다
public class Ovr_19 {
    public static void main(String[] args){
        Ovr_19 a1= new Ovr_19();
        Ovr_20 a2= new Ovr_20();
        System.out.println(a1.sun(3,2) + a2.sun(3,2));
    }

    int sun(int x, int y){//sun 메서드는 x + y덧셈 결과를 리턴
        return x + y;
    }
}

class Ovr_20 extends Ovr_19{//클래스 ovr_20은 ovr_19를 상속받음
    //메서드 오버라이딩(덮어쓰기)
    int sun(int x, int y){
        return x - y + super.sun(x,y);
        //
    }
}

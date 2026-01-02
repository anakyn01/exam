class Static{
    public int a = 20;//일반 변수(인스턴스 변수)
//new Static()으로 객체를 만들때 마다 그 객체 안에서 따로 생김
//즉 st1.a 와 st2.a는 서로 다른 값을 가질수 있다
    static int b = 0;
/*
static 변수 (클래스 변수)
- 객체랑 상관없이 클래스에 딱 1개만 존재
- Static.b는 모든 객체가 공유하는 공용값
- st.b로 접근해도 사실은 Static.b와 또같은 곳을 가리킴
*/
}

//정적 변수에 대한 문제
public class Main_1 {
    
    public static void main(String[] args){
int a; //메인 함수안의 지역변수 a를 만들고 10을 넣음
a =10; //Static 클래스의 a랑 전혀 다른 변수야 (이름만 같음)
Static.b = a; //10

        Static st = new Static();//static 객체 생성 

        System.out.println(Static.b++);//10
        System.out.println(st.b);
        System.out.println(a);
        System.out.print(st.a);
    }
}

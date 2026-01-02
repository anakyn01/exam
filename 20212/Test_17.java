//클래스 내에서 객체 생성없이 사용할수 있는 메소드로 빈칸에 알맞는 키워드와 출력 결과를 작성하세요

public class Test_17 {

    public static void main(String[] args){
        System.out.print(Test_17.check(1));
    }

  /*[ */ static/*] */  String check(int num){
        return(num >= 0) ? "positive":"negative";//삼항 연산자  
    }
    
}

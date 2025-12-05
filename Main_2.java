public class Main_2 {
    
    //자바스크립트 함수 자바 메소드 파이선 함수 c함수 : 호출할때만 실행
    //아래에 체인지 메소드를 만든다
    public static void change( String[] data, String s){
        //change 메소드는 두 개의 인자를 받습니다 String[] data배열과 String 문자열
        s = "Z";        
        data[0] = s;//배열의 첫번째 요소 s라는 스트링으로 만듬
                //s가 Z인건 메소드 안에서만
    }

    //출력포트
    public static void main(String[] args){
        String data[] = {"A"};// 위에하고 같아보이나 다른값
        String s = "B";// B라고 정의함
        change(data, s);
        System.out.println(data[0] + s); //BB가 나옴
    }


}
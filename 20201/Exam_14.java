//스위치에 break가 없는걸 주의하고 실행하세요
public class Exam_14{//동작 분석 switch에 fall-through 때문에
    public static void main(String[] args){
        int i = 3;//초기값 i는 3
        int k = 1;//초기값 k는 1
        switch(i){//스위치가 i를 택함
            case 0 : break;
            case 1 : break;
            case 2 : break;
            case 3 :k =0; break;//i는 3이기 때문에 여기서 시작
            case 4 :k += 3; break;//3
            case 5 :k -= 10; break;//-7
            default:k--;//-8
        }
        System.out.print(k);
    }
}

/*
//스위치에 break가 없는걸 주의하고 실행하세요
public class Exam_14{//동작 분석 switch에 fall-through 때문에
    public static void main(String[] args){
        int i = 3;//초기값 i는 3
        int k = 1;//초기값 k는 1
        switch(i){//스위치가 i를 택함
            case 0;
            case 1;
            case 2;
            case 3 k =0;//i는 3이기 때문에 여기서 시작
            case 4 k += 3;//3
            case 5 k -= 10;//-7
            default:k--;//-8
        }
        System.out.print(k);
    }
}
*/
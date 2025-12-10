public class Good_17 {
    
    public static void main(String[] args){
        int i, j;
        for(j=0, i=0; i<=5; i++){//0,1,2,3,4,5
            j += i;
            System.out.print(i);//0+1+2+3+4+5=15
            if(i==5){//i는 5가 아니면 +출력
                System.out.print("=");
                System.out.print(j);
            }else{
                System.out.print("+");
            }
        }
    }
}

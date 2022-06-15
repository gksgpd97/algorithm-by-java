import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
      abc(0);
    }

    public static void abc(int x){
        if (x == 3) //종료조건, base condition
            return;
        System.out.println(x);
        abc(x+1);
        System.out.println(x);
        return;
    }
}
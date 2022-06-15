import java.io.*;

class Main {
  public static void main(String[] args) throws IOException{
      abc(0);
    }

    public static void abc(int x){
        if (x == 2) //종료조건, base condition
            return;
        abc(x+1); //왼쪽 가지
        abc(x+1); //오른쪽 가지
        return;
    }
}

/*
                   abc(0)
           abc(1)         abc(1)
      abc(2)  abc(2)   abc(2)  abc(2)

*/
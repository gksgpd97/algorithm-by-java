//dat (dirext address table)
/* 1~65535번의 ID를 가진 사람들이 있습니다.
다음과 같은 정시 출근 기록이 있을 때, 가장 성실하게 출근한 사람의 ID를 출력하는 프로그램을 작성 해주세요.
*/

class Main{
    static int[][] arr = {
    {65000, 35, 42, 70},
    {70, 35, 65000, 1300},
    {65000, 30000, 38, 42}
    };
    static int[] dat = new int[65536];
    public static void main(String arg[]){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 4; j++){
                dat[arr[i][j]]++;
            }
        }
        int max = 0;
        int idx = 0;
        for (int i = 0; i < dat.length; i++){   
            if (dat[i] >= max){
                idx = i;
                max = dat[i];
            }
        }
        System.out.print(idx);
    }
}
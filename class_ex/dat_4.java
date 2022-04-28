//dat (dirext address table)
/* cardlist 배열에 여러 종류의 카드가 있습니다.
1. 대문자 알파벳으로 구성된 카드 문장을 입력 합니다.문장의 길이는 최대 15입니다.
2. 입력한 카드에서 총 몇 종류의 카드가 있는지를 찾아 출력합니다.
*/

class Main{
    static String str = "ABCDACABCDE";
    static int[] dat = new int[128];
    public static void main(String arg[]){
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
            dat[arr[i]] = 1;
        }
        int answer = 0;
        for (int i = 0; i < dat.length; i++){   
            if (dat[i] >= 1){
                answer++;
            }
        }
        System.out.print(answer+"개");
    }
}
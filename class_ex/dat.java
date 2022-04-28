//dat (dirext address table)
// 1. 어떠한 값이 몇개 있는가?
// 2. 어떤 값이 존재하는가?
// 장점. 한번만 돌려서 개수/존재를 체크해두면 빠른 속도로 재사용할 수 있다.
// 단점. 메모리 낭비
// 주의사항
// 1. 범위가 매우 클 때 (ex. 100억) 메모리 초과로 불가할수있음
// 2. 음수 처리가 어려움

class Main{
    static int[] arr = {1,3,5,6,8,1,2,4,3,5};
    static int[] dat = new int[10+1];
    public static void main(String arg[]){
        //개수세기
        for (int i = 0; i < arr.length; i++){
            dat[arr[i]]++;
        }
    }
}
#배열의 크기가 최대 십만이고 시간 제한은 1초이기 때문에 중첩 for문은 쓰면 안된다
#dat(direct address table)을 쓰면 어떨까

cnt = [0 for i in range(1000001)]

n = int(input())
list = list(map(int, input().split(" ")))
x = int(input())

answer = 0

for i in list:
    cnt[i]+=1

for i in list:
    if (x-i == i): #(3,3) = 6 같은 상황 제외
        continue
    if (x-i > 999999): #1000000-1이 쌍의 차이의 최대값이라 그 이상 넘으면 제외
        continue
    if (cnt[x-i] == 1):
            answer+=1
            cnt[i] = 0

print(answer)
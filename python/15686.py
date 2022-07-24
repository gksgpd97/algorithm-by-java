from itertools import combinations

N, M= map(int, input().split())
city = [list(map(int, input().split())) for _ in range(N)]
house = []
store = []

for i in range(N):
    for j in range(N):
        if (city[i][j] == 1):
            house.append((i+1,j+1))
        elif (city[i][j] == 2):
            store.append((i+1,j+1))

store_comb = list(combinations(store, M))

answer = []
for comb in store_comb:
    temp = 0
    for x1, y1 in house:
        min_dis = []
        for x2, y2 in comb:
            min_dis.append(abs(x1-x2)+abs(y1-y2))
        temp += min(min_dis)
    answer.append(temp)
print(min(answer))

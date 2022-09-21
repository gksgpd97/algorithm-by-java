import sys

input = sys.stdin.readline
INF = 10**9

#입력받기
n, m ,r = map(int, input().split())
#각 지역의 아이템 수
items = list(map(int, input().split()))
#주어진 필드
field = [[INF for _ in range(n+1)] for _ in range(n+1)]
for _ in range(r):
    a, b, l = map(int, input().split())
    field[a][b] = l
    field[b][a] = l

#플로이드 워셜로 i에서 j까지 갈 수 있는 최단거리를 찾아놓는다
for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            if (i==j):
                continue
            field[i][j] = min(field[i][j], field[i][k]+field[k][j])

#최단거리를 찾았으니 그 거리가 수색범위 이하라면 출발지점으로부터 수색범위까지의 아이템개수를 모두 더해준다
answer = 0
for i in range(1, n+1):
    count = items[i-1]
    for j in range(1, n+1):
        if field[i][j] <= m:
            count += items[j-1]
    #최대 아이템 개수를 찾는다
    answer = max(answer, count)

print(answer)
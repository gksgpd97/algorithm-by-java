import sys

input = sys.stdin.readline
INF = 10**9

#입력받기
V, E = map(int, input().split())
city = [[INF for _ in range(V+1)] for _ in range(V+1)]
for _ in range(E):
    a,b,c = map(int, input().split())
    #일방통행
    city[a][b] = c

#플로이드 워셜로 최단거리 구하기
for k in range(1, V+1):
    for i in range(1, V+1):
        for j in range(1, V+1):
            #city배열 대각선에 있는 값이 중요하므로
            #i==j -> continue 하면 안됨
            city[i][j] = min(city[i][j], city[i][k]+city[k][j])

#최단거리 다 구했으면 대각선 중에 최소값 찾기
answer = INF
for i in range(1, V+1):
    answer = min(city[i][i], answer)

if (answer == INF):
    print(-1)
else:
    print(answer)
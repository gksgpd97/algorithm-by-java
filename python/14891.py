from collections import deque

#2번 인덱스가 맞물린 곳
#0은 N극 1은 S극
G = [0]
for _ in range(4):
    str = input()
    tmp = deque()
    for s in str:
        tmp.append(int(s))
    G.append(tmp)

#0번째 인덱스가 N인지 S인지에 따라 점수가 달라짐
answer = 0
#print(G)

def rotateG(n, dir, lflag, rflag):
    global G

    #톱니바퀴에서 초기값 얻기
    if (n==0 or n==5):
        return
    nowOfL = G[n][6]
    nowOfR = G[n][2]
    leftOfR = -1
    rightOfL = -1
    if (n>=2):
        leftOfR = G[n-1][2]
    if (n<=3):
        rightOfL = G[n+1][6]

    #현재 톱니바퀴 돌리기
    G[n].rotate(dir)

    #처음 선택된 톱니바퀴면
    if (lflag == 1 and rflag == 1):
        #돌릴게 없으면 끝내기
        if (leftOfR == nowOfL or leftOfR == -1) and (nowOfR == rightOfL or rightOfL == -1):
            return
    
        #왼쪽 톱니바퀴 돌리기
        if (leftOfR != nowOfL):
            rotateG(n-1, dir*(-1), 1, 0)
    
        #오른쪽 톱니바퀴 돌리기
        if (nowOfR != rightOfL):
            rotateG(n+1, dir*(-1), 0, 1)

    #왼쪽만 봐야하는 톱니바퀴면
    elif (lflag == 1):
        #돌릴게 없으면 끝내기
        if (leftOfR == nowOfL or leftOfR == -1):
            return
            
        #왼쪽 톱니바퀴 돌리기
        if (leftOfR != nowOfL):
            rotateG(n-1, dir*(-1), 1, 0)

    #오른쪽만 봐야하는 톱니바퀴면
    elif (rflag == 1):
        #돌릴게 없으면 끝내기
        if (nowOfR == rightOfL or rightOfL == -1):
            return
            
        #오른쪽 톱니바퀴 돌리기
        if (nowOfR != rightOfL):
            rotateG(n+1, dir*(-1), 0, 1)
    return
    
k = int(input())
#n번째 톱니바퀴
#dir -1은 반시계, 1은 시계 방향
for _ in range(k):
    n, dir = map(int, input().split())
    rotateG(n, dir, 1, 1)
    #print(G[1:])
    
score = [0,1,2,4,8]
for i in range(1, 5):
    answer += score[i] if G[i][0] == 1 else 0
    
print(answer)
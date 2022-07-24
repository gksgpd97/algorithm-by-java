from collections import deque

n, w, L = map(int, input().split())
a = deque(map(int, input().split()))

bridge_weight = deque()
bridge_time = deque()
now = 0

while(a or bridge_weight):

    #현재 시간 증가
    now += 1
    #다리에 머무른 시간 증가
    bridge_time = deque(map(lambda x:x+1, bridge_time))

    #다리에 다 건넌 트럭 있는지 조사
    if (len(bridge_time) != 0 and bridge_time[0] == w+1):
        bridge_weight.popleft()
        bridge_time.popleft()
        
    #트럭이 다리에 진입할 수 있는지 여부
    #1. 다리의 모든 트럭의 무게 + 진입할 트럭의 무게 <= L
    #2. 다리의 모든 트럭 개수 + 1 <= w
    if (a and sum(bridge_weight)+a[0] <= L):
        if (len(bridge_weight)+1 <= w):
            bridge_weight.append(a.popleft())
            bridge_time.append(1)

print(now)
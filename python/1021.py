from collections import deque

N, M = map(int, input().rstrip().split(" "))
temp = [i for i in range(1, N+1)]
deq = deque(temp)

lst = deque(map(int, input().rstrip().split(" ")))
answer = 0
while(len(lst) != 0):
    if (lst[0] == deq[0]):
        deq.popleft()
        lst.popleft()
    else:
        idx = deq.index(lst[0]) #idx=1
        if (idx <= int(len(deq)/2)):
            deq.rotate(-1)
            answer+=1
        else:
            deq.rotate(1)
            answer+=1

print(answer)
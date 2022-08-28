import sys
import heapq
input = sys.stdin.readline

maxhq = []
minhq = []

N = int(input())
for i in range(N):
    n = int(input())
    if (len(minhq) == len(maxhq)):
        heapq.heappush(maxhq, -n)
    else:
        heapq.heappush(minhq, n)

    if (minhq and maxhq) and (maxhq[0]*-1 > minhq[0]):
        heapq.heappush(maxhq, heapq.heappop(minhq)*-1)
        heapq.heappush(minhq, heapq.heappop(maxhq)*-1)

    print(maxhq[0]*-1)
def binarySearch(n, B):
    left = 0
    right = len(B)-1
    mid = (left + right) // 2

    while(left <= right):
        if (n == B[mid]):
            return 1
        elif (n > B[mid]):
            left = mid + 1
        elif (n < B[mid]):
            right = mid - 1
        mid = (left + right) // 2

    return 0
    

nA, nB = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
B.sort()

answer = []
for a in A:
    if (not binarySearch(a, B)):
        answer.append(a)

answer.sort()
print(len(answer))
if len(answer) != 0:
    print(*answer)
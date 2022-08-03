N = int(input())

arr = list(map(int, input().split()))

arr.sort()

answer = 0
for i in range(N):
    answer += arr[i]
    arr[i] = answer

print(sum(arr))
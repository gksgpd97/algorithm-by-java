N = int(input())

arr = []
for _ in range(N):
    arr.append(int(input()))

arr.sort()

answer = 0

for i in range(N):
    tmp = (N-i)*arr[i]
    answer = max(tmp, answer)

print(answer)
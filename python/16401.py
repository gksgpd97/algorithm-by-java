M, N = map(int, input().split())
snacks = list(map(int, input().split()))

left = 0
right = max(snacks)
mid = round((left + right) / 2)

answer = 0
while(left <= right):
    if (mid == 0):
        break
    count = 0
    for snack in snacks:
        count += snack // mid
    if (count >= M):
        if (answer < mid):
            answer = mid
        left = mid + 1
    elif (count < M):
        right = mid - 1
    mid = round((left + right) / 2)

if (mid == 0):
    print(0)
else:
    print(answer)
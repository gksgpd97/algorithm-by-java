N = int(input())
arr = list(map(int, input().split()))

dp = [0]*N
answer = 0
for i in range(N):
    for j in range(i):
        if (arr[j] < arr[i]):
            dp[i] = max(dp[i], dp[j])

        
    dp[i] += arr[i]
    answer = max(dp[i], answer)

print(answer)
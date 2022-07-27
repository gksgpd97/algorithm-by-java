
N = int(input())
arr = list(map(int, input().split()))
dp = [0]*N
dp[0]=1
for i in range(1, N):
    if (arr[i] == min(arr[:i+1])):
        dp[i] = 1
    else:
        longest = 0
        for j in range(0, i):
            if(arr[j] < arr[i]):
                if (dp[j] > longest):
                    longest = dp[j]
        dp[i] = longest+1

print(max(dp))
N = int(input())

arr = []
for _ in range(N):
    a,b,c,d = map(int, input().split())
    x = 100*a + b
    y = 100*c + d
    arr.append([x, y])

arr.sort()

compare = 301
idx = 0
smalldays = []
answer = 0
endflag = 0
while idx != N:
    #print("idx: ", idx)
    if (arr[idx][0] <= compare):
        #print("if")
        smalldays.append(arr[idx])
        #print("sd:", smalldays)
        idx+=1
    elif (not smalldays):
        idx+=1
        continue
    else:
        #print("else")
        answer += 1
        compare = max(smalldays, key=lambda x:x[1])[1]
        #compare = smalldays[-1][1]
        #print("set compare:", compare)
        smalldays = []
    if ((smalldays and smalldays[-1][1] > 1130) or compare > 1130):
            answer += 1
            endflag = 1
            break
        
if endflag == 1:
    print(answer)
else:
    print(0)
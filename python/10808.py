str=input()
alpha = [0 for _ in range(26)] #a는 아스키코드로 97
for i in str:
    alpha[ord(i)-97]+=1

for i in alpha:
    print(i, end=' ')
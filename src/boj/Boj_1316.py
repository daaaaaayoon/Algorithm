
def check(word):
    appear = ''
    for i in range(len(word)):
        # 새로 나온 값이 아니면
        if word[i] in appear:
            if word[i-1] != word[i]:
                return False
        else:
            appear += word[i]
    return True


n = int(input())
cnt = 0
for _ in range(n):
    word = input()
    if check(word):
        cnt+=1
print(cnt)
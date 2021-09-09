def solution(price, money, count):
    answer = 0
    need = 0
    for i in range(count):
        need += price*(i+1)
    if need > money:
        answer = need - money
    return answer

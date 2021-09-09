def solution(table, languages, preference):
    answer = ''

    tables = [['']*5 for _ in range(5)]
    for i in range(len(table)):
        tables[i] = table[i].split()

    ans_list = []
    max_score = -1

    # i = 직업
    for i in range(5):
        # j 1~5 = 직업별 언어선호도
        score = 0
        for j in range(6):
            for k in range(len(languages)):
                if languages[k] == tables[i][j]:
                    score += preference[k]*(6-j)
        if score > max_score:
            max_score = score
            ans_list = [tables[i][0]]
        elif score == max_score:
            ans_list.append(tables[i][0])

    ans_list.sort()
    return ans_list[0]


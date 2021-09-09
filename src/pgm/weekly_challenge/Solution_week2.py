def solution(scores):
    answer = ''

    len_s = len(scores[0])

    for i in range(len_s):
        unique = False
        min_score = 10000
        max_score = -1
        sum = 0
        for j in range(len_s):
            if i == j:
                continue
            else:
                sum += scores[j][i]
                min_score = min(min_score, scores[j][i])
                max_score = max(max_score, scores[j][i])
        if min_score > scores[i][i] or max_score < scores[i][i]:
            unique = True
        if not unique:
            sum += scores[i][i]
            sum //= len_s
        else:
            sum //= len_s-1

        # 점수화
        if sum >= 90:
            answer += 'A'
        elif 80 <= sum < 90:
            answer += 'B'
        elif 70 <= sum < 80:
            answer += 'C'
        elif 50 <= sum < 70:
            answer += 'D'
        else:
            answer += 'F'

    return answer

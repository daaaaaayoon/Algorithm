
def check_vowel(string):
    for i in string:
        if i in 'aeiou':
            return True
    return False


def check_3vowel_3con(string):
    if len(string)<3:
        return True
    elif len(string)==3:
        check = ''
        for i in range(3):
            if string[i] in 'aeiou':
                check += 'v'
            else:
                check += 'c'
        if check == 'vvv' or check == 'ccc':
            return False
        else:
            return True
    for i in range(len(string)-2):
        check = ''
        for j in range(3):
            if string[i+j] in 'aeiou':
                check += 'v'
            else:
                check += 'c'
        if check == 'vvv' or check == 'ccc':
            return False
    return True


def check_same_char(string):
    for i in range(len(string)-1):
        if string[i] == string[i+1]:
            if string[i] == 'e' or string[i] == 'o':
                return True
            else:
                return False
    return True


while True:
    line = input()
    if line == 'end': break
    if check_vowel(line) and check_3vowel_3con(line) and check_same_char(line):
        print(f"<{line}> is acceptable.")
    else:
        print(f"<{line}> is not acceptable.")
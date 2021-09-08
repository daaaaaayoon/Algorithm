import re

book = input()
keyword = input()

book = re.sub('[0-9]', '', book)

# find 이용
ans = book.find(keyword)
print("1" if ans != -1 else "0")

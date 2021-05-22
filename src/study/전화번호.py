def solution(phone_book):
    for i in range(len(phone_book) - 1):
        if phone_book[i + 1].startswith(phone_book[i]):
            return False
    else:
        return True


answer = []
for i in range(int(input().rstrip())):
    lst = [input() for _ in range(int(input()))]
    lst.sort()
    if (solution(lst)):
        answer.append("YES")
    else:
        answer.append("NO")

for i in answer:
    print(i)
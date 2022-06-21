import sys

input = sys.stdin.readline

testcase = int(input())

for _ in range(testcase):
    keyloger = input().rstrip()
    answer = []
    IteratorNum = 0

    for key in keyloger:
        if key == '<':
            IteratorNum -= 1
            if IteratorNum < 0:
                IteratorNum = 0
        elif key == '>':
            IteratorNum += 1
            if IteratorNum  > len(answer):
                IteratorNum = len(answer)
        elif key == '-':
            if IteratorNum > 0:
                del answer[IteratorNum - 1]
                IteratorNum -= 1
        else:
            answer.insert(IteratorNum, key)
            IteratorNum += 1

    answerStr = ""
    for i in answer:
        answerStr += i
    
    print(answerStr)
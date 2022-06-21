import sys
input = sys.stdin.readline

seller = {}

N = int(input())

for _ in range(N):
    book = input().rstrip()
    if book not in seller:
        seller[book] = 1
    else:
        seller[book] += 1

max_sell = max(seller.values())
# max_sell = seller[max(seller)]

name = sorted(seller)

for n in name:
    if seller[n] == max_sell:
        print(n)
        break

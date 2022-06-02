# https://www.acmicpc.net/problem/1991
import sys
input = sys.stdin.readline

n = int(input())

tree = {}

for _ in range(n):
    key, left, right = input().split() # 차례대로 노드, 노드의 왼쪽 자식, 노드의 오른쪽 자식
    child = [left, right] # 노드의 자식들을 child에 담아서 관리
    tree[key] = child # tree = {key : [left, right], ... } 형태로 관리 (딕셔너리)

def preorder(tree, key): # 전위 순회
    if tree[key] != None:
        print(key, end ='')
    if tree[key][0] != ".":
        preorder(tree, tree[key][0])
    if tree[key][1] != ".":
        preorder(tree, tree[key][1])

def inorder(tree, key): # 중위 순회
    if tree[key][0] != ".":
        inorder(tree, tree[key][0])
    if tree[key] != None:
        print(key, end ='')
    if tree[key][1] != ".":
        inorder(tree, tree[key][1])

def postorder(tree, key): # 후위 순회
    if tree[key][0] != ".":
        postorder(tree, tree[key][0])
    if tree[key][1] != ".":
        postorder(tree, tree[key][1])
    if tree[key] != None:
        print(key, end ='')


preorder(tree, 'A')
print(end = '\n')
inorder(tree, 'A')
print(end = '\n')
postorder(tree, 'A')
print(end = '\n')

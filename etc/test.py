N = int(input())
numbers = set(map(int, input().split()))
M = int(input())
numbers2 = list(map(int, input().split()))

anw = [0] * M

for i in range(M):
    if numbers2[i] in numbers:
        anw[i] = 1

print(*anw)
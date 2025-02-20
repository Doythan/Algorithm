max, index = 0, 0

for i in range(9):
    num = int(input())
    if num > max:
        max, index = num, i

print(max)
print(index + 1)


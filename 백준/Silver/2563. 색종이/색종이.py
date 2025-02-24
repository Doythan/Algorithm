P = int(input())  # 색종이 수 입력
matrix = [[0] * 100 for _ in range(100)]
for i in range(P):
    x, y = map(int, input().split())  # 정사각형의 x, y좌표 시작점 입력

    for idx in range(x-1, x+9):
        for jdx in range(y-1, y+9):
            if matrix[idx][jdx] != 1:
                matrix[idx][jdx] = 1

ans = 0  # 중복 제외 색종이들 넓이 
for idx in range(100):
    for jdx in range(100):
        if matrix[idx][jdx] == 1:
            ans += 1
print(ans)
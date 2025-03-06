def solution(n, w, num):
    # 1. num의 위치 파악
    row = (num - 1) // w
    if row % 2 == 0:  # 짝수 행
        col = (num - 1) % w
    else:  # 홀수 행
        col = w - 1 - (num - 1) % w

    # 2. 제거해야 할 상자 수 계산
    count = 0
    total_rows = (n + w - 1) // w  # 총 행의 수
    for r in range(row, total_rows):
        box_index = r * w + col + 1 if r % 2 == 0 else (r + 1) * w - col
        if box_index <= n:
            count += 1

    return count

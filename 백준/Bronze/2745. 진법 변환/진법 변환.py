N, B = input().split()  # N: B진법 수 (문자열), B: 진법
B = int(B)  # 진법을 정수로 변환

print(int(N, B))  # B진법 → 10진법 변환 후 출력

# 한 줄 입력받기
name = input("이름을 입력하세요: ")
print("Hello,", name)

# 여러 개의 숫자를 입력받아 리스트로 저장
nums = list(map(int, input("숫자 입력: ").split()))
print(nums)

# 두 정수를 입력받아 합을 출력하는 프로그램
a, b = map(int, input("숫자 2개 입력하시오: ").split())
print(a + b)

# 1부터 N까지 합 구하기 
n = int(input())
print(sum(range(1, n + 1)))

# 최대값 찾기
arr = list(map(int, input().split()))
print(max(arr))
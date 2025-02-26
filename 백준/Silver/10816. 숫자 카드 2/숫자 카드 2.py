# target이 처음 등장하는 위치
def lower_bound(arr, target):
    left, right = 0, len(arr) 

    while left < right:
        mid = (left + right) // 2
        if arr[mid] >= target:
            right = mid
        else:
            left = mid + 1
    return left 

# target 보다 큰 값이 처음 등장하는 위치 
def upper_bound(arr, target):
    left, right = 0, len(arr)

    while left < right:
        mid = (left + right) // 2
        if arr[mid] > target:
            right = mid
        else:
            left = mid + 1
    return left

N = int(input())
nums = list(map(int, input().split()))
M = int(input())
check_nums = list(map(int, input().split()))

# 답
ans_nums = [0] * M

# 정렬
nums.sort()

for idx in range(M):
    first_idx = lower_bound(nums, check_nums[idx])
    last_idx = upper_bound(nums, check_nums[idx])
    ans_nums[idx] = last_idx - first_idx

print (*ans_nums)
def time_to_sec(time_str):
    """mm:ss → 초 변환"""
    m, s = map(int, time_str.split(":"))
    return m * 60 + s

def sec_to_time(sec):
    """초 → mm:ss 변환"""
    m = sec // 60
    s = sec % 60
    return f"{m:02d}:{s:02d}"

def solution(video_len, pos, op_start, op_end, commands):
    video_len_sec = time_to_sec(video_len)
    pos_sec = time_to_sec(pos)
    op_start_sec = time_to_sec(op_start)
    op_end_sec = time_to_sec(op_end)
    
    # 시작 시 오프닝 skip 검사
    if op_start_sec <= pos_sec <= op_end_sec:
        pos_sec = op_end_sec
    
    for cmd in commands:
        if cmd == "prev":
            pos_sec -= 10
            if pos_sec < 0:
                pos_sec = 0
        elif cmd == "next":
            pos_sec += 10
            if pos_sec > video_len_sec:
                pos_sec = video_len_sec
        
        # 명령 수행 후에도 오프닝 skip 검사
        if op_start_sec <= pos_sec <= op_end_sec:
            pos_sec = op_end_sec
    
    return sec_to_time(pos_sec)

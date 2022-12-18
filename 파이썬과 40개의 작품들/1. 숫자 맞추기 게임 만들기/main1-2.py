import random

random_number = random.randint(1, 100)

game_count = 1

while True:
    my_number = int(input("1~100 사이의 숫자를 입력하세요:"))
    
    if my_number > random_number: # 내가 입력한 숫자가 랜덤한 숫자보다 클 경우 다운 출력
        print("다운")
    elif my_number < random_number: # 내가 입력한 숫자가 랜덤한 숫자보다 작을 경우 업 출력
        print("업")
    elif my_number == random_number: # 내가 입력한 숫자와 랜덤한 숫자가 같을 경우 맞췄다는 안내메세지 출력 후 while문에서 빠져나감
        print(f"축하합니다. {game_count}회 만에 맞췄습니다.")
        break 
    
    game_count = game_count + 1 # 횟수 카운트
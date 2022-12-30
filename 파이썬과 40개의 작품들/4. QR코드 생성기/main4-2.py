import qrcode
import os

def currentDir():
    os.chdir(os.path.dirname(os.path.abspath(__file__)))

file_path = 'qr코드모음.txt'

currentDir()
with open(file_path, 'rt', encoding='UTF8') as f:
    read_lines = f.readlines()
    
    for line in read_lines:
        line = line.strip()
        print(line)
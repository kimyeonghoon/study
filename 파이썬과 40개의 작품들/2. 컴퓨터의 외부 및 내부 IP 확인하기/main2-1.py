import socket

in_addr = socket.gethostbyname(socket.gethostname())

print(in_addr) # 127.0.0.1
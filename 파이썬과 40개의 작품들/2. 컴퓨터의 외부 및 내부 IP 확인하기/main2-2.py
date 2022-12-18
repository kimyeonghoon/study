import socket

in_addr = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
in_addr.connect(("yeonghoon.kim", 443))

print(in_addr.getsockname()[0]) #192.167.200.162
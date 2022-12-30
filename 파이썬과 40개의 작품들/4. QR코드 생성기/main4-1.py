import qrcode
import os

qr_data = 'yeonghoon.kim'
qr_img = qrcode.make(qr_data)

os.chdir(os.path.dirname(os.path.abspath(__file__)))

save_path = qr_data + '.png'
qr_img.save(save_path)
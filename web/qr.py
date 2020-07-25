import qrcode
img = qrcode.make("file:///home/kamal/Desktop/web/index.html")
img.save("qr2.png", "PNG")
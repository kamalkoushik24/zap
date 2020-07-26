import qrcode
img = qrcode.make("file:///home/kamal/zap/Web Track/index.html")
img.save("qr2.png", "PNG")
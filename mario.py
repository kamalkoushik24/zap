

while True:
    h = int(input("height: "))
    if (h == ""):
        print("Please enter a number from 1 to 8")
        continue
    if (h > 0 and h <= 8):
      break
for i in range(h):
    for j in range(h - i - 1):
        print(" ", end = "")
    for c in range(1 , i + 2):
        print("#", end = "")
    print("  ", end = "")

    for c in range(1, i + 2):
        print("#", end = "")
    print("")

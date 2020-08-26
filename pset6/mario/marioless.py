from cs50 import get_int

while True:
    try:
        h = get_int("height: ")  # asking the user for input
    except ValueError:
        print("Sorry, Please input a number form 1 to 8")

    if (h > 0 and h <= 8):
        break
for i in range(h):
    for j in range(h - i - 1):
        print(" ", end="")  # spaces for the right aligned pyramid
    for c in range(1, i + 2):
        print("#", end="")  # printing the first set of hashes
    print("")  # printing a new line


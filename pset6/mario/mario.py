from cs50 import get_int

while True:
    h = get_int("height: ")  # asking the user for input
    if (h > 0 and h <= 8):
        break
for i in range(h):
    for j in range(h - i - 1):
        print(" ", end="")  # spaces for the right aligned pyramid
    for c in range(1, i + 2):
        print("#", end="")  # printing the first set of hashes
    print("  ", end="")  # printing the two spaces after each set of hashes

    for c in range(1, i + 2):
        print("#", end="")  # printing the second set of hashes
    print("")  # p rinting a new line


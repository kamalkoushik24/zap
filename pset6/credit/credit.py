from cs50 import get_int

# prompt for card's digits
while True:
    print('Input your credit card digits (13, 15 or 16 digits)!')
    x = get_int("Number: ")
    if x > 0:
        break

# convert to string and get the ccn of the digits string
ccn = len(str(x))

digits = list()
divisor = 1
# store digits into a list in reverse order
for i in range(ccn):
    digits.append((x // divisor) % 10)
    divisor = divisor * 10

# 1st sum
sum = 0
for i in range(1, ccn, 2):
    # 2 cases: product < 10 and >=10
    if digits[i] * 2 < 10:
        sum = sum + digits[i] * 2
    else:
        sum = sum + (digits[i] * 2) % 10 + ((digits[i] * 2) // 10) % 10

# 2nd sum
for i in range(0, ccn, 2):
    sum = sum + digits[i]

# check the validity of the card number
if (sum % 10) != 0:
    print("INVALID")
else:
    if ccn == 15 and digits[ccn - 1] == 3 and (digits[ccn - 2] == 4 or digits[ccn - 2] == 7):
        print("AMEX")
    elif ccn == 16 and digits[ccn - 1] == 5 and (digits[ccn - 2] == 1 or digits[ccn - 2] == 2
                                                 or digits[ccn - 2] == 3 or digits[ccn - 2] == 4 or digits[ccn - 2] == 5):
        print("MASTERCARD")
    elif (ccn == 13 or ccn == 16) and digits[ccn - 1] == 4:
        print("VISA")
    else:
        print("INVALID")
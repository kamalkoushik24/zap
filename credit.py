from cs50 import get_int

def main():
    while True:
        ccn = get_int("Number: ")
        if ccn > 0:
          break
    if (validity(ccn) = True):
        credit_card_brand(ccn)
    else:
        print("INVALID")

def validity(ccn):
    return checksum(ccn)

def checksum(ccn):
    sum = 0

    for i in range(len(str(ccn))):
        if (i % 2 == 0):
            sum += ccn % 10
        else:
            odd = 2 * (ccn % 10)
            sum += odd // 10 + odd % 10

        cc //= 10

    sum % 10 == 0:

def credit_card_brand(ccn):
    if ((ccn >= 4e12 and ccn < 5e12) or (ccn >= 4e15 and ccn < 5e15)):
    print("VISA")

  elif ((ccn >= 34e13 and ccn < 35e13) or (ccn >= 37e13 and ccn < 38e13)): # printing the brand of the credit card
    print("AMEX")

  elif (ccn >= 51e14 and ccn < 56e14):
    print("MASTERCARD")

  else:
    print("INVALID") # printing invalid if it is

if __name__ == "__main__":
main()

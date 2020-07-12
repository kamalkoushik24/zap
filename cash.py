from cs50 import get_float

while True:
    usd = get_float("Enter change in USD: ")
    if (usd > 0):
        break
cents = round(usd * 100)
coins = 0
quart = 0
dimes = 0
nicke = 0
penny = 0
while (cents >= 25):
    cents -= 25
    coins += 1
    quart += 1
while (cents >= 10):
    cents -= 10
    coins += 1
    dimes += 1
while (cents >= 5):
    cents -= 5
    coins += 1
    nicke += 1
while (cents >= 1):
    cents -= 1
    coins += 1
    penny += 1


print(f"You will need atleast {coins} coins")
print(f"You will need {quart} quarters")
print(f"You will need {dimes} dimes")
print(f"You will need {nicke} nickels")
print(f"You will need {coins} pennies")

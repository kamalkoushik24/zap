from math import floor

while True:
 try:
    usd = float(input("Enter the change you owe: "))
    if (usd > 0):
        break
    else:
        continue
 except ValueError:
    continue

cents = usd * 100

q = floor(cents/25)
d = floor((cents%25)/10)
n = floor(((cents%25)%10)/5)
p = floor((((cents%25)%10)%5))

coins =  q + d + n + p
print(f"you will need atleast {coins} coins")
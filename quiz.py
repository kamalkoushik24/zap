import math

from cs50 import get_string  #importing the required modules

points = 0

def correct():
    print("Correct Answer!!\n")

def wrong():
    print("Wrong Answer, good luck with the next question")

name = get_string("Hello there! What is your name?\n")
print(f"Hi, {name}. Hope you do well in the quiz")
print("\n")

ans1 = get_string("Who is the prime minister of India?\nAnswer: ")
if (ans1 == 'Narendra Modi'):
    correct()
    points += 1
else:
    wrong()

ans2 = get_string("What is the Capital of India?\nAnswer: ")
if (ans2 == 'New Delhi'):
    correct()
    points += 1
else:
    wrong()

print(f"You got {points} answers right!!")

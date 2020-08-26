from cs50 import get_string  # importing the cs50 library
letter = 0
sentence = 0  # initializing all the variables
word = 1
text = get_string("Text: ")  # getting the text from the user
n = len(text)  # getting the length of the text
for i in range(n):
    if ((text[i] >= 'A' and text[i] <= 'Z') or (text[i] >= 'a' and text[i] <= 'z')):  # counting the number of letters
        letter += 1
for i in range(n):
    if text[i] == ' ':  # counting the number of words
        word += 1
for i in range(n):
    if text[i] == "?" or text[i] == "." or text[i] == "!":   # counting the number of sentences
        sentence += 1

l = (letter / word) * 100   # getting the value of L
s = (sentence / word) * 100  # getting the value of S

grade = round(0.0588 * l - 0.296 * s - 15.8)  # calculating the grade

if grade < 0:
    print("Before Grade 1\n")
elif grade >= 16:
    print("Grade 16+\n")    # printing the text according to the grade
else:
    print(f"Grade {grade}\n")

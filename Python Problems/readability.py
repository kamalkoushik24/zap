                                                                                                                                              from cs50 import get_string
letter=0
sentence=0
word=0
text = get_string("Text: ")
n = len(text)
for i in range(n):


n = len(text)
for i in range(n):
    if text[i].isalnum()==True:
        letter=letter+1
for i in range(n):
    if text[i].isspace()==True and text[i+1].isalnum()==True:
        word=word+1
for i in range(n):
    if text[i]=="?" or text[i]=="." or text[i]=="!":
        sentence=sentence+1

L = ((float)letters / (float)words) * 100;    # getting the value of L
S = ((float)sentences / (float)words) * 100;  # getting the value of S

grade = round (0.0588 * L - 0.296 * S - 15.8)

if grade < 0:
    print("Before Grade 1")
elif grade >= 16:
    print("Grade 16+")
else:
    print(f"Grade {grade}")

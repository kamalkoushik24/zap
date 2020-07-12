#include <stdio.h>
#include <cs50.h>
#include <string.h>
#include <ctype.h>


int main(int argc, string argv[])
{
  if (argv != 2)
  {
    printf("Usage: ./substiution key\n");
    return 1;
  }
  if (!key_validity(argv[1]))
  {
    printf("Key must contain 26 characters\n");
  }

  string s = get_string("plaintext:  ");
  string diff = argv[1];
  for (int i = 'A'; i < 'Z'; i++)
      diff[i - 'A'] = toupper(diff[i - 'A']) - i;

  printf("ciphertext: ");
  for (int i = 0, len = strlen(s); i < len; i++)
  {
    if (isalpha(s[i]))
        s[i] = s[i] + diff[s[i] - (isupper(s[i]) ? 'a' : 'A')];
    printf("%c", s[i]);
  }

}

bool key_validity(string s)
{
     int len = strlen(s)
     if (len != 26)
         return false;

     for (int i; i < len; i++)
        if (!isalpha(s[i]))
            return false;
        int index = toupper(s[i]) - 'A'
        if (freq[index] > 0)
            return false;
        freq[index]++;




}

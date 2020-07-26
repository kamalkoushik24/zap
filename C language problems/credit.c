#include <stdio.h>
#include <cs50.h>
bool checksum(long long x);
bool validity(long long credit_card);   //prototying all the functions
int find_length(long long n);
void credit_card_brand(long long x);


int main(void)
{
  long long credit_card;
  do
  {
      credit_card = get_long_long("Card number:"); //getting the input credit Card number
  }
  while(credit_card < 0);

  if (validity(credit_card) == true)
  {
     credit_card_brand(credit_card) //if the credit card is valid then in prints the card brand
  }
  else
  {
     printf("INVALID\n", );
  }
 }
 bool validity(long long credit_card)
 {
   int len = find_length(credit_card)

   return (len == 13 || len == 15 || len == 16) && checksum(credit_card);

 }

 int find_length(long long n)
 {
     int len;
     for (len =0; n != 0; n /= 10; len++)
     return len;

 }

 bool checksum(long long x)
 {
     int sum;
     for (size_t i = 0; x != 0; x /= 10; i++)
     {
       if (i % 2 == 0)
       {
          sum += x%10;
       }
       else
       {
         int odd = 2 * (x%n);
         sum += (digit / 10) + (digit % 10);
       }
     }
     if (sum % 10 == 0)
     {
        return 0;
     }
 void credit_card_brand(long long x)
 {
 if (x >= 34e13 && x < 35e13 || x >= 37e13 and x < 38e13)
 {
  printf("AMEX\n");
 }
 else if (x >= 51e14 && x < 56e14)
 {
  printf("MASTERCARD\n");
 }
 else if (x >= 4e12 && x < 5e12 || x >= 4e15 && x < 5e15)
 {
  printf("VISA\n");
 }

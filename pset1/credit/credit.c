#include <stdio.h>
#include <cs50.h>
bool checksum(long long x);
bool validity(long long credit_card);   //prototying all the functions
int find_length(long long n);
void credit_card_brand(long long x);


int main(void) //main part of the function
{
    long long credit_card;
    do
    {
        credit_card = get_long_long("Card number:\n"); //getting the input credit Card number
    }
    while (credit_card < 0);

    if (validity(credit_card) == true)
    {
        credit_card_brand(credit_card); //if the credit card is valid then in prints the card brand
    }
    else
    {
        printf("INVALID\n");
    }
}

bool validity(long long credit_card)  //checking the validity of the card function
{
    int len = find_length(credit_card);    //determining the length of the credit card

    return (len == 13 || len == 15 || len == 16) && checksum(credit_card);
}



int find_length(long long n) //length finding function
{
    int len;
    for (len = 0; n != 0; n /= 10) //the length finding function
    {
        len++;
    }
    return len;
}
bool checksum(long long x)  //checksum algortihm
{
    int sum = 0;
    for (int i = 0; x != 0; x /= 10, i++)
    {
        if (i % 2 == 0)
        {
            sum += x % 10;
        }  // algorithm for credit card check sum
        else
        {
            int odd = 2 * (x % 10);
            sum += (odd / 10) + (odd % 10);
        }
    }
    if (sum % 10 == 0)
    {
        return true;
    }
    else             //checking if the card follows the checksum
    {
        return false;
    }

}
void credit_card_brand(long long x) //credit card brand printing function
{
    if ((x >= 34e13 && x < 35e13) || (x >= 37e13 && x < 38e13))
    {
        printf("AMEX\n");
    }
    else if (x >= 51e14 && x < 56e14)        // printing the brand of the respective credit card numbers
    {
        printf("MASTERCARD\n");
    }
    else if ((x >= 4e12 && x < 5e12) || (x >= 4e15 && x < 5e15))
    {
        printf("VISA\n");
    }
    else
    {
        printf("INVALID\n");
    }
}


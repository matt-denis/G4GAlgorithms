#include <stdio.h>

int binary_to_decimal(int);

int main()
{
    printf("%d", binary_to_decimal(10001000));
    printf("%d", binary_to_decimal(101100));
}

int binary_to_decimal(int B)
{
    int dec = 0;
    int f = 1;
	do {
	    dec += B % 10 * f;
	    B /= 10;
	    f *= 2;
	    
	} while (B != 0);
	
	return dec;
}
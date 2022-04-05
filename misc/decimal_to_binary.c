#include <stdio.h>

void toBinary(int);

int main()
{
    toBinary(35);
}

void toBinary(int N)
{
    long long ans = 0;
    long long bits = 1;
    while (N != 0) {
        int rem = N % 2;
        N /= 2;
        ans = bits * rem + ans;
        bits *= 10;
    }
    printf("%Ld", ans);
        
}
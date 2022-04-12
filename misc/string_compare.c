/*
An algorithm to compare two strings lexicographically.
Every two pair of string is assigned a unique integer value.
*/

#include <stdio.h>
#include <stdlib.h>

int string_compare(char*, char*);

int main()
{
    char s1[] = "gfg";
    char s2[] = "courses";
    printf("%d\n", string_compare(s1, s2));
}

int string_compare(char s1[], char s2[])
{
    int i;
    int diff = 0;
    for (i = 0; s1[i] != '\0' && s2[i] != '\0'; i++) {
        diff = diff * 10 + s1[i] - s2[i];
    }
    if (s1[i] != '\0') {
        for ( ; s1[i] != '\0'; i++) {
            diff = diff * 10 + s1[i];
        }
    }
    else if (s2[i] != '\0') {
        for ( ; s2[i] != '\0'; i++) {
            diff = diff * 10 - s2[i];
        }
    }

    return diff;

}
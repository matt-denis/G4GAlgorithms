#include <iostream>

int& largest(int[], int);

int main() 
{
    int arr[]{3, 6, 4, 9, 7, 0};
    int i = largest(arr, 6);
    std::cout << i << std::endl;
}

int& largest(int* const array, int n)
{
    int* largest = array;
    for (unsigned int i{1}; i < n; i++) {
        if (*(array + i) > *largest) largest = array + i;
    }
    return *largest;
} 

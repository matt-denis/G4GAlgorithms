#include <cstdlib>

struct Node
{
    int data;
    Node *left, *right;
    Node() : left(NULL), right(NULL) {}
    Node (int data) : data(data), left(NULL), right(NULL) {}
};
#include "three_numbers.h"
#include <iostream>


int main() {
    int user_input;

    std::cout << "Enter an integer: ";
    std::cin >> user_input;

    user_input % 2 == 0 ? std::cout << "YES" : std::cout << "NO";

    return 0;
}
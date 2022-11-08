#include "three_numbers.h"
#include <iostream>
#include <algorithm>

void print_numbers(int number_1, int number_2, int iterations);

int main() {
    int first, second, third;

    std::cout << "Enter first number: ";
    std::cin >> first;

    std::cout << "Enter second number: ";
    std::cin >> second;

    std::cout << "Enter third number: ";
    std::cin >> third;

    int biggest = std::max({first, second, third});
    std::cout << "Biggest number is: " << biggest << std::endl;

    if (first < biggest && second < biggest) {
        print_numbers(first, second, biggest);
    }
    if (first < biggest && third < biggest) {
        print_numbers(first, third, biggest);
    }
    if (second < biggest && third < biggest) {
        print_numbers(second, third, biggest);
    }

    return 0;
}

void print_numbers(int number_1, int number_2, int iterations) {
    for (int i = 0; i < iterations; i++) {
        std::cout << number_1 + number_2 << std::endl;
    }
}

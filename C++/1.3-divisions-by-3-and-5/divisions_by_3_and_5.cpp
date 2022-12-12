# include <iostream>

int main() {
    int user_input;

    std::cout << "Enter an integer: ";
    std::cin >> user_input;

    if (user_input % 3 == 0 && user_input % 5 == 0) {
        std::cout << "Entered number is divisible by 3 and 5";
    } else if (user_input % 3 == 0 && user_input % 5 != 0) {
        std::cout << "Entered number is divisible by 3 but not by 5";
    } else if (user_input % 3 != 0 && user_input % 5 == 0) {
        std::cout << "Entered number is divisible by 5 but not by 3";
    } else {
        std::cout << "Entered number is not divisible by 3 and 5";
    }

    return 0;
}

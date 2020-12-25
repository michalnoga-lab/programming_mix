# Zaproponuj implementację stosu w oparciu o tablicę jednowymiarową liczb
# całkowitych. Użytkownik podaje maksymalny rozmiar stosu. Zastosuj
# ograniczenie, w ramach którego użytkownik może na stosie umieszczać tylko
# liczby pierwsze.


def print_menu():
    user_input = 0
    while user_input not in ['1', '2', '3', '0']:
        print(f'1 - Dodaj element')
        print(f'2 - Pobierz element')
        print(f'3 - Wyczyść cały stos')
        print(f'0 - Koniec programu')
        user_input = (input(f'>> '))
    return user_input


def print_stack(array):
    print(f'Aktualnie na stosie: {array}')


def get_value_from_user():
    return input(f'Podaj wartość do dodania >> ')


if __name__ == '__main__':
    stack = []

    while True:
        user_choice = print_menu()
        if user_choice == '1':
            stack.append(get_value_from_user())
            print_stack(stack)
        elif user_choice == '2':
            if len(stack) > 0:
                popped_element = stack.pop()
                print(f'Pobrano ze stosu: {popped_element}')
            print_stack(stack)
        elif user_choice == '3':
            stack.clear()
            print_stack(stack)
        elif user_choice == '0':
            break

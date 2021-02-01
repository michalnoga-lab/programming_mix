import re

file = open('example_data_zad_01.csv')
all_lines = file.read().split('\n')

print(f'Cały wczytany plik: {all_lines}')


def get_only_upper_case_lines(array):
    output = []
    pattern = re.compile('^[A-Z\\s]+$')
    for element in array:
        current_line = element.split(',')[2]
        if pattern.match(current_line) and len(current_line.split('\\s')) < 2:
            output.append(current_line)
    return output


def count_vowels(text):
    return len(text) - len(re.sub('[AEOUIY]', '', text))


def sort_by_vowels_number(array):
    return sorted(array, key=lambda item: count_vowels(item), reverse=True)


def remove_elements_longer_than(how_many_letters, array):

    words = ['AA', 'FFF', 'WWWW', 'EE']
    words2 = list(filter(lambda x: len(x) > 2, words))

    return words2

upper_text_only_lines = get_only_upper_case_lines(all_lines)
print(f'Tylko napisy dużymi literami: {upper_text_only_lines}')
upper_text_only_lines_by_vowels = sort_by_vowels_number(upper_text_only_lines)
print(upper_text_only_lines_by_vowels)
upper_text_only_lines_by_vowels_trimmed = remove_elements_longer_than(20, upper_text_only_lines_by_vowels)
print(upper_text_only_lines_by_vowels_trimmed)

# Na potrzeby zadania przygotuj plik tekstowy, który w każdym wierszu
# zawiera napis składający się z dowolnych znaków (może to być również
# całe zdanie). Pobierz kolejne wiersze napisu do kolekcji napisów. Na
# podstawie kolekcji napisów wygeneruj mapę, której kluczem będzie napis
# składający się z samych samogłosek występujących w napisie z kolekcji,
# natomiast wartością napis składający się z samych spółgłosek
# występujących w napisie z kolekcji. Podaj informację ile par w mapie
# posiada taką samą długość klucza i wartości. Wyznacz parę, dla której
# różnica pomiędzy długością klucza oraz wartości jest największa oraz
# najmniejsza.

import re

file_content = open('./sentences.txt', 'r').read().split('\n')


def get_vowels(sentence):
    return re.sub('[^aeouiy]+', '', str(sentence).lower())


def get_consonants(sentence):
    only_letters = re.sub('[^a-z]+', '', str(sentence).lower())
    return re.sub('[aeouiy]+', '', str(only_letters).lower())


def create_map(sentences):
    output = {}
    for sentence in sentences:
        output[get_vowels(sentence)] = get_consonants(sentence)
    return output


def find_keys_length_equals_values_length(input_map):
    counter = 0
    for entry in input_map.items():
        if len(entry[0]) == len(entry[1]):
            counter += 1
    return counter


def find_difference_in_keys_values_lengths(input_map, reverse):
    output_entry = sorted(input_map.items(), key=lambda entry: len(entry[0]) - len(entry[1]), reverse=reverse)[0]
    return abs(len(output_entry[0]) - len(output_entry[1]))


vowels_consonants_map = create_map(file_content)

print(f'Pobrano napisy z pliku: {file_content}')
print(f'Utworzono mapę: {vowels_consonants_map}')
print(f'{find_keys_length_equals_values_length(vowels_consonants_map)} par ma klucz i wartości o takiej samej długości')
print(f'Największa różnica w długości klucz wartość wynosi: '
      f'{find_difference_in_keys_values_lengths(vowels_consonants_map, False)}')
print(f'Najmniejsza różnica w długości klucz wartość wynosi: '
      f'{find_difference_in_keys_values_lengths(vowels_consonants_map, True)}')

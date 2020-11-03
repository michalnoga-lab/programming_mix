import re


def is_isogram(string):
    string_pured = re.sub('[\\s-]+', '', string).lower()
    return all([string_pured.rfind(ch) == string_pured.find(ch) for ch in string_pured])

import string
import re


def is_pangram(sentence):
    output = re.sub('[^a-zA-Z]', '', sentence)

    for i in string.ascii_lowercase:

        if i not in output.lower():
            return False

    return True

# Sentence generator


Write a program that allows to generate a string based on the algorithm described below. First, the number n is drawn, which is a natural number from the range <10, 40>. 
The number will mean the quantity characters in the generated text. The next character is drawn from the range <A, Z> characters. 
The drawn character may be appended to the end of the string only if it has occurred less than m times so far (m to a natural number randomly drawn from the interval <2, 5>). 
Otherwise repeat the drawing of the character. For the designated inscription execute the following commands:

Find the sign for which the sum of the distances of occurrences is the greatest. By the sum of the distance of occurrences, we understand the number of items in the text
between the first occurrence and the second occurrence, and the possible number of intermediate positions with occurrence. 
If there is only one occurrence of the sign, we assume the result 0.

For the given character, if it appears in the sentence, designate lowest total number of steps requested to move all his 
apperances to the beginning of the string as the first character of this string.

Based on the sentence you have, generate a new sentence which we will call a symmetrical inscription. Symmetrical inscription on the i-th position
has a character that holds the difference in the numeric code from the character A, as the difference in the numeric code of the character at the i-th position
in the input string from the character Z.




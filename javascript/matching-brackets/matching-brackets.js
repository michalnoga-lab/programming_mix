/*export const matchingBrackets = (input) => {
    let array = input.split('');

    for (let i = 0; i < array.length; i++) {
        let searchingForOppositeOf = array[i];

        for (let j = i; j < array.length; j++) {

            if ((i > 0 && array[array.length - 2] !== '{' && array[j] === '{' && array[array.length - 1] === '}') ||
                (i > 0 && array[array.length - 2] !== '(' && array[j] === '(' && array[array.length - 1] === ')') ||
                (i > 0 && array[array.length - 2] !== '[' && array[j] === '[' && array[array.length - 1] === ']')) {
                return false;
            }
            if ((searchingForOppositeOf === '{' && array[j] === '}') ||
                (searchingForOppositeOf === '[' && array[j] === ']') ||
                (searchingForOppositeOf === '(' && array[j] === ')')) {
                array[i] = 0;
                array[j] = 0;
                break;
            }
        }
    }
    return array.every(element => element === 0);
};*/

export const matchingBrackets = (str) => {
  let brackets = str;

  while (brackets !== (brackets = brackets.replace(BRACKETS_REGEXP, '')));
  return (brackets.length === 0);
};

export const BRACKETS_REGEXP = /\{\}|\[\]|\(\)/g;
export const isPangram = (sentence) => {
    const ALPHABET = 'abcdefghijklmnopqrstuvwxyz';

    return [...ALPHABET].every(value => sentence.toLowerCase().includes(value));
};
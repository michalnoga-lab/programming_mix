export const toRna = (rns) =>
    rns.split('').map(rna => TRANSCRIPTION[rna]).join('');

const TRANSCRIPTION = {G: 'C', C: 'G', T: 'A', A: 'U'}
export const age = (planet, seconds) => {
    const EARTH_YEARS = seconds / 365.25 / 24 / 60 / 60;
    let comparision = (EARTH_YEARS / YEARS_COMPARISION[planet]).toFixed(2);
    return parseFloat(comparision);
};

const YEARS_COMPARISION = {
    earth: 1.000000000,
    mercury: 0.2408467,
    venus: 0.61519726,
    mars: 1.8808158,
    jupiter: 11.862615,
    saturn: 29.447498,
    uranus: 84.016846,
    neptune: 164.79132
}
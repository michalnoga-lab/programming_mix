class SpaceAge {
    double ageInSeconds, earthYears;

    SpaceAge(double seconds) {
        ageInSeconds = seconds;
        earthYears = seconds / 365.25 / 24 / 60 / 60;
    }

    double getSeconds() {
        return ageInSeconds;
    }

    double onEarth() {
        return earthYears;
    }

    double onMercury() {
        return earthYears / 0.2408467;
    }

    double onVenus() {
        return earthYears / 0.61519726;
    }

    double onMars() {
        return earthYears / 1.8808158;
    }

    double onJupiter() {
        return earthYears / 11.862615;
    }

    double onSaturn() {
        return earthYears / 29.447498;
    }

    double onUranus() {
        return earthYears / 84.016846;
    }

    double onNeptune() {
        return earthYears / 164.79132;
    }
}
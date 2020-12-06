import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    private LocalDateTime time;

    Gigasecond(LocalDate moment) {
        this.time = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
        this.time = moment;

    }

    LocalDateTime getDateTime() {
        return time.plusSeconds((int) Math.pow(10, 9));
    }
}
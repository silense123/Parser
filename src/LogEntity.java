import java.time.LocalDateTime;
import java.time.LocalTime;

public class LogEntity {

    private String Day;
    private String month;
    private String year;
    private String TimeStartHour;
    private String TimeStartMinute;
    private String FirstNumber;
    private String CO;
    private String SecondNumber;
    private String Tail;
    private String State;
    private String PhoneMin;
    private String PhoneSec;
    private String DurationHour;
    private String DurationMin;
    private String DurationSec;
    private LocalDateTime Timer;
    private LocalTime Timer1;
    private  LocalTime Timer2;

    public LocalTime getTimer2() {
        return Timer2;
    }

    public void setTimer2(LocalTime timer2) {
        Timer2 = timer2;
    }

    public LocalTime getTimer1() {
        return Timer1;
    }

    public void setTimer1(LocalTime timer1) {
        Timer1 = timer1;
    }

    public LocalDateTime getTimer() {
        return Timer;
    }

    public void setTimer(LocalDateTime timer) {
        Timer = timer;
    }

    public String getDurationSec() {
        return DurationSec;
    }

    public void setDurationSec(String durationSec) {
        DurationSec = durationSec;
    }

    public String getPhoneMin() {
        return PhoneMin;
    }

    public void setPhoneMin(String phoneMin) {
        PhoneMin = phoneMin;
    }

    public String getPhoneSec() {
        return PhoneSec;
    }

    public void setPhoneSec(String phoneSec) {
        PhoneSec = phoneSec;
    }

    public String getDurationHour() {
        return DurationHour;
    }

    public void setDurationHour(String durationHour) {
        DurationHour = durationHour;
    }

    public String getDurationMin() {
        return DurationMin;
    }

    public void setDurationMin(String durationMin) {
        DurationMin = durationMin;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTimeStartHour() {
        return TimeStartHour;
    }

    public void setTimeStartHour(String timeStartHour) {
        TimeStartHour = timeStartHour;
    }

    public String getTimeStartMinute() {
        return TimeStartMinute;
    }

    public void setTimeStartMinute(String timeStartMinute) {
        TimeStartMinute = timeStartMinute;
    }

    public String getFirstNumber() {
        return FirstNumber;
    }

    public void setFirstNumber(String firstNumber) {
        FirstNumber = firstNumber;
    }

    public String getCO() {
        return CO;
    }

    public void setCO(String CO) {
        this.CO = CO;
    }

    public String getSecondNumber() {
        return SecondNumber;
    }

    public void setSecondNumber(String secondNumber) {
        SecondNumber = secondNumber;
    }

    public String getTail() {
        return Tail;
    }

    public void setTail(String tail) {
        Tail = tail;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }


}

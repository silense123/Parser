
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) {
        String line1;
        String line;

        ArrayList<String> result = new ArrayList<>();
        File fileinput = new File("E://Lensk.2017-03-07.txt");
        //File fileinput = new File("C://logs.txt");
        String secondline;
        File fileoutput = new File("E://Lensk.2017-03-07NEW.txt");
        final String FIRST_REGEX_PATTERN = "\\w{2}\\/+.{14}+\\d{5}+.*";
        final String SECOND_REGEX_PATTERN = "(.{2})\\/(.{2})\\/(.{2})\\s*(.{2})\\:(.{2})\\s*(\\d*)\\s*(\\d*)\\s*([0-9<I>*#A-Za-z]*)\\s*(.{14})\\s*(.{2})";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileinput))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileoutput))) {
                bufferedWriter.write("|Начало соединения|" + "Время ответа20|" + "Конец соединения32|" + "Статус43|" +
                        "Исходящий номер49|" + "Входящий номер|" + "\n");


                while ((line = bufferedReader.readLine()) != null) {
                    Pattern firstPattern = Pattern.compile(FIRST_REGEX_PATTERN);
                    Pattern secongPattern = Pattern.compile(SECOND_REGEX_PATTERN);
                    Matcher firstmatcher = firstPattern.matcher(line);

                    if (firstmatcher.find()) {
                        line1 = firstmatcher.group(0);
                        Matcher secondmatcher = secongPattern.matcher(line1);
                        if (secondmatcher.find()) {
                            LogEntity logEntity = new LogEntity();
                            logEntity.setDay(secondmatcher.group(1));
                            logEntity.setMonth(secondmatcher.group(2));
                            logEntity.setYear(secondmatcher.group(3));
                            logEntity.setTimeStartHour(secondmatcher.group(4));
                            logEntity.setTimeStartMinute(secondmatcher.group(5));
                            logEntity.setCO(secondmatcher.group(7));
                            logEntity.setState(secondmatcher.group(10));
                            if (secondmatcher.group(9).substring(1, 2).equals("\'")) {
                                logEntity.setPhoneSec(secondmatcher.group(9).substring(2, 4));
                                logEntity.setPhoneMin(secondmatcher.group(9).substring(0, 1));
                                logEntity.setDurationHour(secondmatcher.group(9).substring(5, 7));
                                logEntity.setDurationMin(secondmatcher.group(9).substring(8, 10));
                                logEntity.setDurationSec(secondmatcher.group(9).substring(11, 13));
                            } else {
                                logEntity.setDurationHour(secondmatcher.group(9).substring(0, 2));
                                logEntity.setDurationMin(secondmatcher.group(9).substring(3, 5));
                                logEntity.setDurationSec(secondmatcher.group(9).substring(6, 8));
                                logEntity.setPhoneMin("00");
                                logEntity.setPhoneSec("00");
                            }

                            if (secondmatcher.group(6).length() < 15) {
                                logEntity.setFirstNumber(secondmatcher.group(6) + ("-").repeat(15 - secondmatcher.group(6).length()));
                            }

                            if (secondmatcher.group(8).substring(0, 3).equals("<I>")) {
                                logEntity.setSecondNumber(logEntity.getFirstNumber());
                                logEntity.setFirstNumber(secondmatcher.group(8).substring(3) + ("-").repeat(18 - secondmatcher.group(8).length()));
                            } else {
                                if (secondmatcher.group(8).length() < 15) {
                                    logEntity.setSecondNumber(secondmatcher.group(8) + ("-").repeat(15 - secondmatcher.group(8).length()));
                                } else {
                                    logEntity.setSecondNumber(secondmatcher.group(8).substring(0, 15));
                                }
                            }

                            logEntity.setTimer(LocalDateTime.of(Integer.parseInt(20 + logEntity.getYear()), Integer.parseInt(logEntity.getMonth()), Integer.parseInt(logEntity.getDay()), Integer.parseInt(logEntity.getTimeStartHour()), Integer.parseInt(logEntity.getTimeStartMinute()), 00, 0));
                            logEntity.setTimer1(LocalTime.of(Integer.parseInt(logEntity.getTimeStartHour()), Integer.parseInt(logEntity.getTimeStartMinute()), 0));
                            logEntity.setTimer2(LocalTime.of(Integer.parseInt(logEntity.getTimeStartHour()), Integer.parseInt(logEntity.getTimeStartMinute()), 0));
                            logEntity.setTimer2(logEntity.getTimer2().plusSeconds(Integer.parseInt(logEntity.getPhoneSec())));
                            logEntity.setTimer1(logEntity.getTimer1().plusSeconds(Integer.parseInt(logEntity.getDurationSec())));
                            logEntity.setTimer2(logEntity.getTimer2().plusMinutes(Integer.parseInt(logEntity.getPhoneMin())));
                            logEntity.setTimer1(logEntity.getTimer1().plusMinutes(Integer.parseInt(logEntity.getDurationMin())));
                            logEntity.setTimer1(logEntity.getTimer1().plusHours(Integer.parseInt(logEntity.getDurationHour())));
                            //bufferedWriter.write(logEntity.getDay() + " " + logEntity.getMonth() + " " + logEntity.getYear() + " " + logEntity.getTimeStartHour() + " " + logEntity.getTimeStartMinute() + " " +
                            //"00" + " " + logEntity.getTimeStartHour() + " " + pluss((logEntity.getPhoneMin()), logEntity.getTimeStartMinute()) + " " + logEntity.getPhoneSec() + " " + pluss(logEntity.getTimeStartHour() ,logEntity.getDurationHour()) + " " + status(logEntity.getState()) + " " + logEntity.getFirstNumber() + " " + logEntity.getCO() + " "
                            //+ logEntity.getSecondNumber() + " " + "\n");
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            String formatDateTime = logEntity.getTimer1().format(formatter);
                            String formatPhoneTime = logEntity.getTimer2().format(formatter);
                            bufferedWriter.write(logEntity.getTimer() + "\t" + formatPhoneTime + "\t" + formatDateTime
                                    + "     " + status(logEntity.getState()) + "     " + logEntity.getFirstNumber() + "     "
                                    + logEntity.getCO() + "     " + logEntity.getSecondNumber() + "    " + "00" + "\n");

                        }
                        //System.out.println(line.substring(0,2));
                    } else {
                        //System.out.println("Ничего не вышло");
                        //System.err.println(line);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int pluss(String lol, String kek) {
        int k = Integer.parseInt(lol) + Integer.parseInt(kek);
        return k;
    }

    public static String status(String kok) {
        if (kok.isBlank()) {
            return "00";
        } else {
            return kok;
        }
    }
}


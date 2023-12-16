package oncall.service;

import java.util.Arrays;
import java.util.List;
import oncall.domain.EmergencyWorkers;
import oncall.domain.date.Month;

class WorkSchedulerTest {


    public static void main(String[] args) {

        String w = "허브,쥬니,말랑,라온,헤나,우코,에단,수달,파워,히이로,마코,슬링키,모디,연어,깃짱,리오,고니,박스터,달리,조이,노아이즈,도이,도치,홍고,스캇,폴로,해시,로지,첵스,아이크,우가,푸만능,애쉬,로이스,오션";
        List<String> wNameList = Arrays.stream(w.split(",")).toList();

        String h = "오션,로이스,애쉬,푸만능,우가,아이크,첵스,로지,해시,폴로,스캇,홍고,도치,도이,노아이즈,조이,달리,박스터,고니,리오,깃짱,연어,모디,슬링키,마코,히이로,파워,수달,에단,우코,헤나,라온,말랑,쥬니,허브";
        List<String> hNameList = Arrays.stream(h.split(",")).toList();

        EmergencyWorkers weekday = EmergencyWorkers.from(wNameList);
        EmergencyWorkers holiday = EmergencyWorkers.from(hNameList);
        System.out.println(wNameList);
        System.out.println(hNameList);

        WorkScheduler scheduler = new WorkScheduler(weekday, holiday, new Month(4, "토"));
        scheduler.schedule();
        scheduler.printCalendar();
    }
}
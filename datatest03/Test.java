package datatest03;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
            
        LocalDate now = LocalDate.now();
        DateTimeFormatter nowdate= DateTimeFormatter.ofPattern("yyyyMMdd");
        String baseDate= now.format(nowdate);
        LocalTime now2 = LocalTime.now();
        DateTimeFormatter nowtime = DateTimeFormatter.ofPattern("HHmm");
        String baseTime= now2.format(nowtime);
        
        System.out.println("오늘의 날짜    :"+ baseDate);  
        System.out.println("지금 시간은    " + baseTime);


        Map<String, String> weatherMap = DownloadWeather.getWeatherList(baseDate, baseTime);

        System.out.println("부산 진구의 현재 온도는 " + weatherMap.get("T1H") + "도 입니다.");

    }
}
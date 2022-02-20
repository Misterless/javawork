package datatest.pubexam;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import datatest.pubexam.ResponseDto.Response.Body.Items.Item;

public class MainApp {
    public static void main(String[] args) {
        int totalCount=1;
        LocalDate nowDate = LocalDate.now();
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 날짜(시작일)를 입력하시오");
        
        String startCreateDt = sc.nextLine();
        
        System.out.println("마지막날짜(종료일) 을 입력하시오");
        System.out.println("참고할 오늘의 날짜: "+nowDate);
        String endCreateDt = sc.nextLine();
        
        
        List<Item> coronaList = DownloadDto.getCoronaList(startCreateDt, endCreateDt);
        for (int i = 0; i < coronaList.size(); i++) {
            totalCount=i++;
            System.out.println("--------------------------------------");
            System.out.println("누적 의심신고검사자 : " + coronaList.get(i).getAccExamCnt());
            System.out.println("등록 시각 : " + coronaList.get(i).getCreateDt());
            System.out.println("사망자 수 : " + coronaList.get(i).getDeathCnt());
            System.out.println("확진자 수 : " + coronaList.get(i).getDecideCnt());
            System.out.println("기준일 : " + coronaList.get(i).getStateDt());
            System.out.println("기준 시간 : " + coronaList.get(i).getStateTime());
            System.out.println("수정 시각 : " + coronaList.get(i).getUpdateDt());
            System.out.println("페이지값 " + coronaList.get(i).getSeq());
            System.out.println("--------------------------------------");

        }
        //System.out.println(coronaList);
        //System.out.println(DownloadDto.getCoronaList(startCreateDt, endCreateDt));
        System.out.println("총 "+totalCount+"건을 검색했습니다.");
    }
}
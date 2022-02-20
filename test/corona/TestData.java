package test.corona;

import java.util.List;
import java.util.Scanner;

import test.corona.ResponseDto.Response.Body.Items.Item;

public class TestData {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("조회시작일을 입력하시오");

        String startCreateDt = sc.nextLine();
        System.out.println("마지막조회일을 입력하시오");

        String lastCreateDt = sc.nextLine();

        List<Item> dataList = DownloadData.getDataList(startCreateDt, lastCreateDt);
            System.out.println(dataList);
            for (int i = 0; i < dataList.size(); i++) {
            System.out.println("------------------------------------------");
            System.out.println("누적 의심검사자 : " + dataList.get(i).getAccExamCnt());
            System.out.println("등록 시각 : " + dataList.get(i).getCreateDt());
            System.out.println("사망자 : " + dataList.get(i).getDeathCnt());
            System.out.println("확진자 : " + dataList.get(i).getDecideCnt());
            System.out.println("감염현황 페이지 : " + dataList.get(i).getSeq());
            
            System.out.println("기준일 : " + dataList.get(i).getStateDt());
            System.out.println("업로드기준 시간 : " + dataList.get(i).getStateTime());
            System.out.println("수정한 시간 : " + dataList.get(i).getUpdateDt());
            System.out.println("------------------------------------------");
        }
        //System.out.println("총 결과수:"+ dataList.get().gettotalCount());
    }
}
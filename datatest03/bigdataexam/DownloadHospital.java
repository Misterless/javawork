package datatest03.bigdataexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import datatest03.bigdataexam.ResponseDto.Response.Body.Items.Item;

public class DownloadHospital {
    public static Map<String, String> getHospitalList(String baseDate, String baseTime) {
        Map<String, String> hospitalMap = new HashMap<>();

        try {
            URL url = new URL(
                    "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService?serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3D%3D&pageNo=1&numOfRows=10&_type=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(responseJson, ResponseDto.class);

            List<Item> result = responseDto.getResponse().getBody().getItems().getItem();

            for (int i = 0; i < result.size(); i++) {
                hospitalMap.put(result.get(i).getCategory(), result.get(i).getpcrPsbYn());
            }

            return hospitalMap;

        } catch (Exception e) {
            System.out.println("주소 입력에러");
        }

        return null;
    }
}
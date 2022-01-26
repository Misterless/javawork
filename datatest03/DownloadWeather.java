package datatest03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import datatest03.ResponseDto.Response.Body.Items.Item;

public class DownloadWeather {
    public static Map<String, String> getWeatherList(String baseDate, String baseTime) {
        Map<String, String> weatherMap = new HashMap<>();

        try {
            URL url = new URL(
                    "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=6agEwgjqMkXU2ZbxYZKsgzGH8HlS3rbvXIamE0A42URCsY66k%2Bk65Ds%2BnBSHqSJ0c9LrgXOMr9h%2FqlFdHneIcw%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date="
                            + baseDate + "&base_time=" + baseTime + "&nx=97&ny=75&type=json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String responseJson = br.readLine();
            Gson gson = new Gson();
            ResponseDto responseDto = gson.fromJson(responseJson, ResponseDto.class);

            List<Item> result = responseDto.getResponse().getBody().getItems().getItem();

            for (int i = 0; i < result.size(); i++) {
                weatherMap.put(result.get(i).getCategory(), result.get(i).getObsrValue());
            }

            return weatherMap;

        } catch (Exception e) {
            System.out.println("주소 입력에러");
        }

        return null;
    }
}
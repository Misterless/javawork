package test.corona;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.google.gson.Gson;

import test.corona.ResponseDto.Response.Body.Items.Item;

public class DownloadData {
    public static Map<String,String> getDataList(String startCreateDt, String endCreateDt) {
      List <> downlodData = 
        try {
            URL url = new URL(
                    "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?" +
                            "serviceKey=6agEwgjqMkXU2ZbxYZKsgzGH8HlS3rbvXIamE0A42URCsY66k%2Bk65Ds%2BnBSHqSJ0c9LrgXOMr9h%2FqlFdHneIcw%3D%3D&"
                            +
                            "pageNo=1&"+"numOfRows=10&"+"startCreateDt="+startCreateDt+"&endCreateDt="+endCreateDt);
                            System.out.println(url);
            
                
            
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String responseJson = br.readLine();
                    Gson gson = new Gson();
                    ResponseDto responseDto = gson.fromJson(responseJson, ResponseDto.class);
                    List<Item> result = responseDto.getResponse().getBody().getItems().getItem();
                    
                    for (int i = 0; i < result.size(); i++) {
                        dataMap.put(result.get(i).getStateDt(),result.get(i).getSeq());

                    
                    }
           

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataMap;
    }


}
package datatest03.bigdataexam;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private Response response;

    @AllArgsConstructor
    @Data
    class Response {
        private Header header;
        private Body body;

        @AllArgsConstructor
        @Data
        class Header {
            private String resultCode;
            private String resultMsg;
        }

        @AllArgsConstructor
        @Data
        class Body {
            private Items items;
            private int pageNo;
            private int numOfRows;
            private int totalCount;

            @AllArgsConstructor
            @Data
            class Items {
                private List<Item> item;

                @AllArgsConstructor
                @Data
                class Item {
                    private String addr;
                    private String mgtStaDd;
                    private char pcrPsbYn;
                    private char ratPsbYn;
                    private char rprtWorpClicFndtTgtYn;
                    private int recuClCd;
                    private String sgguNm;
                    private String sidoNm;
                    private double XPosWgs84;
                    private int XPos;
                    private double YPosWgs84;
                    private int YPos;
                    private String yadmNm;
                    private String ykihoEnc;
                }
            }
        }
    }
}

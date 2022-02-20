package test.corona;

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
            public Items Items;

            @Data
            @AllArgsConstructor
            public class Items {

                public List<Item> item = null;

                @Data
                @AllArgsConstructor
                public class Item {
                    private long accExamCnt;
                    private String createDt;
                    private int deathCnt;
                    private String seq;
                    private int decideCnt;
                    private String stateDt;
                    private String stateTime;
                    private String updateDt;
                }
            }

            public Integer numOfRows;

            public Integer pageNo;

            public Integer totalCount;

        }

    }
}
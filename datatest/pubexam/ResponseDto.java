package datatest.pubexam;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    public Response response;

    @Data
    @AllArgsConstructor
    public class Response {

        public Header header;

        @Data
        @AllArgsConstructor
        public class Header {

            public String resultCode;

            public String resultMsg;

        }

        public Body body;

        @Data
        @AllArgsConstructor
        public class Body {

            public Items items;

            @Data
            @AllArgsConstructor
            public class Items {

                public List<Item> item = null;

                @Data
                @AllArgsConstructor
                public class Item {

                    public Long accExamCnt; // 누적 의심신고 검사자

                    public String createDt;// 등록 일시분초

                    public Integer deathCnt; // 사망자 수

                    public Integer decideCnt; // 확진자 수

                    public Integer seq; // 게시글페이지값

                    public Integer stateDt; // 기준일

                    public String stateTime; // 기준 시간

                    public String updateDt; // 수정 일시분초

                }

            }

            public Integer numOfRows;

            public Integer pageNo;

            public Integer totalCount;

        }

    }

}
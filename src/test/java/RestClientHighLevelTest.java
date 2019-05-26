import org.ceek.SpringBootESApplication;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringBootESApplication.class})// 指定启动类
public class RestClientHighLevelTest {
    @Autowired
    RestHighLevelClient highLevelClient;

    @Test
    public void testOne(){
        SearchRequest searchRequest = new SearchRequest("article*");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("sourceType", "1"));
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse search = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//            long totalHits = search.getHits().getTotalHits();
            long totalHits = search.getHits().getTotalHits();
            System.out.println(totalHits);


//            SearchResponse response = highLevelClient.search(searchRequest);
//            Arrays.stream(response.getHits().getHits())
//                    .forEach(i -> {
//                        System.out.println(i.getIndex());
//                        System.out.println(i.getSource());
//                        System.out.println(i.getType());
//                    });
//            System.out.println(response.getHits().totalHits);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}

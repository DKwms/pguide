import com.alibaba.fastjson2.JSON;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.lucene.index.Term;
import org.apache.lucene.util.QueryBuilder;
import org.bouncycastle.cert.ocsp.Req;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pguide.search.PguideSearchApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author DKwms
 * @Date 2024/1/17 16:43
 * @description
 */

@SpringBootTest(classes = PguideSearchApplication.class)
public class BaseESTest {

    String INDEX = "pguide_groupinfo";

    @Autowired
    RestHighLevelClient client;


    private static final String HOST_URL = "http://118.178.195.97:9200";
    @Value("${myes.username}")
    private String username;
    @Value("${myes.password}")
    private String password;

    @BeforeEach
    void pre(){

        RestClientBuilder builder = RestClient.builder(
                HttpHost.create(HOST_URL)
        );

        // 设置密码
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username, password));
        builder.setHttpClientConfigCallback(f -> f.setDefaultCredentialsProvider(credentialsProvider));

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

        this.client = new RestHighLevelClient(builder);

    }

    @Test
    void getIt() throws IOException {
        SearchRequest searchRequest = new SearchRequest(INDEX);

        SearchSourceBuilder query = searchRequest.source().query(QueryBuilders.matchQuery("school", "学校A"));

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        handleResult(search);
    }


    @Test
    void agg() throws IOException {
        SearchRequest searchRequest = new SearchRequest(INDEX);

        searchRequest.source().size();

        searchRequest.source().aggregation(
                AggregationBuilders
                        .terms("schoolAgg")
                        .field("school")
                        .size(10));


        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);

        Aggregations aggregations = response.getAggregations();

        Terms schoolAgg = aggregations.get("schoolAgg");

        List<? extends Terms.Bucket> buckets = schoolAgg.getBuckets();
        for (Terms.Bucket bucket : buckets) {
            System.out.println("bucket.getKeyAsString() = " + bucket.getKeyAsString());
        }
    }

    private static void handleResult(SearchResponse searchOut) {
        //结果处理
        SearchHits searchHits = searchOut.getHits();

        //总条数
        long value = searchHits.getTotalHits().value;

        //结果数组
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String jsonResult = hit.getSourceAsString();
            //System.out.println("jsonResult = " + JSON.parseObject(jsonResult, HotelDoc.class).toString());
            System.out.println(jsonResult);
        }
    }

    @Test
    public void generateTestData() {
        for (int i = 1; i <= 10; i++) {
            IndexRequest request = new IndexRequest("pguide_groupinfo")
                    .id(String.valueOf(i))
                    .source(getSampleData(i), XContentType.JSON);

            try {
                IndexResponse response = client.index(request, RequestOptions.DEFAULT);
                System.out.println("Document indexed with ID: " + response.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getSampleData(int index) {
        // Customize this method to generate your sample data
        return "{"
                + "\"project_name\": \"Project" + index + "\","
                + "\"subject\": \"Subject" + index + "\","
                + "\"member\": ["
                + "{\"member_id\": " + index + ", \"member_type\": \"Type" + index + "\", \"member_name\": \"Name" + index + "\"},"
                + "{\"member_id\": " + (index + 1) + ", \"member_type\": \"Type" + (index + 1) + "\", \"member_name\": \"Name" + (index + 1) + "\"}"
                + "],"
                + "\"school\": \"School" + index + "\","
                + "\"academy\": \"Academy" + index + "\","
                + "\"city\": \"City" + index + "\","
                + "\"needs\": {\"need_id\": " + index + ", \"need_type_name\": \"Type" + index + "\", \"need_info\": \"Info" + index + "\"},"
                + "\"open_level\": \"Level" + index + "\","
                + "\"cpt_info\": ["
                + "{\"cpt_name\": \"CptName" + index + "\", \"cpt_type\": \"CptType" + index + "\"},"
                + "{\"cpt_name\": \"CptName" + (index + 1) + "\", \"cpt_type\": \"CptType" + (index + 1) + "\"}"
                + "],"
                + "\"coin\": " + index
                + "}";
    }

    @Test
    void TestUUid(){

    }




    @AfterEach
    void end() throws IOException {
        client.close();
    }
}

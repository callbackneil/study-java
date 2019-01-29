package org.neil.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.neil.domain.ActivityGiftProductVO;
import com.alibaba.fastjson.JSONObject;

public class ImageUtil {

    public static InputStream writeHttpImgToPath2(String imgurl) {
        try {
            //new一个URL对象
            URL url = new URL(imgurl);
            //打开链接
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(5 * 1000);
            //通过输入流获取图片数据
            InputStream inputio = conn.getInputStream();


            return inputio;
        } catch (IOException e) {

        }
        return null;
    }

    public static void request(InputStream stream) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = "http://localhost:8088/study/test/test5";
        HttpPost httppost = new HttpPost(uri);
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("file", stream, ContentType.DEFAULT_BINARY,"imagename.jpg");
        entityBuilder.addTextBody("id","2");
        entityBuilder.addTextBody("level","3");
        HttpEntity reqEntity = entityBuilder.build();
        httppost.setEntity(reqEntity);
        HttpResponse response = httpClient.execute(httppost);
        InputStream inputStream = response.getEntity().getContent();
        //创建一个输出流
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inputStream.read(buffer)) != -1 ){
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            byteOutStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inputStream.close();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = byteOutStream.toByteArray();

        JSONObject jsonObject = JSONObject.parseObject(new String(data));
        System.out.println(jsonObject);
    }



    public static void request() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = "http://localhost:8088/study/test/test5";
        HttpPost httppost = new HttpPost(uri);
        //
        ActivityGiftProductVO vo = new ActivityGiftProductVO();
        vo.setCount(1);
        vo.setGiftCount(2);
        vo.setGiftSendCount(3);
        String jsonString = JSONObject.toJSONString(vo);
        ByteArrayEntity entity = new ByteArrayEntity(jsonString.getBytes(), ContentType.APPLICATION_JSON);
        httppost.setEntity(entity);
        HttpResponse response = httpClient.execute(httppost);
        InputStream inputStream = response.getEntity().getContent();
        //创建一个输出流
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inputStream.read(buffer)) != -1 ){
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            byteOutStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inputStream.close();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = byteOutStream.toByteArray();

        JSONObject jsonObject = JSONObject.parseObject(new String(data));
        System.out.println(jsonObject);
    }




    public static void main(String[] args) throws IOException {
//        request(writeHttpImgToPath2("https://img.alicdn.com/bao/uploaded/i4/856668273/O1CN01xhFRxQ2Az58H2MyyR_!!856668273.jpg"));
//          {"success":"","result":{"pid":"123"}}
//        JSONObject jsonObject = JSONObject.parseObject("{\"success\":\"\",\"result\":{\"pid\":\"123\"}}");
//        JSONObject result = JSONObject.parseObject(jsonObject.getString("result"));
//        String pid = result.getString("pid");
//        System.out.println();


//        writeHttpImgToPath2("https://www.jianshu.com/p/ec770c8a5035");

//        test();

        request();

    }



    public static void test() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uri = "https://img.alicdn.com/bao/uploaded/i4/856668273/O1CN01xhFRxQ2Az58H2MyyR_!!856668273.jpg";
        HttpGet httppost = new HttpGet(uri);
        HttpResponse response = httpClient.execute(httppost);
        InputStream inputStream = response.getEntity().getContent();
        //创建一个输出流
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inputStream.read(buffer)) != -1 ){
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            byteOutStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inputStream.close();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = byteOutStream.toByteArray();

        JSONObject jsonObject = JSONObject.parseObject(new String(data));
    }


}

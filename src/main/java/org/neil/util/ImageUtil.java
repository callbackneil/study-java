package org.neil.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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
        HttpPost httppost = new HttpPost("http://localhost:8088/lc/company/uploadLogo");
//        HttpPost httppost = new HttpPost("http://192.168.11.117:30001/base/upload");
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        entityBuilder.addBinaryBody("file", stream, ContentType.DEFAULT_BINARY,"imagename.jpg");
        entityBuilder.addTextBody("remarkType","2");
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


    public static String request(List<String> urls) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // test
        String uri = "http://192.168.11.117:30001/base/upload";
        HttpPost httppost = new HttpPost(uri);
        // 正式 TODO
//        HttpPost httppost = new HttpPost("http://combs.youdongxi.com/combs/data/base/upload");

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        for (String url : urls) {
            multipartEntityBuilder.addTextBody("urls",url);
        }
        multipartEntityBuilder.addTextBody("remarkType","2");
        HttpEntity reqEntity = multipartEntityBuilder.build();
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
        if("true".equals(jsonObject.getString("success"))){
            JSONObject result = JSONObject.parseObject(jsonObject.getString("result"));
            return  result.getString("pid");
        }else {
            throw new Exception();
        }

    }


    public static void main(String[] args) throws IOException {
        request(writeHttpImgToPath2("https://img.alicdn.com/bao/uploaded/i4/856668273/O1CN01xhFRxQ2Az58H2MyyR_!!856668273.jpg"));
//          {"success":"","result":{"pid":"123"}}
//        JSONObject jsonObject = JSONObject.parseObject("{\"success\":\"\",\"result\":{\"pid\":\"123\"}}");
//        JSONObject result = JSONObject.parseObject(jsonObject.getString("result"));
//        String pid = result.getString("pid");
//        System.out.println();


    }



}

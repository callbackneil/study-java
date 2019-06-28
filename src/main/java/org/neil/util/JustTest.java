package org.neil.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author neil
 * @date 2019-06-26
 */
public class JustTest {
    public static void main(String[] args) {
        String s = "{\"id\":72,\"num\":1,\"oid\":\"3419776373367027\",\"registerId\":54,\"skuCode\":\"476870101\",\"status\":10,\"version\":0}";
        System.out.println(s.length());

        Map<String,String> map = new HashMap<>();
        map.put("0",null);
        map.put("1","1");
        String jsonString = JSONObject.toJSONString(map);
        System.out.println(jsonString);


    }



}

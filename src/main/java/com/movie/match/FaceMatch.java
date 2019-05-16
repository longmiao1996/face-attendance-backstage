package com.movie.match;


import com.alibaba.fastjson.JSONObject;
import com.movie.utils.Base64Util;
import com.movie.utils.FileUtil;
import com.movie.utils.GsonUtils;
import com.movie.utils.HttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Spring;



public class FaceMatch {

    public static boolean match(String image_pa1,String image_pa2) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {

 //          byte[] bytes1 = FileUtil.readFileByBytes(image_pa1);
            byte[] bytes2 = FileUtil.readFileByBytes(image_pa2);
            String image1 = image_pa1;
            String image2 = Base64Util.encode(bytes2);

            List<Map<String, Object>> images = new ArrayList<>();

            Map<String, Object> map1 = new HashMap<>();
            map1.put("image", image1);
            map1.put("image_type", "BASE64");
            map1.put("face_type", "LIVE");
            map1.put("quality_control", "LOW");
            map1.put("liveness_control", "NORMAL");

            Map<String, Object> map2 = new HashMap<>();
            map2.put("image", image2);
            map2.put("image_type", "BASE64");
            map2.put("face_type", "LIVE");
            map2.put("quality_control", "LOW");
            map2.put("liveness_control", "NORMAL");

            images.add(map1);
            images.add(map2);

            String param = GsonUtils.toJson(images);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.9d67ec3bc1b84c3d79442272ed612662.2592000.1558361091.282335-15774712";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            JSONObject jsonObject = JSONObject.parseObject(result);
            /*String e_m = jsonObject.getString("error_msg");
            if(e_m)*/
            // 获取到key为shoppingCartItemList的值
            String r = jsonObject.getString("result");
            JSONObject jsonOb = JSONObject.parseObject(r);
            String k = jsonOb.getString("score");
            float a = Float.valueOf(k).intValue();
            System.out.println(a);
            if (a>80){
                return true;

            }
            else {
                return false;
            }

           //return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   /* public static void main(String[] args) {
        FaceMatch.match();


        //getAuth();
    }*/
}

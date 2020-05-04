package com.liang;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/5/3 22:08
 * @content
 */
public class HttpUtils {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
            sendGet("words","UTF-8")

        );
        System.out.println(future.get());
    }



    public static String sendGet(String words, String charset) {
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=Skykai521&key=977124034&type=data&doctype=json&version=1.1&q=" + words;
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
// 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
// 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
// 建立实际的连接
            connection.connect();
// 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
// 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        Gson gson = new Gson();
        Translattion translattion = gson.fromJson(result, Translattion.class);
        if (translattion==null){
            return "暂无翻译\n\n【Translate plugin created by liangyehao】";
        }
        System.out.println(translattion);
        String explains = translattion.getBasic()==null?"": String.valueOf(translattion.getBasic().getExplains());
        return translattion.getTranslation()
                +"\n"+
                explains
                +"\n\n【Translate plugin created by liangyehao】";
    }


}

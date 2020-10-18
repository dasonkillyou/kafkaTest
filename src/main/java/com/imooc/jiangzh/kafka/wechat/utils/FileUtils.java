package com.imooc.jiangzh.kafka.wechat.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : jiangzh
 * @description : 文件工具类
 **/
@Slf4j
public class FileUtils {

//  读取文件转为字符串
  public static String readFile(String filePath) throws IOException {
    @Cleanup
    BufferedReader reader = new BufferedReader(
        new FileReader(new File(filePath))
    );

    String lineStr = "";
    StringBuffer stringBuffer = new StringBuffer();
    while ((lineStr = reader.readLine()) != null) {
      stringBuffer.append(lineStr);
    }

    return stringBuffer.toString();
  }

//读取文件转为json字符串，并创建一个optional对象
  public static Optional<JSONObject> readFile2JsonObject(String filePath){
    try {
      String fileContent = readFile(filePath);
      log.info("readFile2Json fileContent: [{}]" , fileContent);
      return Optional.ofNullable(JSON.parseObject(fileContent));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

//  读取文件转为数组，并创建一个optiona1对象
  public static Optional<JSONArray> readFile2JsonArray(String filePath){
    try {
      String fileContent = readFile(filePath);
      log.info("readFile2JsonArray fileContent: [{}]" , fileContent);
      return Optional.ofNullable(JSON.parseArray(fileContent));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

}

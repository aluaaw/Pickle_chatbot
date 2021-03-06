/*
package com.chatbot.web.test;

import com.chatbot.web.domains.Chat;
import com.chatbot.web.domains.ChatHistory;
import com.chatbot.web.domains.Exam;
import com.chatbot.web.mappers.ChatHistoryMapper;
import com.chatbot.web.mappers.ChatMapper;
import com.chatbot.web.mappers.ExamMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class LegacySerializer {
    @Autowired Chat chat;
    @Autowired ChatHistory chatHistory;
    @Autowired Exam exam;
    @Autowired ChatMapper chatMapper;
    @Autowired ChatHistoryMapper chatHistoryMapper;
    @Autowired ExamMapper examMapper;
    private JSONObject obj, arrObj, innerObj, middleObj, outsideObj, mostInnerObj, mostInnerObj1, getMostInnerObj2,
            innerObj1, innerObj2, innerObj3, innerObj4, innerObj5, innerObj6, innerObj7, innerObj8, innerObj9;
    private JSONArray arr, arr1, arr2;
    private ObjectMapper mapper;
    private JSONParser parser;

    public Map<String, Object> commonSer(Map<String, Object> jsonParams) throws JsonProcessingException {
        mapper = new ObjectMapper();
        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonParams);
        parser = new JSONParser();
        SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        obj = new JSONObject();
        arrObj = new JSONObject();
        arr = new JSONArray();
        innerObj = new JSONObject();
        mostInnerObj = new JSONObject();

        try {
            JSONObject objJson = (JSONObject) parser.parse(jsonStr);
            //userInfo
            JSONObject userRequest = (JSONObject) objJson.get("userRequest");
            String chatBody = (String) userRequest.get("utterance");
            String userInfo = userRequest.toString();
            //block name
            JSONObject action = (JSONObject) objJson.get("action");
            String block = (String) action.get("name");
            //date
            String uDate = sDate.format(new Date()); //날짜 지정
            Date toDate = sDate.parse(uDate);

            chat.setChatBody(chatBody);
            System.out.println(block);

            //fomat
            if(block.contains("start")){
            }else if(block.contains("exit")){
            }

            //insert, update 조건문
            chatMapper.insertData(chat);

            chatHistory.setChatId(chat.getId());
            System.out.println(chat.getId());
            chatHistory.setChatKind("C");
            chatHistory.setUserInfo(userInfo);
            chatHistory.setChatBody(chatBody);
            chatHistoryMapper.insertData(chatHistory);

            mostInnerObj.put("text", "챗봇이 종료됩니다. 감사합니다.");
            innerObj.put("simpleText", mostInnerObj);
            arr.add(innerObj);
            arrObj.put("outputs", arr);
            obj.put("template", arrObj);
            obj.put("version", "2.0");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public Map<String, Object> subjectCodeSer() throws JsonProcessingException {
        obj = new JSONObject();
        arrObj = new JSONObject();
        arr = new JSONArray();
        innerObj = new JSONObject();
        mostInnerObj = new JSONObject();

        arr1 = new JSONArray();
        arrObj = new JSONObject();
        innerObj1 = new JSONObject();
        innerObj2 = new JSONObject();
        innerObj3 = new JSONObject();
        innerObj4 = new JSONObject();
        innerObj5 = new JSONObject();
        innerObj6 = new JSONObject();
        innerObj7 = new JSONObject();
        innerObj8 = new JSONObject();
        innerObj9 = new JSONObject();
        mostInnerObj1 = new JSONObject(); //block

//        for(int i=0; i < 8; ++i) {
//            innerObj1.put("action", "message");
//            innerObj1.put("label", subjects);
//            innerObj1.put("messageText", subjects);
//            arr1.add(innerObj1);
//        }

        innerObj1.put("action", "message");
        innerObj1.put("label", "국어");
        innerObj1.put("messageText", "국어");
        arr1.add(innerObj1);

        innerObj2.put("action", "message");
        innerObj2.put("label", "영어");
        innerObj2.put("messageText", "영어");
        arr1.add(innerObj2);

        innerObj3.put("action", "message");
        innerObj3.put("label", "수학");
        innerObj3.put("messageText", "수학");
        arr1.add(innerObj3);

        innerObj4.put("action", "message");
        innerObj4.put("label", "생활과 윤리");
        innerObj4.put("messageText", "생활과 윤리");
        arr1.add(innerObj4);

        innerObj5.put("action", "message");
        innerObj5.put("label", "지리");
        innerObj5.put("messageText", "지리");
        arr1.add(innerObj5);

        innerObj6.put("action", "message");
        innerObj6.put("label", "경제");
        innerObj6.put("messageText", "경제");
        arr1.add(innerObj6);

        innerObj7.put("action", "message");
        innerObj7.put("label", "물리");
        innerObj7.put("messageText", "물리");
        arr1.add(innerObj7);

        innerObj8.put("action", "message");
        innerObj8.put("label", "생명과학");
        innerObj8.put("messageText", "생명과학");
        arr1.add(innerObj8);

        innerObj9.put("action", "message");
        innerObj9.put("label", "지구과학");
        innerObj9.put("messageText", "지구과학");
        arr1.add(innerObj9);

        arrObj.put("quickReplies", arr1);

        mostInnerObj.put("text", "과목명을 선택해주세요.");
        innerObj.put("simpleText", mostInnerObj);
        arr.add(innerObj);
        arrObj.put("outputs", arr);
        obj.put("template", arrObj);
        obj.put("version", "2.0");

        chatHistory.setChatKind("B");
        chatHistory.setChatBody("과목명을 선택해주세요.");
        chatHistoryMapper.insertData(chatHistory);

        return obj;
    }

    public Map<String, Object> examAnalysisSer() {
        obj = new JSONObject();
        arrObj = new JSONObject();
        arr = new JSONArray();

        outsideObj = new JSONObject();
        middleObj = new JSONObject();
        innerObj = new JSONObject();
        mostInnerObj = new JSONObject();
        getMostInnerObj2 = new JSONObject();

        arr1 = new JSONArray();
        arr2 = new JSONArray();
        innerObj1 = new JSONObject();
        mostInnerObj1 = new JSONObject();

        obj.put("version", "2.0");
        obj.put("template", arrObj);
        arrObj.put("outputs", arr);
        arr.add(outsideObj);

        outsideObj.put("carousel", middleObj);
        middleObj.put("type", "basicCard");
        middleObj.put("items", arr1);

        arr1.add(innerObj);

        innerObj.put("title", "[시험문제 번호]\n[시험문제 질문]");
        innerObj.put("description", "정답: [시험문제 정답]\n선택한 답: [오답]\n[시험문제 내용]");
        innerObj.put("thumbnail", mostInnerObj);
        mostInnerObj.put("imageUrl", "https://cdn.pixabay.com/photo/2014/06/03/19/38/road-sign-361513_1280.jpg");

        innerObj.put("buttons", arr2);
        arr2.add(mostInnerObj1);
        arr2.add(getMostInnerObj2);
        mostInnerObj1.put("messageText", "처음으로");
        mostInnerObj1.put("label", "처음으로");
        mostInnerObj1.put("action", "message");
        getMostInnerObj2.put("messageText", "챗봇종료");
        getMostInnerObj2.put("label", "챗봇종료");
        getMostInnerObj2.put("action", "message");

        return obj;
    }

    public void chatDataParser(Map<String, Object> jsonParams) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonParams);
        JSONParser parser = new JSONParser();
        SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //날짜 포맷 지정

        try {
            JSONObject obj = (JSONObject) parser.parse(jsonStr);
            JSONObject userRequest = (JSONObject) obj.get("userRequest");
            String chatBody = (String) userRequest.get("utterance");
//            JSONObject block = (JSONObject) userRequest.get("block");
//            String name = (String) block.get("name"); //block's name
            String userInfo = userRequest.toString();

            String uDate = sDate.format(new Date()); //날짜 지정
            Date toDate = sDate.parse(uDate);

            chat.setChatBody(chatBody);

            //update 로직 변경
            if(chat.getInsertDate() != null){
                chatMapper.insertData(chat);
            }else{
                chat.setCheckDate(uDate);
                chatMapper.updateData(chat);
            }

            chatHistory.setChatId(chat.getId());
            System.out.println(chat.getId());
            chatHistory.setChatKind("C");
            chatHistory.setUserInfo(userInfo);
            chatHistory.setChatBody(chatBody);
            chatHistoryMapper.insertData(chatHistory);
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    public void examAnalysisParser(Map<String, Object> jsonData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
        JSONParser parser = new JSONParser();

        try {
            JSONObject obj = (JSONObject) parser.parse(jsonStr);
            JSONObject userRequest = (JSONObject) obj.get("userRequest");
            String subjectCode = (String) userRequest.get("utterance");
//            System.out.println("subjectCode: " + subjectCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 */
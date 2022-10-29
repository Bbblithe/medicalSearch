package com.blithe.medical_search.utils;

import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.segment.mode.impl.SegmentModes;
import com.github.houbb.segment.support.segment.result.impl.SegmentResultHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 14:18
 * Description:
 */

public class LanguageUtils {
   public static List<String>  Participle(String sentence){
      List<String> wordList = new ArrayList<>();
      sentence = sentence.replaceAll("[\\pP\\p{Punct}]","");
      if(isEnglish(sentence)){
         List<String> tempList = new ArrayList<>();

         StringTokenizer st = new StringTokenizer(sentence," ,?.!:\"\"''\n#");
         while (st.hasMoreElements()) {
            tempList.add(st.nextToken());
         }
         String tempS = "";
         String[] tempString = tempList.toArray(new String[0]);
         for(int i = 1 ; i <= tempString.length ; i ++){ // 大小
            for(int j = 0 ; (j + i) <= tempString.length  ; j ++){ // 下标
               for(int k = 0 ; k < i ; k ++){
                  tempS += tempString[j+k];
                  if(k+1 < i) {
                     tempS += " ";
                  }
               }
               wordList.add(tempS);
               tempS = "";
            }
         }
         return wordList;
      }

      wordList = SegmentBs.newInstance()
              .segmentMode(SegmentModes.dict())
              .segment(sentence,SegmentResultHandlers.word());
      if(sentence.contains("卡马西平")){
         wordList.add("卡马西平");
      }
      return wordList;
   }

   public static boolean isEnglish(String p) {
      byte[] bytes = p.getBytes();
      int i = bytes.length;//i为字节长度
      int j = p.length();//j为字符长度
      return i == j;
   }
}

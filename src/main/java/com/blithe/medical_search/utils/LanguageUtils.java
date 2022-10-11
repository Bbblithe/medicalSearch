package com.blithe.medical_search.utils;

import com.github.houbb.segment.bs.SegmentBs;
import com.github.houbb.segment.support.format.impl.SegmentFormats;
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
   public static List<String>  chineseParticiple(String sentence){
      List<String> resultList = SegmentBs.newInstance()
              .segmentMode(SegmentModes.dict())
              .segmentFormat(SegmentFormats.chineseSimple())
              .segment(sentence,SegmentResultHandlers.word());
      return resultList;
   }

   public static List<String> englishParticiple(String sentence){
      StringTokenizer st = new StringTokenizer(sentence," ,?.!:\"\"''\n#");
      List<String> wordList = new ArrayList<>();
      while (st.hasMoreElements()) {
         wordList.add(st.nextToken());
      }
      wordList.add(sentence);
      return wordList;
   }

   public static boolean isEnglish(String p) {
      byte[] bytes = p.getBytes();
      int i = bytes.length;//i为字节长度
      int j = p.length();//j为字符长度
      return i == j;
   }
}

package com.blithe.medical_search.domain;

/**
 * Author:  blithe.xwj
 * Date:    2022/10/18 10:46
 * Description:
 */

public class Recm {
   private String sentence;
   private Integer count;

   public Recm(String sentence, Integer count) {
      this.sentence = sentence;
      this.count = count;
   }

   public Recm() {
   }

   public String getSentence() {
      return sentence;
   }

   public Integer getCount() {
      return count;
   }

   public void setCount(Integer count) {
      this.count = count;
   }

   public void setSentence(String sentence) {
      this.sentence = sentence;
   }
}

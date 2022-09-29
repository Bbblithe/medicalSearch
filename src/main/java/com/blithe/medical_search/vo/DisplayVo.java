package com.blithe.medical_search.vo;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 15:41
 * Description:
 */

public class DisplayVo {
   private String chinese;
   private String english;
   private String content;
   private String tag;

   public DisplayVo(String chinese, String english, String content, String tag) {
      this.chinese = chinese;
      this.english = english;
      this.content = content;
      this.tag = tag;
   }

   public DisplayVo() {
   }

   public String getChinese() {
      return chinese;
   }

   public void setChinese(String chinese) {
      this.chinese = chinese;
   }

   public String getEnglish() {
      return english;
   }

   public void setEnglish(String english) {
      this.english = english;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getTag() {
      return tag;
   }

   public void setTag(String tag) {
      this.tag = tag;
   }

   @Override
   public String toString() {
      return "DisplayVo{" +
              "chinese='" + chinese + '\'' +
              ", english='" + english + '\'' +
              ", content='" + content + '\'' +
              ", tag='" + tag + '\'' +
              '}';
   }
}

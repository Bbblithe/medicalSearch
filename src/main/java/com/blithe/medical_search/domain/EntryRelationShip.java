package com.blithe.medical_search.domain;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:29
 * Description:
 */

public class EntryRelationShip {
   private String fatherId;
   private String id;

   public EntryRelationShip() {
   }

   public EntryRelationShip(String sonId, String id) {
      this.fatherId = sonId;
      this.id = id;
   }

   public String getFatherId() {
      return fatherId;
   }

   public void setFatherId(String fatherId) {
      this.fatherId = fatherId;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
}

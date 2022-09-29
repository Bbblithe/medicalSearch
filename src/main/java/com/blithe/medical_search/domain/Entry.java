package com.blithe.medical_search.domain;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:02
 * Description:
 */

public class Entry {
    private String id;
    private String english;
    private String chinese;
    private String synId;

    public Entry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getSynId() {
        return synId;
    }

    public void setSynId(String synId) {
        this.synId = synId;
    }
}

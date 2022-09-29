package com.blithe.medical_search.service;

import java.util.List;
import java.util.Map;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:17
 * Description:
 */

public interface EntryService {
    /**
     * 处理分词组件分词的词组进行查询，并返回存在数据库的所有指导会议等
     * @return 返回的是所有的相关词条的guidance等
     */
    public Map<String,Object> showAllExplain(List<String> words,boolean flag);
}

package com.blithe.medical_search.service.impl;

import com.blithe.medical_search.dao.EntryDao;
import com.blithe.medical_search.domain.Entry;
import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.vo.DisplayVo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:17
 * Description:
 */

@Service
public class EntryServiceImpl implements EntryService {

    @Resource
    private EntryDao entryDao;

    /**
     *
     * @param words 已经分毫词条的链表
     * @param flag  ture 代表为英文 false代表中文
     * @return
     */
    @Override
    public Map<String,Object> showAllExplain(List<String> words,boolean flag) {
        Map<String,Object> map = new HashMap<>();
        Set<String> ids = new HashSet<>();

        for(String word:words){
            Entry entry;
            if(flag) {
                entry = entryDao.englishQueryId(word);
            }else{
                entry = entryDao.chineseQueryId(word);
            }
            if(entry != null){
                ids.addAll(entryDao.searchSynId(entry.getSynId()));
                ids.addAll(entryDao.searchSonId(entry.getId()));
            }
        }

        // if(flag){
        //     for(String word:words){
        //         Entry entry = entryDao.englishQueryId(word);
        //         if(entry.getId() != null){
        //             ids.addAll(entryDao.searchSynId(entry.getSynId()));
        //             ids.addAll(entryDao.searchSonId(entry.getId()));
        //         }
        //     }
        // }else {
        //     for (String word : words) {
        //         // 通过词语拿到id
        //         Entry entry = entryDao.chineseQueryId(word);
        //         if(entry.getId() != null){
        //             ids.addAll(entryDao.searchSynId(entry.getSynId()));
        //             ids.addAll(entryDao.searchSonId(entry.getId()));
        //         }
        //     }
        // }
        if(ids.size() == 0){
            map.put("count",0);
            map.put("showcaseList",null);
            return map;
        }
        List<DisplayVo> displayVos = entryDao.findAllExplain(ids);
        map.put("count",displayVos.size());
        map.put("showcaseList",displayVos);
        return map;
    }
}

package com.blithe.medical_search.service.impl;

import com.blithe.medical_search.dao.EntryDao;
import com.blithe.medical_search.domain.Entry;
import com.blithe.medical_search.domain.Recm;
import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.utils.LanguageUtils;
import com.blithe.medical_search.vo.DisplayVo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param sentence 传来的句子
     * @param flag  ture 代表为英文 false代表中文
     * @return
     */
    @Override
    @Transactional
    public Map<String,Object> showAllExplain(String sentence,boolean flag) throws Exception {
        Map<String,Object> map = new HashMap<>();
        Set<String> ids = new HashSet<>();
        Set<String> temp = new HashSet<>();
        List<String> words = LanguageUtils.Participle(sentence);
        for(String word:words){
            Entry entry;
            if(flag) {
                entry = entryDao.englishQueryId(word);
            }else{
                entry = entryDao.chineseQueryId(word);
            }
            if(entry != null){
                temp.addAll(entryDao.searchSynId(entry.getSynId()));
                for(String id : temp){
                    ids.addAll(entryDao.searchSonId(id));
                }
                ids.addAll(temp);
            }
        }
        if(ids.size() == 0){
            map.put("count",0);
            map.put("showcaseList",null);
            return map;
        }
        Recm recm = entryDao.searchSentence(sentence);
        if(recm == null){
            if(entryDao.addRecommendation(sentence) > 1){
                throw new Exception("添加推荐数量错误");
            }
        }else{
            recm.setCount(recm.getCount() + 1);
            if( entryDao.updateCount(recm) > 1){
                throw new Exception("添加推荐数量错误");
            }
        }
        List<DisplayVo> displayVos = entryDao.findAllExplain(ids);
        map.put("count",displayVos.size());
        map.put("showcaseList",displayVos);
        return map;
    }
}

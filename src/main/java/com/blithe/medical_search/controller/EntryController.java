package com.blithe.medical_search.controller;

import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.utils.LanguageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:18
 * Description:
 */


@Controller
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @RequestMapping("/search")
    @ResponseBody
    public Map<String,Object> getEntryExplain(String sentence){
        Map<String,Object> map;
        if(LanguageUtils.isEnglish(sentence)){
            map = entryService.showAllExplain(LanguageUtils.EnglishParticiple(sentence),true);
        }else {
            map = entryService.showAllExplain(LanguageUtils.ChineseParticiple(sentence),false);
        }
        return map;
    }
}

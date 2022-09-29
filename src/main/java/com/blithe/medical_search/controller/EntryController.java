package com.blithe.medical_search.controller;

import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.utils.LanguageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:18
 * Description:
 */


@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/{id}")
    public Map<String,Object> getEntryExplain(@PathVariable String sentence){
        Map<String,Object> map = new HashMap<>();
        if(LanguageUtils.isEnglish(sentence)){

        }else {

        }
        return map;
    }
}

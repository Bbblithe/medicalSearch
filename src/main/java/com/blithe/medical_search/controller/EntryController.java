package com.blithe.medical_search.controller;

import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.utils.LanguageUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getEntryExplain(String sentence){
        ModelAndView mv = new ModelAndView();
        mv.addObject("question",sentence);
        Map<String,Object> map;
        if(LanguageUtils.isEnglish(sentence)){
            map = entryService.showAllExplain(LanguageUtils.englishParticiple(sentence),true);
        }else {
            map = entryService.showAllExplain(LanguageUtils.chineseParticiple(sentence),false);
        }
        mv.addObject("map",map);
        mv.setViewName("/showcase.jsp");
        return mv;
    }
}

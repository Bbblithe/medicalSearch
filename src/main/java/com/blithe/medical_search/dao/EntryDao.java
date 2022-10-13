package com.blithe.medical_search.dao;

import com.blithe.medical_search.domain.Entry;
import com.blithe.medical_search.domain.Recm;
import com.blithe.medical_search.vo.DisplayVo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:02
 * Description:
 */

public interface EntryDao {

    @Select("select id,chinese,english,synId from table_entry where Chinese = #{word} and synId is not null")
    public Entry chineseQueryId(String word);

    @Select("select id,chinese,english,synId from table_entry where BINARY English = #{word} and synId is not null")
    public Entry englishQueryId(String word);

    @Select("select id from table_entry_relationship where fatherId = #{id} ")
    public List<String> searchSonId(String id);

    @Select("select id from table_entry where synId = #{synId}")
    public List<String> searchSynId(String synId);

    // @Select("select te.chinese,te.english,ts.explain as content,ts.content as tag from table_showcase as ts " +
    //         "join table_entry as te on ts.id = te.id where ts.id IN (#{idSet}) order by level")
    @Select("<script>" +
            "select te.chinese,te.english,ts.explain as content,ts.content as tag from table_showcase as ts join table_entry as te on ts.id = te.id where ts.id IN(" +
            "<foreach collection='idSet' item='id' separator=','>" +
            "#{id}" +
            "</foreach>" +
            ")order by level" +
            "</script>")
    public List<DisplayVo> findAllExplain(@Param("idSet") Set<String> idSet);
    @Select("select sentence,count from table_recm where sentence=#{sentence}")
    public Recm searchSentence(String sentence);

    @Select("select sentence from table_recm order by count desc limit 0,4")
    public List<String> showRecommendations();

    @Insert("insert into table_recm values(#{sentence},1)")
    public int addRecommendation(String sentence);
    @Update("update table_recm set count=#{count} where sentence=#{sentence} ")
    public int updateCount(Recm recm);
}

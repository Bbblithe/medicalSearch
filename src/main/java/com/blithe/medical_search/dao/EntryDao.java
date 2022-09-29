package com.blithe.medical_search.dao;

import com.blithe.medical_search.domain.Entry;
import com.blithe.medical_search.vo.DisplayVo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 12:02
 * Description:
 */

public interface EntryDao {

    @Select("select id,chinese,english,synId from table_entry where Chinese = #{word}")
    public Entry chineseQueryId(String word);

    @Select("select id,chinese,english,synId from table_entry where English = #{word}")
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

}

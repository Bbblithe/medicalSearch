import com.blithe.medical_search.config.SpringConfig;
import com.blithe.medical_search.service.EntryService;
import com.blithe.medical_search.utils.LanguageUtils;
import com.blithe.medical_search.vo.DisplayVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author:  blithe.xwj
 * Date:    2022/9/29 13:47
 * Description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EntryServiceTest {

    @Autowired
    private EntryService entryService;

    @Test
    public void testShowAll(){
        for(DisplayVo vo:(List<DisplayVo>)entryService.showAllExplain(LanguageUtils.ChineseParticiple("你好我今天很开心，但是摔了一交很难受，呜呜"),false).get("showcaseList")){
            System.out.println(vo);
        }
    }
}

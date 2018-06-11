import com.baizhi.entity.Character1;
import com.baizhi.entity.China;
import com.baizhi.entity.Title;
import com.baizhi.entity.User;
import com.baizhi.service.AlbumService;
import com.baizhi.service.UserCountService;
import com.baizhi.service.UserService;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * Created by Administrator on 2018/5/27 0027.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestOne {
    @Autowired
    private UserCountService userCountService;
    @Test
    public void test1(){

    }
    @Test
    public void queryUser() {
        List<China> nan =  userCountService.queryByAddress("nan");
        System.out.println(nan.size()+"==========================================");
    }
}

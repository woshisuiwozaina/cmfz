package com.baizhi.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.baizhi.entity.China;
import com.baizhi.service.UserCountService;
import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/3 0003.
 */
@Controller
@RequestMapping(value = "/count")
public class UserCountController {
    @Autowired
    private UserCountService userCountService;

    @ResponseBody
    @RequestMapping(value = "/user")
    public List<Integer> count(){
        List<Integer> integers = userCountService.queryCount();

        return integers;

    }

    @ResponseBody
    @RequestMapping(value = "/china")
    public Map<String, List<China>> china(){
        List<China> lists1 = userCountService.queryByAddress("男");
        List<China> lists2 = userCountService.queryByAddress("女");
        HashMap<String, List<China>> map = new HashMap<String, List<China>>();
        map.put("man" ,lists1);
        map.put("woman" ,lists2);
      /*
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io" , "\n" +
                "BC-5b340691c5fc40719355c439a04796ff ");

        String data = JSONUtils.toJSONString(map);
        goEasy.publish("xiaojunjie" , data);
*/
      return map;
    }
}

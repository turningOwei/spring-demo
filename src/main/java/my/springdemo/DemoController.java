package my.springdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author turningOwei
 * @date 2019-05-19 17:53
 */
@RestController
public class DemoController {
    @RequestMapping("/demo")
    public Map demo(){
        Map map = new HashMap<>(16);
        map.put("code","1234");
        map.put("ms","测试");
        return map;
    }
}

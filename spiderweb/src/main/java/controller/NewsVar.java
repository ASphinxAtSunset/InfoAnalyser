package controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spider.service.OriginalDataService;
import com.spider.vo.ConditionVo;
import com.uniontrip.base.web.ResponseBean;
import com.uniontrip.lvzhi.statistics.StatisticsController;

/**
 * Created by Gene on 2017/7/25.
 */
@Controller
@RequestMapping(value = "/user")
public class NewsVar {
	private static Logger log = LoggerFactory.getLogger(StatisticsController.class);
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public ResponseBean generateqrcode(@RequestBody Map<String, Object> param){
    }
}

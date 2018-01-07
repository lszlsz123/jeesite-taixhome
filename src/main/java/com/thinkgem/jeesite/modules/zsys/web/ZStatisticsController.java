package com.thinkgem.jeesite.modules.zsys.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zsys.service.ZOperatorBusinessChangeService;

@Controller
@RequestMapping(value = "${adminPath}/zsys/ZStatistics")
public class ZStatisticsController extends BaseController{

	@Autowired
	private ZOperatorBusinessChangeService zOperatorBusinessChangeService;
	
	public class ResultMap { 
        private String time;
        private Integer count;
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public Integer getCount() {
			return count;
		}
		public void setCount(Integer count) {
			this.count = count;
		}
        
        
    } 
	
	//责任经营者变更业务办理统计
	@RequestMapping(value = {"statisticsOperationBusinessChange", ""})
	public String statisticsOperationBusinessChange(Model model) throws ParseException {
		Map<String, Object> map = zOperatorBusinessChangeService.statisticsOperationBusinessChange();
		model.addAttribute("map",map);
		int gap = 48;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat simpleDateFormat1 =new SimpleDateFormat("yyyy");
		SimpleDateFormat simpleDateFormat2 =new SimpleDateFormat("yyyy-MM-dd");
		List<ResultMap> list = new ArrayList<ResultMap>();
		List<ResultMap> list1 = new ArrayList<ResultMap>();
		List<ResultMap> list2 = new ArrayList<ResultMap>();
		List<ResultMap> list3 = new ArrayList<ResultMap>();
		String currentYear = simpleDateFormat1.format(date);
		String lastYear = (Integer.parseInt(currentYear)-1)+"";
		String yearBeforeLastYear = (Integer.parseInt(lastYear)-1)+"";
		String threeYearAgo = (Integer.parseInt(yearBeforeLastYear)-1)+"";
		model.addAttribute("currentYear",currentYear);
		model.addAttribute("lastYear",lastYear);
		model.addAttribute("yearBeforeLastYear",yearBeforeLastYear);
		model.addAttribute("threeYearAgo",threeYearAgo);
		Date date1 = simpleDateFormat2.parse(currentYear+"-12-31");
		for(int i=0; i<gap;i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(date1);
			c.add(Calendar.MONTH, -i);
			String time = simpleDateFormat.format(c.getTime());
			logger.info(time);
			if((map.get(time)!=null)==false) {
				map.put(time, 0);
				logger.info(time+"导入0的数据");
			}else {
				logger.info("有数据"+time+map.get(time));
			}
			logger.info(time+map.get(time));
			ResultMap resultMap = new ResultMap();
			resultMap.setTime(time);
			resultMap.setCount(Integer.parseInt(map.get(time).toString()));
			if(time.startsWith(currentYear)) {
				list.add(resultMap);
			}
			if(time.startsWith(lastYear)) {
				list1.add(resultMap);
			}
			if(time.startsWith(yearBeforeLastYear)) {
				list2.add(resultMap);
			}
			if(time.startsWith(threeYearAgo)) {
				list3.add(resultMap);
			}
		}
		model.addAttribute("currentYear_q1",genQuarter(map,currentYear,1));
		model.addAttribute("currentYear_q2",genQuarter(map,currentYear,2));
		model.addAttribute("currentYear_q3",genQuarter(map,currentYear,3));
		model.addAttribute("currentYear_q4",genQuarter(map,currentYear,4));
		
		model.addAttribute("lastYear_q1",genQuarter(map,lastYear,1));
		model.addAttribute("lastYear_q2",genQuarter(map,lastYear,2));
		model.addAttribute("lastYear_q3",genQuarter(map,lastYear,3));
		model.addAttribute("lastYear_q4",genQuarter(map,lastYear,4));
		
		model.addAttribute("yearBeforeLastYear_q1",genQuarter(map,yearBeforeLastYear,1));
		model.addAttribute("yearBeforeLastYear_q2",genQuarter(map,yearBeforeLastYear,2));
		model.addAttribute("yearBeforeLastYear_q3",genQuarter(map,yearBeforeLastYear,3));
		model.addAttribute("yearBeforeLastYear_q4",genQuarter(map,yearBeforeLastYear,4));
		
		model.addAttribute("threeYearAgo_q1",genQuarter(map,threeYearAgo,1));
		model.addAttribute("threeYearAgo_q2",genQuarter(map,threeYearAgo,2));
		model.addAttribute("threeYearAgo_q3",genQuarter(map,threeYearAgo,3));
		model.addAttribute("threeYearAgo_q4",genQuarter(map,threeYearAgo,4));
		
		model.addAttribute("list",list);
		model.addAttribute("list1",list1);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		return "modules/zsys/zOperatorBusinessChangeStatistics";
	}
	
	private Integer genQuarter(Map<String, Object> map,String currentYear,Integer seq) {
			Integer qNumber = 0;
			if(seq == 1) {
				Integer var1 = (map.get(currentYear+"-01")!=null)?(Integer)map.get(currentYear+"-01"):0;
				Integer var2 = (map.get(currentYear+"-02")!=null)?(Integer)map.get(currentYear+"-02"):0;
				Integer var3 = (map.get(currentYear+"-03")!=null)?(Integer)map.get(currentYear+"-03"):0;
				qNumber = var1+var2+var3;
			}
			if(seq == 2) {
				Integer var4 = (map.get(currentYear+"-04")!=null)?(Integer)map.get(currentYear+"-04"):0;
				Integer var5 = (map.get(currentYear+"-05")!=null)?(Integer)map.get(currentYear+"-05"):0;
				Integer var6 = (map.get(currentYear+"-06")!=null)?(Integer)map.get(currentYear+"-06"):0;
				qNumber = var4+var5+var6;
			}
			if(seq == 3) {
				Integer var7 = (map.get(currentYear+"-07")!=null)?(Integer)map.get(currentYear+"-07"):0;
				Integer var8 = (map.get(currentYear+"-08")!=null)?(Integer)map.get(currentYear+"-08"):0;
				Integer var9 = (map.get(currentYear+"-09")!=null)?(Integer)map.get(currentYear+"-09"):0;
				qNumber = var7+var8+var9;
			}
			if(seq == 4) {
				Integer var10 = (map.get(currentYear+"-10")!=null)?(Integer)map.get(currentYear+"-10"):0;
				Integer var11 = (map.get(currentYear+"-11")!=null)?(Integer)map.get(currentYear+"-11"):0;
				Integer var12 = (map.get(currentYear+"-12")!=null)?(Integer)map.get(currentYear+"-12"):0;
				qNumber = var10+var11+var12;
			}
			return qNumber;
	}
	
}

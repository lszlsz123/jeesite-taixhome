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
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.service.DictService;
import com.thinkgem.jeesite.modules.zsys.service.ZOperatorBusinessChangeService;
import com.thinkgem.jeesite.modules.zsys.service.ZStatisticsService;

@Controller
@RequestMapping(value = "${adminPath}/zsys/ZStatistics")
public class ZStatisticsController extends BaseController{

	@Autowired
	private ZOperatorBusinessChangeService zOperatorBusinessChangeService;
	
	@Autowired
	private ZStatisticsService zStatisticsService;
	
	@Autowired
	private DictService dictService;
	
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
	
	public class ResultInsuranceMap{
		private String date;
		private String vehicleType;
		private String count;
		private List<String> list;
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getVehicleType() {
			return vehicleType;
		}
		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}
		public String getCount() {
			return count;
		}
		public void setCount(String count) {
			this.count = count;
		}
		public List<String> getList() {
			return list;
		}
		public void setList(List<String> list) {
			this.list = list;
		}
		
		
	}
	
	//安技--车辆技术维护记录查询
	@RequestMapping(value= {"maintenanceRecordQuery",""})
	public String maintenanceRecordQuery(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql1 = "select COUNT(1) as countNum from z_maintenance_record t where t.del_flag = '0' and (t.first_quarter is null or TRIM(t.first_quarter)='')";
		String sql2 = "select COUNT(1) as countNum from z_maintenance_record t where t.del_flag = '0' and (t.second_quarter is null or TRIM(t.second_quarter)='')";
		String sql3 = "select COUNT(1) as countNum from z_maintenance_record t where t.del_flag = '0' and (t.third_quarter is null or TRIM(t.third_quarter)='')";
		String sql4 = "select COUNT(1) as countNum from z_maintenance_record t where t.del_flag = '0' and (t.fourth_quarter is null or TRIM(t.fourth_quarter)='')";
		String sql1_detail = "select t.vehicle_num as countNum from z_maintenance_record t where t.del_flag = '0' and (t.first_quarter is null or TRIM(t.first_quarter)='')";
		String sql2_detail = "select t.vehicle_num as countNum from z_maintenance_record t where t.del_flag = '0' and (t.second_quarter is null or TRIM(t.second_quarter)='')";
		String sql3_detail = "select t.vehicle_num as countNum from z_maintenance_record t where t.del_flag = '0' and (t.third_quarter is null or TRIM(t.third_quarter)='')";
		String sql4_detail = "select t.vehicle_num as countNum from z_maintenance_record t where t.del_flag = '0' and (t.fourth_quarter is null or TRIM(t.fourth_quarter)='')";
		//1
		map = zStatisticsService.statisticsCount(sql1);
		model.addAttribute("count1",map.get("count"));
		List<String> list1 = new ArrayList<String>();
		list1 = zStatisticsService.getVehicleNum(sql1_detail.toString());
		model.addAttribute("list1",list1);
		
		//2
		map = zStatisticsService.statisticsCount(sql2);
		model.addAttribute("count2",map.get("count"));
		List<String> list2 = new ArrayList<String>();
		list2 = zStatisticsService.getVehicleNum(sql2_detail.toString());
		model.addAttribute("list2",list2);
		
		//3
		map = zStatisticsService.statisticsCount(sql3);
		model.addAttribute("count3",map.get("count"));
		List<String> list3 = new ArrayList<String>();
		list3 = zStatisticsService.getVehicleNum(sql3_detail.toString());
		model.addAttribute("list3",list3);
		
		//4
		map = zStatisticsService.statisticsCount(sql4);
		model.addAttribute("count4",map.get("count"));
		List<String> list4 = new ArrayList<String>();
		list4 = zStatisticsService.getVehicleNum(sql4_detail.toString());
		model.addAttribute("list4",list4);
		
		return "modules/zsys/maintenanceRecordQuery";
	}
	
	
	//安技--保险理赔业务查询
	@RequestMapping(value= {"insuranceClaimQuery",""})
	public String insuranceClaimQuery(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql1 = "select sum(cast(IFNULL(t.vehicle_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql2 = "select sum(cast(IFNULL(t.human_injury_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql3 = "select sum(cast(IFNULL(t.loss_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql4 = "select sum(cast(IFNULL(t.third_party_vehicle_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql5 = "select sum(cast(IFNULL(t.third_party_human_injury_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql6 = "select sum(cast(IFNULL(t.carrier_insurance_indemnity,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		String sql7 = "select sum(cast(IFNULL(t.total_amount,'0') as DECIMAL(10,3))) as countNum from z_insurance_claim_settlement t where t.del_flag = '0'";
		map = zStatisticsService.statisticsCount(sql1);
		model.addAttribute("count1",map.get("count"));
		map = zStatisticsService.statisticsCount(sql2);
		model.addAttribute("count2",map.get("count"));
		map = zStatisticsService.statisticsCount(sql3);
		model.addAttribute("count3",map.get("count"));
		map = zStatisticsService.statisticsCount(sql4);
		model.addAttribute("count4",map.get("count"));
		map = zStatisticsService.statisticsCount(sql5);
		model.addAttribute("count5",map.get("count"));
		map = zStatisticsService.statisticsCount(sql6);
		model.addAttribute("count6",map.get("count"));
		map = zStatisticsService.statisticsCount(sql7);
		model.addAttribute("count7",map.get("count"));
		return "modules/zsys/insuranceClaimQuery";
	}
	
	//安技--车辆投保情况查询
	@RequestMapping(value= {"insuranceQuery",""})
	public String insuranceQuery(Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		String sql1 = "select sum(cast(IFNULL(t.premium,'0') as DECIMAL(10,3))) as countNum from z_vehicle_insurance t where t.del_flag = '0'";
		String sql2 = "select sum(cast(IFNULL(t.third_party_premium,'0') as DECIMAL(10,3))) as countNum from z_vehicle_insurance t where t.del_flag = '0'";
		String sql3 = "select sum(cast(IFNULL(t.premium1,'0') as DECIMAL(10,3))) as countNum from z_vehicle_insurance t where t.del_flag = '0'";
		String sql4 = "select sum(cast(IFNULL(t.total_premium,'0') as DECIMAL(10,3))) as countNum from z_vehicle_insurance t where t.del_flag = '0'";
		map = zStatisticsService.statisticsCount(sql1);
		model.addAttribute("count1",map.get("count"));
		map = zStatisticsService.statisticsCount(sql2);
		model.addAttribute("count2",map.get("count"));
		map = zStatisticsService.statisticsCount(sql3);
		model.addAttribute("count3",map.get("count"));
		map = zStatisticsService.statisticsCount(sql4);
		model.addAttribute("count4",map.get("count"));
		String sql5 = "select DISTINCT t.vehicle_type as countNum, date_format(t.closing_date,'%Y-%m-%d') sdate from z_vehicle_insurance t where t.del_flag = '0'  order by sdate desc";
		List<Map<String, Object>> list = zStatisticsService.getDateAndVehicle(sql5);
		List<ResultInsuranceMap> result = new ArrayList<ZStatisticsController.ResultInsuranceMap>();
		for(Map<String, Object> mapItem : list) {
			StringBuffer sqlItem = new StringBuffer("select count(1) as countNum from z_vehicle_insurance t where t.del_flag = '0' ");
			StringBuffer sqlItemSearchVehicleNum = new StringBuffer("select t.vehicle_num as countNum from z_vehicle_insurance t where t.del_flag = '0'"); 
			if(mapItem.get("key")!=null) {
				String appendSQL = " and date_format(t.closing_date,'%Y-%m-%d')='"+mapItem.get("key").toString()+"' ";
				sqlItem.append(appendSQL);
				sqlItemSearchVehicleNum.append(appendSQL);
			}else {
				String appendSQL = " and t.closing_date is null";
				sqlItem.append(appendSQL);
				sqlItemSearchVehicleNum.append(appendSQL);
			}
			if(mapItem.get("value")!=null) {
				String appendSQL =" and t.vehicle_type ='"+mapItem.get("value").toString()+"' ";
				sqlItem.append(appendSQL);
				sqlItemSearchVehicleNum.append(appendSQL);
			}else {
				String appendSQL =" and t.vehicle_type is null' ";
				sqlItem.append(appendSQL);
				sqlItemSearchVehicleNum.append(appendSQL);
			}
			Map<String, Object> innerMap = new HashMap<String, Object>();
			innerMap = zStatisticsService.statisticsCount(sqlItem.toString());
			
			List<String> vehicelNumList = new ArrayList<String>();
			vehicelNumList = zStatisticsService.getVehicleNum(sqlItemSearchVehicleNum.toString());
			ResultInsuranceMap item = new ResultInsuranceMap();
			item.setCount(innerMap.get("count").toString());
			item.setDate((null!=mapItem.get("key"))?mapItem.get("key").toString():"");
			item.setVehicleType((mapItem.get("value")!=null)?mapItem.get("value").toString():"");
			item.setList(vehicelNumList);
			result.add(item);
		}
		model.addAttribute("list",result);
		
		return "modules/zsys/insuranceQuery";
	}
	
	//安技--诉讼案件查询
	@RequestMapping(value= {"litigationQuery",""})
	public String litigationQuery(Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		String sql = "select sum(cast(IFNULL(t.judgment_amount,'0') as DECIMAL(10,3))) as countNum from z_litigation t where t.del_flag = '0'";
		map = zStatisticsService.statisticsCount(sql);
		
		model.addAttribute("count",map.get("count"));
		return "modules/zsys/litigationQuery";
	}
	
	//安技--交通事故查询及业务
	@RequestMapping(value= {"accidentQuery",""})
	public String accidentQuery(Model model){
		Map<String, Object> map = zStatisticsService.statisticsCount("select count(1) as countNum from z_accident t where t.del_flag='0'");
		model.addAttribute("count",map.get("count"));
		String sql1 = "select sum(cast(IFNULL(t.claim_amount,'0') as DECIMAL(10,3))) as countNum from z_accident t where t.del_flag = '0' ";
		map = zStatisticsService.statisticsCount(sql1);
		model.addAttribute("claimCount",map.get("count"));
		String sql2 = "select count(1) as countNum from z_accident t where t.del_flag = '0' and TRIM(t.resp_situation)";
		
		String[] array = {"全责","主责","同责","次责","无责"};
		for(int i =0 ; i<array.length;i++) {
			String item = array[i];
			String sqlItem = sql2+" ='"+item+"'";
			Map<String, Object> mapItem = new HashMap<String, Object>();
			mapItem = zStatisticsService.statisticsCount(sqlItem);
			int j = i+1;
			model.addAttribute("resp_count_"+j,mapItem.get("count"));
		}
		
		
		return "modules/zsys/accidentQuery";
	}
	//责任经营者变更业务办理统计
	@RequestMapping(value = {"accidentReport", ""})
	public String accidentReport(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData1("z_manual_service","trim(module_name)='交通事故报案'");
		processStatistics(model, map);
		return "modules/zsys/accidentReport";
	}
	
	//责任经营者变更业务办理统计
	@RequestMapping(value = {"businessForeignAffairsOther", ""})
	public String businessForeignAffairsOther(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData1("z_manual_service","module_name!='外事人员业务办理'");
		processStatistics(model, map);
		return "modules/zsys/businessForeignAffairsOther";
	}
	
	//责任经营者变更业务办理统计
	@RequestMapping(value = {"businessForeignAffairsLoss", ""})
	public String businessForeignAffairsLoss(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData1("z_manual_service","module_name='外事人员业务办理'");
		processStatistics(model, map);
		return "modules/zsys/businessForeignAffairsLoss";
	}
	
	
	//责任经营者变更业务办理统计
	@RequestMapping(value = {"statisticsOperationBusinessChange", ""})
	public String statisticsOperationBusinessChange(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData("z_operator_business_change");
		processStatistics(model, map);
		return "modules/zsys/zOperatorBusinessChangeStatistics";
	}
	
	//运营违规查询及处理統計
	
	@RequestMapping(value = {"statisticsOperationViolation", ""})
	public String statisticsOperationViolation(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData("z_operation_violation");
		processStatistics(model, map);
		return "modules/zsys/zOperationViolationStatistics";
	}
	
	//证件遗失补办业务統計
	@RequestMapping(value = {"statisticsMakeUpLoss", ""})
	public String statisticsStatisticsMakeUpLoss(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData("z_make_up_loss");
		processStatistics(model, map);
		return "modules/zsys/zStatisticsMakeUpLossStatistics";
	}	

	//运营--责任经营车辆信息查询統計
	
	
	@RequestMapping(value = {"statisticsRespVehicleInfo", ""})
	public String statisticsRespVehicleInfo(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData("z_resp_vehicle_info");
		processStatistics(model, map);
		return "modules/zsys/zRespVehicleInfoStatistics";
	}	
	
	//运营--从业司机业务办理查询統計
	
	@RequestMapping(value = {"statisticsDriverBusiness", ""})
	public String statisticsDriverBusiness(Model model) throws ParseException {
		Map<String, Object> map = zStatisticsService.statisticsData("z_driver_business");
		processStatistics(model, map);
		return "modules/zsys/zDriverBusinessStatistics";
	}		
	
	
	
	
	
	
	private void processStatistics(Model model, Map<String, Object> map) throws ParseException {
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

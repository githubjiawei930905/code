package com.epeibao.controller.business;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.epeibao.controller.BaseController;
import com.epeibao.po.ComprehensiveAssessment;
import com.epeibao.po.PaymentAssessment;
import com.epeibao.po.TrainAssessment;
import com.epeibao.po.VehicleMaintenance;
import com.epeibao.service.ComprehensiveAssessmentService;
import com.epeibao.service.OperatingDataServive;
import com.epeibao.service.PaymentAssessmentService;
import com.epeibao.service.TrainAssessmentService;
import com.epeibao.service.VehicleMaintenanceService;
@Controller
@RequestMapping("/app")
public class OpratingDataBizController extends BaseController {
	private static final Logger LOGGER = Logger
			.getLogger(OpratingDataBizController.class);

	/**
	 * 请求数据上传是否成功状态  
	 */
	@RequestMapping(value = "/biz", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String isSucess(String info) {
		boolean flag;
		try {
			JSONObject json = JSON.parseObject(info);
			String token = json.getString("token");
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String driverId = param.getString("driverId");
			flag = comprehensiveAssessmentService.isSucessful(driverId);
			if (flag) {
				return add("10000", "成功", "{\"result\"" + ":" + "true}");
			}
			return add("10001", "没有通过考核", "{}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}

	@Autowired
	private ComprehensiveAssessmentService comprehensiveAssessmentService;
	@Autowired
	private OperatingDataServive servive;
	@Autowired
	private PaymentAssessmentService paymentAssessmentService;
	@Autowired
	private TrainAssessmentService trainAssessmentService;
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;

	/**
	 * 处理文件上传
	 * @param file
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add",produces = "text/html;charset=UTF-8" )
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file,
			HttpServletRequest res,String driverId) throws Exception {
		InputStream is = null;
		OutputStream os = null;
		try {
			Date date = new Date();
			DateFormat format = new SimpleDateFormat("yyyyMMdd"); 
			String  d=format.format(date);
			File mik  = new File("D:\\Tomcat 7.0\\webapps\\EpeiBao\\fileupload\\"+d);                 
			//如果文件不存在，则创建一个新文件夹
			if(!mik.exists() &&!mik.isDirectory()){
				mik.mkdirs();
			}

			// 指定文件存放的位置			
			String path = res.getRealPath("/fileupload/"+d);
			String originalFilename = file.getOriginalFilename();
			// 截取文件名
			String exName = (originalFilename.substring(
					(originalFilename.length() - 2), originalFilename.length()))
					.toUpperCase();
			is = file.getInputStream();
			os = new FileOutputStream(new File(path, originalFilename));

			int len = 0;
			byte[] buffer = new byte[1024*1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
				is.close();
				os.close();
			}
			String pathString="D:\\Tomcat 7.0\\webapps\\EpeiBao\\fileupload\\"+d+"\\"+originalFilename;
			if(exName.equals("A2")){
				servive.addOperatingDataAll2(driverId, pathString);
			}
			if(exName.equals("A9")){
				servive.addOperatingDataAll9(driverId, pathString);
			}
		System.out.println(21323);
			//传计价器截至日期
			String comId=comprehensiveAssessmentService.driverIdByComprehensiveAssessmentID(driverId);
			String time=date(comId);
			return add("10000", "上传成功", "{\"time\"" + ":" + "\""+time+"\" }");
		} catch (IOException e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{ }");
		}
	/*	InputStream is = null;
		OutputStream os = null;
		try {
			// 指定文件存放的位置
			String path = res.getRealPath("/fileupload");
			String originalFilename = file.getOriginalFilename();
			// 截取文件扩展名
			String exName = (originalFilename.substring(
					(originalFilename.length() - 2), originalFilename.length()))
					.toUpperCase();
			is = file.getInputStream();
			os = new FileOutputStream(new File(path, originalFilename));

			int len = 0;
			byte[] buffer = new byte[1024*1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
				is.close();
				os.close();
			}
			String pathString="D:\\Tomcat 7.0\\webapps\\EpeiBao\\fileupload\\"+originalFilename;
			if(exName.equals("A2")){
				servive.addOperatingDataAll2(driverId, pathString);
			}

			if(exName.equals("A9")){
				servive.addOperatingDataAll9(driverId, pathString);
			}

			//传计价器截至日期
			String comId=comprehensiveAssessmentService.driverIdByComprehensiveAssessmentID(driverId);
			String time=date(comId);
			return add("10000", "上传成功", "{\"time\"" + ":" + "\""+time+"\" }");
		} catch (IOException e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{ }");
		}*/
	}

	/**
	 * 同过综合评测Id查询计价器截至时间
	 */
	private String date(String comId){
		ComprehensiveAssessment comp= null;
		String str=null;
		String  d=null;
		try {
			comp= comprehensiveAssessmentService.findByComprehensiveAssessmentId(comId);
			str = comp.getTaximeterDeadline();   //获取截至日期
			//String str="2015-12-5 13:34";
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
			Date date = format.parse(str);
			Calendar c = Calendar.getInstance();  
			c.setTime(date); 
			c.add(Calendar.MONTH, 1);    //加一个月   
			Date time=c.getTime();
			String time1=format.format(time);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHH");
			d=format1.format(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 *  服务费的数据提取
	 * @param info
	 * @return
	 */
	@RequestMapping(value = "/opraData", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String OpratingInfo(String info){
		try {
			JSONObject json = JSON.parseObject(info);
			String token = json.getString("token");
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String driverId = param.getString("driverId");
			List<LinkedHashMap<String, Object>>  objects = servive.findByCompreId(driverId);  //传递监督卡号查询结果
			String str= JSON.toJSONString(objects);
			return add("10000", "成功","{\"result\""+":"+""+str+"}");
		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}
	}


	/**
	 * 个人中心的月度综合信息查询
	 * @param info
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="/useInfo",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String info(String info) throws Exception {
		try {
			JSONObject json = JSON.parseObject(info);
			String params = json.getString("params");
			JSONObject param = JSON.parseObject(params);
			String driverId = param.getString("userid");
			String time1=param.getString("time");
			String time=time1.substring(0,4)+time1.substring(time1.length()-2,time1.length()); 
			String str=driverId+time;
			//查询得到综合评测ID
			String cmId = comprehensiveAssessmentService.findByComprehensive(str);

			//蓝牙数据采集
			ComprehensiveAssessment comprehensiveAssessment = comprehensiveAssessmentService.findByComprehensiveAssessmentId(cmId);
			int lanya =comprehensiveAssessment.getIfDataAcquisition();
			List<LinkedHashMap<String, Object>> list0 = new ArrayList<LinkedHashMap<String, Object>>();
			LinkedHashMap<String, Object> link0 =new LinkedHashMap<>();
			link0.put("type",lanya);
			link0.put("reason","");
			list0.add(link0);

			if(cmId ==null){
				return add("10000", "成功", "{}");
			}
			//查看缴费信息
			//PaymentAssessment paymentAssessment = paymentAssessmentService.findById(cmId);
			PaymentAssessment paymentAssessment =paymentAssessmentService.findByDriverId(driverId);
			int paytype = paymentAssessment.getIfAssessment();  //是否通过
			String reason1 =paymentAssessment.getCauseAnalysis();  //原因
			String paymentDeadline  = paymentAssessment.getContractPaymentDeadline();  //承包金期限
			String serviceChargeDeadline =paymentAssessment.getServiceChargeDeadline();  //服务截止日期
			List<LinkedHashMap<String, Object>> list1 = new ArrayList<LinkedHashMap<String, Object>>();
			LinkedHashMap<String, Object> linkMoney =new LinkedHashMap<>();
			linkMoney.put("type",paytype);
			linkMoney.put("reason",reason1);
			linkMoney.put("paymentDeadline",paymentDeadline);
			linkMoney.put("serviceChargeDeadline",serviceChargeDeadline);
			list1.add(linkMoney);

			//考核培训
			TrainAssessment trainAssessment = trainAssessmentService.findByid(cmId);
			int traintype=trainAssessment.getIfTrain();  //是否通过考核
			String reason2 = trainAssessment.getCauseAnalysis(); //原因
			List<LinkedHashMap<String, Object>> list2 = new ArrayList<LinkedHashMap<String, Object>>();
			LinkedHashMap<String, Object> linkHe =new LinkedHashMap<>();
			linkHe.put("type",traintype);
			linkHe.put("reason",reason2);
			list2.add(linkHe);

			//车况照片信息
			List<VehicleMaintenance> vehicleMaintenances = vehicleMaintenanceService.getVehicleMaintenanceById(cmId);
			List<LinkedHashMap<String, Object>> list3 = new ArrayList<LinkedHashMap<String, Object>>();
			for(VehicleMaintenance vehic:vehicleMaintenances){
				if(vehic.getIfAssessment()==0){
					LinkedHashMap<String, Object> link =new LinkedHashMap<>();
					link.put("photoType",vehic.getPhototype());
					link.put("reason",vehic.getCause());
					list3.add(link);
				}
			}
			return add("10000", "成功","{\"money\""+":"+JSON.toJSONString(list1)+","
					+ "\"kaohe\""+":"+JSON.toJSONString(list2)+","
					+ "\"vehicle\""+":"+JSON.toJSONString(list3)+","
					+ "\"lanya\""+":"+JSON.toJSONString(list0)+"}");

		} catch (Exception e) {
			e.printStackTrace();
			return add("10003", "服务器异常", "{}");
		}

	}


	//测试用例
	@RequestMapping(value ="/test",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void aa() throws Exception{
		//List<LinkedHashMap<String, Object>>  objects = servive.findByCompreId("CC10000001");
		//System.out.println(objects.toString());
		//return JSON.toJSONString(objects);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMdd"); 
		String  d=format.format(date);
		//String pathString="D:\\Tomcat 7.0\\webapps\\EpeiBao\\fileupload\\"+d+"\\"+originalFilename;
		File mik  = new File("D:\\Tomcat 7.0\\webapps\\EpeiBao\\fileupload\\"+d+"\\"+"75120009201609011559313081381799A9");
		System.out.println(mik.getName());
		//如果文件不存在，则创建一个新文件夹
		if(!mik.exists() &&!mik.isDirectory()){
			mik.mkdirs();
		}
	}


}

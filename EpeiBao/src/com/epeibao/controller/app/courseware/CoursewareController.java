package com.epeibao.controller.app.courseware;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
















import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.epeibao.controller.BaseController;
import com.epeibao.controller.app.message.MessageManageController;
import com.epeibao.po.Answerstatusstatistical;
import com.epeibao.po.Coursewareinformation;
import com.epeibao.po.Questionmessage;
import com.epeibao.po.Trainmaterial;
import com.epeibao.service.AnswerstatusstatisticalService;
import com.epeibao.service.ComprehensiveAssessmentService;
import com.epeibao.service.CoursewareinformationService;
import com.epeibao.service.OrganizationMessageService;
import com.epeibao.service.QuestionmessageService;
import com.epeibao.service.QuestionsprojectService;
import com.epeibao.service.TestquestioninformationService;
import com.epeibao.service.TrainmaterialService;
import com.epeibao.util.PicUploadUtil;
/**
 * 试题管理
 * @author
 */
@Controller
@RequestMapping("Courseware")
public class CoursewareController extends BaseController{

	
	private static final long serialVersionUID = 1L;
	private static Logger LOGGER = Logger.getLogger(CoursewareController.class);
	
	@Autowired
	private AnswerstatusstatisticalService answerstatusstatisticalService;
	@Autowired
	private CoursewareinformationService coursewareinformationService;
	@Autowired
	private QuestionmessageService questionmessageService;
	@Autowired
	private TestquestioninformationService testquestioninformationService;
	@Autowired
	private QuestionsprojectService questionsprojectService;
	@Autowired
	private TrainmaterialService trainmaterialService;
	@Autowired
	private OrganizationMessageService organizationMessageService;
	@Autowired
	private ComprehensiveAssessmentService comprehensiveAssessmentService;
	
	//查找公司的培训材料
	@RequestMapping(value="/queryCoursewareInformation",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryCoursewareInformation(String  info){
		try {
			if(info!=null && !info.equals("")){
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String organizationid = param.getString("organizationid");
				if(!organizationid.equals("") && organizationid!=null){
					String organiz = organizationid.substring(0, 5);
					Trainmaterial trainmaterial =  trainmaterialService.findByOrganizationid(organiz);
					String [] coursewareid = trainmaterial.getCommonalitycoursewareid().split(",");
					String [] cid = trainmaterial.getCommonalitycoursewareid().split(",");
					LinkedList<Coursewareinformation> list = new LinkedList<Coursewareinformation>();
					for(int i = 0 ;i<coursewareid.length;i++){
						Coursewareinformation coursewareinformation=  coursewareinformationService.findByid(coursewareid[i]);
						list.add(coursewareinformation);
					}
					for(int i = 0 ;i<cid.length;i++){
						Coursewareinformation coursewareinformation=  coursewareinformationService.findByid(cid[i]);
						list.add(coursewareinformation);
					}
					
					return  add("10000", "成功", JSON.toJSONString(list,SerializerFeature.WriteMapNullValue));
				}
				
				return add("10001", "传入的数据不能为null", "{}");
			}
			
			return add("10002", "请传来json数据", "{}");
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
	
	//查看材料详细信息
	@RequestMapping(value="/queryCoursewareInfor",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryCoursewareInfor(String info , HttpServletRequest request){
		try {
			if(info!=null && !info.equals("")){
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String CoursewareId = param.getString("CoursewareId");
				if(CoursewareId!=null && !"".equals(CoursewareId)){
					Coursewareinformation coursewareinformation = coursewareinformationService.findByid(CoursewareId);
					//word 文档处理
					/*if(coursewareinformation.getCoursewaretype().equals("1")){
						String path = request.getServletContext().getRealPath("/");
						InputStream is = new FileInputStream(path+coursewareinformation.getCoursewarepath());  
					      WordExtractor extractor = new WordExtractor(is);  
					      //输出word文档所有的文本  
					      coursewareinformation.setNoteinfo(extractor.getText());
					}*/
					
					return  add("10000", "成功", JSON.toJSONString(coursewareinformation,SerializerFeature.WriteMapNullValue));
				}
				
				return add("10001", "传入的数据不能为null", "{}");
			}
				
				return add("10002", "请传来json数据", "{}");
			
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
	
	//现在出所有的考题
	@RequestMapping(value="/queryTestQuestionInformation",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String queryquestionmessage(String info){
		try {
			if(info!=null && !info.equals("")){
				JSONObject json = JSON.parseObject(info);
				String token = json.getString("token");
				String params = json.getString("params");
				JSONObject param = JSON.parseObject(params);
				String organizationid = param.getString("organizationid");
				String driverId = param.getString("driverId");
				//公共题库
				if(organizationid!=null && !"".equals(organizationid)){
						// 根据司机ID获取综合测评ID
						String comprehensiveassessmentId = comprehensiveAssessmentService
											.driverIdByComprehensiveAssessmentID(driverId);
					List<Answerstatusstatistical> anslist = answerstatusstatisticalService.findByState(comprehensiveassessmentId, 3);
						if(anslist.size()>0 && anslist!=null){
							return  add("10004", "正在审核", "{}");
						}
					List<Answerstatusstatistical> lists = answerstatusstatisticalService.findByState(comprehensiveassessmentId, 1);
					if(lists.size()>0 && lists!=null){
						return  add("10005", "审核通过", "{}");
					}
					String organiz = organizationid.substring(0, 5);
					Trainmaterial trainmaterial =  trainmaterialService.findByOrganizationid(organiz);
					List<Questionmessage> list = null;
					if(trainmaterial.getCommonalitycoursewareid()!=null && !trainmaterial.getCommonalitycoursewareid().equals("")){
						LinkedList<String> list1 = new LinkedList<String>();
						String [] coursewareid = trainmaterial.getCommonalitycoursewareid().split(",");
						for(int i = 0 ;i<coursewareid.length;i++){
							list1.add(coursewareid[i]);
						}
						
						list = questionmessageService.findRandomCommonQuestionmessage(organiz, list1);
					}
				//企业题库
					if(trainmaterial.getCompanycoursewareid()!=null && !trainmaterial.getCompanycoursewareid().equals("")){
						LinkedList<String> list2 = new LinkedList<String>();
						String [] cid = trainmaterial.getCompanycoursewareid().split(",");
						for(int i = 0 ;i<cid.length && cid.length>0;i++){
							list2.add(cid[i]);	
						}
						
						List<Questionmessage> list3 = questionmessageService.findRandomcompanyQuestionmessage(organiz, list2);
						for(int j = 0;j<list3.size() && list.size()>0;j++){
							list.add(list3.get(j));
						}
						
					}
	
					return  add("10000", "成功", JSON.toJSONString(list,SerializerFeature.WriteMapNullValue));
				}
			
			return add("10001", "传入的数据不能为null", "{}");
		}
			
			return add("10002", "请传来json数据", "{}");
			
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
	
	//添加答题情况
	@RequestMapping(value="/addAnswerStatusStatistical",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addAnswerStatusStatistical(@RequestParam("file") MultipartFile file,
			HttpServletRequest res,String driverId,String questionid,Byte ifquestionok){
		InputStream is = null;
		OutputStream os = null;
		try {
			// 根据司机ID获取综合测评ID
			String comprehensiveassessmentid = comprehensiveAssessmentService
						.driverIdByComprehensiveAssessmentID(driverId);
			// 指定文件存放的位置
			String path = res.getRealPath("/fileupload/vedio");
			File dir = new File(path);
			if (!dir.exists()) {
					dir.mkdirs();
			}

			String originalFilename = file.getOriginalFilename();
			// 截取文件扩名
			String exName= (originalFilename.substring(
					(originalFilename.length()-2),
			originalFilename.length())).toUpperCase();
			String name=driverId+String.valueOf(System.currentTimeMillis())+ originalFilename;
			is = file.getInputStream();
			os = new FileOutputStream(new File(path, name));
			int len = 0;
			byte[] buffer = new byte[1024*1024];
			while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
			}
			//判断答题是否正确
			Answerstatusstatistical answerstatusstatistical = new Answerstatusstatistical();
			answerstatusstatistical.setAnswerstatusstatisticalid(UUID.randomUUID().toString());
			answerstatusstatistical.setQuestionid(questionid);
			answerstatusstatistical.setIfquestionok(ifquestionok);
			answerstatusstatistical.setComprehensiveassessmentid(comprehensiveassessmentid);
			answerstatusstatistical.setVediopath(path+name);
				
			
			Questionmessage questionmessage = questionmessageService.findById(questionid);
				
			answerstatusstatisticalService.saveAnswerstatusstatistical(answerstatusstatistical);
			return  add("10000", "成功", "{}");

			
		} catch (Exception e) {
			LOGGER.error(e);
			return add("10003", "服务器异常", "{}");
		}
	}
		//添加答题情况
		@RequestMapping(value="/insertAnswerStatusStatistical",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String insertAnswerStatusStatistical(String picName, String picText,
				HttpServletRequest res,String driverId,String questionid,Byte ifquestionok){
			try {
				Answerstatusstatistical answerstatusstatistical = new Answerstatusstatistical();
				// 根据司机ID获取综合测评ID
				String comprehensiveassessmentId = comprehensiveAssessmentService
									.driverIdByComprehensiveAssessmentID(driverId);
				// 图片在服务器上存放的文件夹
				String dir = File.separator + "fileupload" + File.separator+"vedio"+File.separator
							+comprehensiveassessmentId;
				// 图片在服务器上的绝对路径
				String path = res.getServletContext().getRealPath(dir);

				// 创建保存图片的文件夹，按年月命名
				if (!StringUtils.isBlank(picName) && !StringUtils.isBlank(picText)
									&& picName.indexOf(".") != -1) {
				// 图片名称：拆分名称与扩展名后加当前时间
				String name = picName.substring(0, picName.lastIndexOf("."))
							+ System.currentTimeMillis()
							+ picName.substring(picName.lastIndexOf("."));
				// 保存图片
				PicUploadUtil.saveOrUpdatePictrue(picText, path, name);
				// 图片在服务器端的地址
				String photoData = dir + File.separator + name;
				
				answerstatusstatistical.setVediopath(photoData);
				}
				//判断答题是否正确
				
				answerstatusstatistical.setAnswerstatusstatisticalid(UUID.randomUUID().toString());
				answerstatusstatistical.setQuestionid(questionid);
				answerstatusstatistical.setIfquestionok(ifquestionok);
				answerstatusstatistical.setComprehensiveassessmentid(comprehensiveassessmentId);
				
					
				
				Questionmessage questionmessage = questionmessageService.findById(questionid);
					
				answerstatusstatisticalService.saveAnswerstatusstatistical(answerstatusstatistical);
				return  add("10000", "成功", "{}");

				} catch (Exception e) {
				LOGGER.error(e);
				e.printStackTrace();
				return add("10003", "服务器异常", "{}");
			}
		}
	
	
}

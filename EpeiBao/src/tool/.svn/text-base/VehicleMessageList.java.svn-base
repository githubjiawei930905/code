package tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.epeibao.po.OperatingData;

public class VehicleMessageList {

	public List<OperatingData> addOperatingData(List<String> list) {
		List<OperatingData> li=new ArrayList<OperatingData>();
		for (int i = 0; i <list.size(); i++) {
			OperatingData od=new  OperatingData();
			od.setIfSuccessCollection(1);
			String meg=list.get(i);
			if(meg!=null){
				String str=meg.substring(4,meg.length()-4);    //截掉前后各四位的新字符串
				String str1=str.substring(0, 8);   // 	司机标志号 
				String str2=str.substring(8,10);   // 上车天数
				String str3=str.substring(10,16);  //交易日期
				String str4=str.substring(16,22);  //上车时间  ---------
				String str4_1=str4.substring(0,2);
				String str4_2=str4.substring(2,4);
				String str4_3=str4.substring(4,6);
				/*
				 * 上车时间
				 */
				od.setBoardingTime(str4_1+":"+str4_2+":"+str4_3);
				String str5=str.substring(22,28);  //下车时间  --------
				String str5_1=str5.substring(0,2);
				String str5_2=str5.substring(2,4);
				String str5_3=str5.substring(4,6);
				/*
				 * 下车时间
				 */
				od.setAlightingTime(str5_1+":"+str5_2+":"+str5_3);
				String str6=str.substring(28,36);  //用户卡内部序列号  
				String str7=str.substring(36,48);  // 用户卡发行号 
				String str8=str.substring(48,52);  //行驶里程  ---------
				String str8_1=str8.substring(0,2);
				String str8_2=str8.substring(2,4);
				String str8_= (str8_2+str8_1);
				int travlledDistance = Integer.parseInt(str8_, 16); 
				/*
				 * 行驶里程
				 */
				od.setTravlledDistance(travlledDistance);
				String str9=str.substring(52,56);  //等候时间  ---------
				String str9_1=str9.substring(0,2);
				String str9_2=str9.substring(2,4);
				/*
				 * 等候时间 
				 */
				od.setWaitTime(str9_1+":"+str9_2);
				String str10=str.substring(56,60);  //空驶里程 --------
				String str10_1=str10.substring(0,2);
				String str10_2=str10.substring(2,4);
				String str10_= (str10_2+str10_1);
				int deadheadKilometres = Integer.parseInt(str10_, 16); 
				/*
				 * 空驶里程
				 */
				od.setDeadheadKilometres(deadheadKilometres);
				String str11=str.substring(60,62);  //交易类型  --------
				int type=Integer.parseInt(str11, 16);
				/*
				 * 交易类型 
				 */
				od.setDealtype(type);  
				String str12=str.substring(62,68);  //应收金额 --------
				String str12_1=str12.substring(0,2);
				String str12_2=str12.substring(2,4);
				String str12_3=str12.substring(4,6);
				int i1=Integer.parseInt(str12_1);
				int i2=Integer.parseInt(str12_2);
				int i3=Integer.parseInt(str12_3);
				int[] ii={i1,i2,i3};
				String  st12="";
				Arrays.sort(ii);
				for (int j = 0; j < ii.length; j++) {
					if(ii[j]<10){
						st12+="0"+ii[j];
					}else{
						st12+=ii[j];
					}
				}
				int amountReceivable=Integer.parseInt(st12, 16); 
				/*
				 * 应收金额        
				 */
				od.setAmountReceivable(amountReceivable);
				//String str13=str.substring(68,74);  //实收金额   
				//String str14=str.substring(74,82);  //卡内余额
				//String str15=str.substring(82,84);  //物理卡类型
				//String str16=str.substring(84,86); //卡类型1  
				//String str17=str.substring(86,90);  //用户卡交易次数
				//String str18=str.substring(90,94);  // 终端交易计数
				//String str19=str.substring(94,106);  //PSAM卡号1    
				//String str20=str.substring(106,114);  // 交易认证码
			}	
			li.add(od);

		}
		return li;
	}

}

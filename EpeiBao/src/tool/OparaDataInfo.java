package tool;

import com.epeibao.po.OperatingData;



public class OparaDataInfo {

	/**
	 * 返回一个实体类ID，是否采集成功为null
	 * @param strs为A9类型
	 * @return
	 */
	//传过来的为个性化得一段（0——88位）  
	public OperatingData infoA9(String strs){   
		OperatingData operatingData=new OperatingData();
		if(strs.length()==120){
			/*包体
		09   交易类型
		A4060000   交易金额
		20160528   交易日期
		011800     交易时间
		01000000  记录序号*/

			//体部分
			String ti=strs.substring(0,32);
			String date1=ti.substring(10, 18);
			String date=date1.substring(0,4)+"-"+date1.substring(4,6)+"-"+date1.substring(6,8);
			String datetime=strs.substring(18,24);
			String time=datetime.substring(0,2)+":"+datetime.substring(2,4)+":"+datetime.substring(4,6);
			operatingData.setAlightingTime(date+" "+time);   // 下车时间
			//----------------
			operatingData.setDealtype(EncodingUtils.hexStringToInt(ti.substring(0,2)));  //交易类型
			//----------------------

			//个性化部分
			String str=strs.substring(32,strs.length());

			String amountReceivable=str.substring(0,8);   //78050000   ------应收金额
			String money=amountReceivable.substring(4, 6)+amountReceivable.substring(2, 4)+amountReceivable.substring(0,2);
			int money1= EncodingUtils.hexStringToInt(money);
			operatingData.setAmountReceivable(money1);    
			//---------------------

			String wait =   str.substring(8,12);   //0000       ------等候时间
			operatingData.setWaitTime(wait.substring(0,2)+":"+wait.substring(2,4));
			//-------------------

			String travlledDistance =   str.substring(12,16);   //0000       ------行驶里程
			int travlledDistance1= EncodingUtils.hexStringToInt(travlledDistance.substring(2, 4)+travlledDistance.substring(0,2));
			operatingData.setTravlledDistance(travlledDistance1);  
			//-----------------------

			String deadheadKilometres =  str.substring(16,20);   	//0000      -------空驶里程
			int deadheadKilometres1= EncodingUtils.hexStringToInt(deadheadKilometres.substring(2, 4)+deadheadKilometres.substring(0,2));
			operatingData.setTravlledDistance(deadheadKilometres1);  
			//-----------------------

			String biaoZhiHao =   str.substring(20,28);	//C7353A42   -------司机标志
			String day =   str.substring(28,30);	//00        -------上车天数   
			String boardingTime =   str.substring(30,36);	//005600    -------上车时间
			operatingData.setBoardingTime(date+" "+boardingTime.substring(0,2)+":"+boardingTime.substring(2,4)+":"+boardingTime.substring(4,6)); //----------
			//--------------------
			String busNumber =  EncodingUtils.asciiTo2String(str.substring(36,54)).trim() ; 	//202020414231323334    ----车牌号
			operatingData.setBusNumber(busNumber);
			//------------------
			String identity =   str.substring(54,66);	//000000111111      --------证号
			String priceStr =   str.substring(66,70);	//E600      --------单价
			String duiNo1 =   str.substring(70,78);	//34000003   ----------车队标号
			String no1 =   str.substring(78,86);	//00005498    ---------采集员编号
			String atc =   str.substring(86,88);	//00        ---------ATC版本
		}
		return operatingData;
		/*select ComprehensiveAssessmentID,BusNumber,BoardingTime,AlightingTime,TravlledDistance,WaitTime,DeadheadKilometres,dealtype,AmountReceivable,IfSuccessCollection from OperatingData   ---车辆运营数据
--id、车牌号、上车时间、下车时间、行驶里程、等候时间、空驶里程、交易类型、应收金额、是否采集成功  （0--未采集  1--已采集 2--已采集、不完全 
		 */
	}

	/**
	 * 返回一个实体类ID，是否采集成功为null
	 * @param strs为A2类型
	 * @return
	 */
	//传过来的为个性化得一段（0——88位）  
	public OperatingData infoA2(String strs){   
		OperatingData operatingData=new OperatingData();
		if(strs.length()==196){
			/*06  --交易类型  2
			010203040506   12
			A4060000    交易金额 8
			04050000  8
			C8190000  8
			20160528    交易日期8
			012000      交易时间*/
			//体部分
			String ti=strs.substring(0,108);
			String date1=ti.substring(38, 46);
			String date=date1.substring(0,4)+"-"+date1.substring(4,6)+"-"+date1.substring(6,8);
			String datetime=strs.substring(46,52);
			String time=datetime.substring(0,2)+":"+datetime.substring(2,4)+":"+datetime.substring(4,6);
			operatingData.setAlightingTime(date+" "+time);   // 下车时间
			//----------------
			operatingData.setDealtype(EncodingUtils.hexStringToInt(ti.substring(0,2)));  //交易类型
			//----------------------

			//个性化部分
			String str=strs.substring(108,strs.length());

			String amountReceivable=str.substring(0,8);   //78050000   ------应收金额
			String money=amountReceivable.substring(4, 6)+amountReceivable.substring(2, 4)+amountReceivable.substring(0,2);
			int money1= EncodingUtils.hexStringToInt(money);
			operatingData.setAmountReceivable(money1);    
			//---------------------

			String wait =   str.substring(8,12);   //0000       ------等候时间
			operatingData.setWaitTime(wait.substring(0,2)+":"+wait.substring(2,4));
			//-------------------

			String travlledDistance =   str.substring(12,16);   //0000       ------行驶里程
			int travlledDistance1= EncodingUtils.hexStringToInt(travlledDistance.substring(2, 4)+travlledDistance.substring(0,2));
			operatingData.setTravlledDistance(travlledDistance1);  
			//-----------------------

			String deadheadKilometres =  str.substring(16,20);   	//0000      -------空驶里程
			int deadheadKilometres1= EncodingUtils.hexStringToInt(deadheadKilometres.substring(2, 4)+deadheadKilometres.substring(0,2));
			operatingData.setTravlledDistance(deadheadKilometres1);  
			//-----------------------

			String biaoZhiHao =   str.substring(20,28);	//C7353A42   -------司机标志
			String day =   str.substring(28,30);	//00        -------上车天数   
			String boardingTime =   str.substring(30,36);	//005600    -------上车时间
			operatingData.setBoardingTime(date+" "+boardingTime.substring(0,2)+":"+boardingTime.substring(2,4)+":"+boardingTime.substring(4,6)); //----------
			//--------------------
			String busNumber =  EncodingUtils.asciiTo2String(str.substring(36,54)).trim() ; 	//202020414231323334    ----车牌号
			operatingData.setBusNumber(busNumber);
			//------------------
			String identity =   str.substring(54,66);	//000000111111      --------证号
			String priceStr =   str.substring(66,70);	//E600      --------单价
			String duiNo1 =   str.substring(70,78);	//34000003   ----------车队标号
			String no1 =   str.substring(78,86);	//00005498    ---------采集员编号
			String atc =   str.substring(86,88);	//00        ---------ATC版本
		}
		return operatingData;
	}

}

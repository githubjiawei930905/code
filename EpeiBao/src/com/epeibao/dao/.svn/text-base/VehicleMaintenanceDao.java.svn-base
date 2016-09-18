package com.epeibao.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.epeibao.po.VehicleMaintenance;

public interface VehicleMaintenanceDao {
	/**
	 * 添加照片信息
	 * 
	 * @param maintenance
	 */
	void insertVehicleMaintenance(VehicleMaintenance maintenance)
			throws Exception;

	/**
	 * 删除照片信息
	 */
	void deleteVehicleMaintenance(String Id) throws Exception;

	/**
	 * 修改照片信息
	 */
	void updateVehicleMaintenance(VehicleMaintenance maintenance)
			throws Exception;

	/**
	 * 根据Id查询照片信息
	 */
	List<VehicleMaintenance> getVehicleMaintenanceById(String id)
			throws Exception;

	/**
	 * 返回特定位置的图片
	 * 
	 * @param id
	 *            司机Id
	 * @param type
	 *            图片类型
	 * @return
	 */
	VehicleMaintenance getoneVeMaintenance(@Param("id") String id,
			@Param("type") String type) throws Exception;

	/**
	 * 根据综合测评ID查询批次照片
	 * 
	 * @param ComprehensiveAssessmentID
	 * @return
	 */
	List<LinkedHashMap<String, String>> getVeMaintenanceByComprehensiveAssessmentID(
			String ComprehensiveAssessmentID) throws Exception;

	/**
	 * 根据车牌号和批次ID查询批次照片
	 * 
	 * @param ComprehensiveAssessmentID
	 * @return
	 */
	List<LinkedHashMap<String, String>> getVeMaintenanceByBusNumber(
			@Param("comprehensiveAssessmentID") String comprehensiveAssessmentID,
			@Param("busNumber") String busNumber)
			throws Exception;

	/**
	 * 根据批次号和照片类型查询图片的审核状态（已通过的禁止重复上传，未通过的删除已上传，接受新图片）
	 * 
	 * @param comprehensiveAssessmentID
	 * @param photoType
	 * @return
	 */
	int getVeMaintenanceForIfAssessment(
			@Param("comprehensiveAssessmentID") String comprehensiveAssessmentID,
			@Param("photoType") int photoType);

}

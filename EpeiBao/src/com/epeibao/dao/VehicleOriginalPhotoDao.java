package com.epeibao.dao;


import java.util.LinkedHashMap;
import java.util.List;

import com.epeibao.po.VehicleOriginalPhoto;

public interface VehicleOriginalPhotoDao {
	/**
	 * 添加车辆基本图片
	 * 
	 * @param vehicleOriginalPhoto
	 */
	void insertVehicleOriginalPhoto(VehicleOriginalPhoto vehicleOriginalPhoto);

	/**
	 * 删除车辆基本图片
	 * 
	 * @param vehicleOriginalPhoto
	 */
	void deleteVehicleOriginalPhoto(int vehicleOriginalPhotoId);

	/**
	 * 修改车辆基本图片
	 * 
	 * @param vehicleOriginalPhoto
	 */
	void updateVehicleOriginalPhoto(VehicleOriginalPhoto vehicleOriginalPhoto);

	/**
	 * 根据车牌返回照片数量(集合长度)及类型
	 * 
	 * @param busNumber
	 * @return
	 */
	List<LinkedHashMap<String, String>> getPhotoType(String busNumber);

	/**
	 * 返回批次Id最大值
	 * 
	 * @return
	 */
	int getMaxBatchId();
}

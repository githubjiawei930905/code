package com.epeibao.dao;

import java.util.List;

import com.epeibao.po.Questionsproject;

public interface QuestionsprojectDao {
	/**
	 * 添加培训方案
	 * @throws Exception
	 */
    void insertQuestinsProject(Questionsproject questionsproject)throws Exception;
    /**
     * 修改培训方案
     * @param questionsproject
     * @throws Exception
     */
    void updateQuestinsProject(Questionsproject questionsproject)throws Exception;
    /**
     * 删除消息
     * @param questinsProjectid
     * @throws Exception
     */
    void deleteQuestinsProject(String questinsProjectid)throws Exception;
    /**
     * 查找消息方案
     * @param questinsProjectid
     * @return
     * @throws Exception
     */
    Questionsproject findByid(String questinsProjectid)throws Exception;
    /**
     * 查找这个公司的所有方案
     * @param organizationid
     * @return
     * @throws Exception
     */
    List<Questionsproject> findByorganizationid(String organizationid)throws Exception;

}
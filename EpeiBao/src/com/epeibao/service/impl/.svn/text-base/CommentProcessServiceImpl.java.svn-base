package com.epeibao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epeibao.dao.CommentprocessDao;
import com.epeibao.po.Commentprocess;
import com.epeibao.service.CommentProcessService;
@Service
public class CommentProcessServiceImpl implements CommentProcessService{

	
	@Autowired
	private CommentprocessDao dao;
	@Override
	public void saveCommentprocess(Commentprocess commentprocess)
			throws Exception {
		dao.insertCommentprocess(commentprocess);
	}

	@Override
	public void updataCommentprocess(Commentprocess commentprocess)
			throws Exception {
		dao.updataCommentprocess(commentprocess);
		
	}

	@Override
	public void deleteCommentprocess(String CommentProcessId) throws Exception {
		dao.deleteCommentprocess(CommentProcessId);
	}

	@Override
	public Commentprocess findById(String CommentProcessId) throws Exception {
		
		return dao.findById(CommentProcessId);
	}

}

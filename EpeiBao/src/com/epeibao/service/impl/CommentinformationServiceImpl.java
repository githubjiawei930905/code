package com.epeibao.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.epeibao.dao.CommentinformationDao;
import com.epeibao.dao.CommentprocessDao;
import com.epeibao.po.Commentinformation;
import com.epeibao.po.Commentprocess;
import com.epeibao.service.CommentinformationService;
@Service
public class CommentinformationServiceImpl implements CommentinformationService{

	@Autowired
	private CommentinformationDao dao;
	@Autowired
	private CommentprocessDao dao1;
	@Override
	public void saveCommentinformation(Commentinformation commentinformation)
			throws Exception {
		dao.insertCommentinformation(commentinformation);
		Commentprocess commentprocess = new Commentprocess();
		commentprocess.setCommentid(commentinformation.getCommentid());
		commentprocess.setCommentprocessid(UUID.randomUUID().toString());
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		String time = smp.format(new Date());
		commentprocess.setCommentprocesstime(smp.parse(time));
		commentprocess.setUserid(commentinformation.getUserid());
		commentprocess.setOperatetype((byte)0);
		dao1.insertCommentprocess(commentprocess);
	}

	@Override
	public void updateCommentinformation(Commentinformation commentinformation)
			throws Exception {
		dao.updateCommentinformation(commentinformation);
	}

	@Override
	public void deleteCommentinformation(String commentid) throws Exception {
		dao.deleteCommentinformation(commentid);
		
	}

	@Override
	public Commentinformation findById(String commentid) throws Exception {
		
		return dao.findById(commentid);
	}

	@Override
	public List<LinkedHashMap<String, String>> findByMessageId(String messageid,Integer page)
			throws Exception {
		
		return dao.findByMessageId(messageid,page);
	}

	@Override
	public List<LinkedHashMap<String, String>> findByAll(String messageid,
			Integer page) throws Exception {
		
		return dao.findByAll(messageid, page);
	}

	@Override
	public int findByAllCount(String MessageId) throws Exception {
		
		return dao.findByAllCount(MessageId);
	}

	
}

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.utils;

import java.util.ArrayList;
import java.util.List;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessDao;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessLinkDao;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessNodeDao;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcess;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessLink;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;

/**
 * 流程节点工具类
 * @author Tom
 * @version 2013-5-29
 */
public class ProcessUtils {
	
	private static ZProcessNodeDao zProcessNodeDao = SpringContextHolder.getBean(ZProcessNodeDao.class);

	private static ZProcessDao zProcessDao = SpringContextHolder.getBean(ZProcessDao.class);
	
	private static ZProcessLinkDao zProcessLinkDao = SpringContextHolder.getBean(ZProcessLinkDao.class);
	
	public static List<ZProcessNode> getZProcessNodeList(){
		List<ZProcessNode> list = new ArrayList<ZProcessNode>();
		ZProcessNode node = new ZProcessNode();
		node.setDelFlag("0");
		list = zProcessNodeDao.findAllList(node);
		return list;
	}
	public static List<ZProcessNode> getNextStepList(String processId, String NodeId){
		List<ZProcessNode> list = new ArrayList<ZProcessNode>();
		ZProcessLink zProcessLink = new ZProcessLink();
		zProcessLink.setDelFlag("0");
		zProcessLink.setProcessId(processId);
		zProcessLink.setStartNode(NodeId);
		List<ZProcessLink> linkList = zProcessLinkDao.findList(zProcessLink);
		List<String> nextStepIdList = new ArrayList<String>();
		for(ZProcessLink item: linkList) {
			nextStepIdList.add(item.getEndNode());
		}
		if(nextStepIdList!=null && !nextStepIdList.isEmpty()) {
			list.addAll(zProcessNodeDao.findListByIds((String[])nextStepIdList.toArray(new String[nextStepIdList.size()])));
		}
		return list;
	}
	
	public static ZProcessNode getZProcessNode(String id) {
		ZProcessNode node = new ZProcessNode();
		node = zProcessNodeDao.get(id);
		return node;
	}
	
	public static String getZprocessNodeLabel(String id) {
		ZProcessNode node = getZProcessNode(id);
		if(node==null) {
			node = new ZProcessNode();
		}
		return node.getName();
	}
	
	public static List<ZProcess> getZProcessList(){
		List<ZProcess> list = new ArrayList<ZProcess>();
		ZProcess entity = new ZProcess();
		entity.setDelFlag("0");
		list = zProcessDao.findAllList(entity);
		return list;
	}
	
	public static ZProcess getZProcess(String id) {
		ZProcess process = zProcessDao.get(id);
		if(null==process) {
			process  = new ZProcess();
		}
		return process;
	}
	
	public static String getZProcessLabel(String id) {
		ZProcess process =getZProcess(id);
		return process.getLabel();
	}
	
}

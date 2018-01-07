/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessNode;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessNodeDao;

/**
 * 流程节点管理Service
 * @author tom
 * @version 2018-01-07
 */
@Service
@Transactional(readOnly = true)
public class ZProcessNodeService extends CrudService<ZProcessNodeDao, ZProcessNode> {

	public ZProcessNode get(String id) {
		return super.get(id);
	}
	
	public List<ZProcessNode> findList(ZProcessNode zProcessNode) {
		return super.findList(zProcessNode);
	}
	
	public Page<ZProcessNode> findPage(Page<ZProcessNode> page, ZProcessNode zProcessNode) {
		return super.findPage(page, zProcessNode);
	}
	
	public List<ZProcessNode> findAllNodeList(String[] ids){
		return dao.findListByIds(ids);
	}
	
	@Transactional(readOnly = false)
	public void save(ZProcessNode zProcessNode) {
		super.save(zProcessNode);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZProcessNode zProcessNode) {
		super.delete(zProcessNode);
	}
	
}
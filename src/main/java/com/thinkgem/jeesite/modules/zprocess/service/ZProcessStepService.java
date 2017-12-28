/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcessStep;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessStepDao;

/**
 * 流程操作节点记录Service
 * @author tom
 * @version 2017-12-24
 */
@Service
@Transactional(readOnly = true)
public class ZProcessStepService extends CrudService<ZProcessStepDao, ZProcessStep> {

	public ZProcessStep get(String id) {
		return super.get(id);
	}
	
	public List<ZProcessStep> findList(ZProcessStep zProcessStep) {
		return super.findList(zProcessStep);
	}
	
	public Page<ZProcessStep> findPage(Page<ZProcessStep> page, ZProcessStep zProcessStep) {
		return super.findPage(page, zProcessStep);
	}
	
	@Transactional(readOnly = false)
	public void save(ZProcessStep zProcessStep) {
		super.save(zProcessStep);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZProcessStep zProcessStep) {
		super.delete(zProcessStep);
	}
	
}
/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zprocess.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zprocess.entity.ZProcess;
import com.thinkgem.jeesite.modules.zprocess.dao.ZProcessDao;

/**
 * 流程管理Service
 * @author tom
 * @version 2017-12-24
 */
@Service
@Transactional(readOnly = true)
public class ZProcessService extends CrudService<ZProcessDao, ZProcess> {

	public ZProcess get(String id) {
		return super.get(id);
	}
	
	public List<ZProcess> findList(ZProcess zProcess) {
		return super.findList(zProcess);
	}
	
	public Page<ZProcess> findPage(Page<ZProcess> page, ZProcess zProcess) {
		return super.findPage(page, zProcess);
	}
	
	@Transactional(readOnly = false)
	public void save(ZProcess zProcess) {
		super.save(zProcess);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZProcess zProcess) {
		super.delete(zProcess);
	}
	
}
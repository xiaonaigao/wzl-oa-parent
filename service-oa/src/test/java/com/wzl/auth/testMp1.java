package com.wzl.auth;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzl.auth.mapper.SysRoleMapper;
import com.wzl.auth.service.SysRoleService;
import com.wzl.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wang
 * @version 1.0
 */
@SpringBootTest
public class testMp1 {
	@Autowired
	private SysRoleService sysRoleService;

	@Test
	public void getAll(){
		List<SysRole> list = sysRoleService.list();
		System.out.println(list);
	}
}








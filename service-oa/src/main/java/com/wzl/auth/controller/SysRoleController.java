package com.wzl.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wzl.auth.service.SysRoleService;
import com.wzl.common.result.Result;
import com.wzl.model.system.SysRole;
import com.wzl.vo.system.SysRoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理
 */
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
	//注入SysRoleService
	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 1.查询：所有角色
	 * http://localhost:8800/admin/system/sysRole/findAll
	 */
	@ApiOperation(("查询所有角色"))
	@GetMapping("/findAll")
	public Result findAll() {
		List<SysRole> list = sysRoleService.list();
		return Result.ok(list);
	}

	/**
	 * 2.分页：条件分页查询
	 * page：当前页
	 * limit:每页显示的记录数
	 */
	@ApiOperation("条件分页查询")
	@GetMapping("{page}/{limit}")
	public Result pageQueryRole(@PathVariable Long page, @PathVariable Long limit, SysRoleQueryVo sysRoleQueryVo) {
		// 1.创建Page对象，传递分页的相关参数page是当前页，limit是显示的数量
		Page<SysRole> pageParam = new Page<>(page,limit);
		// 2.封装条件，判断条件是否为空。
		LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
		String roleName = sysRoleQueryVo.getRoleName();
		if (!StringUtils.isEmpty(roleName)){
			// 封装 模糊
			wrapper.like(SysRole::getRoleName, roleName);
		}
		// 3.调用方法实现
		IPage<SysRole> pageModel = sysRoleService.page(pageParam, wrapper);
		return Result.ok(pageModel);
	}

	/**
	 * 3.添加：添加角色
	 */
	@ApiOperation("添加角色")
	@PostMapping("/save")
	public Result save(@RequestBody SysRole sysRole){
		// 调用service方法添加
		boolean is_success = sysRoleService.save(sysRole);
		if (is_success){
			return Result.ok();
		}else {
			return Result.fail();
		}
	}

	/**
	 * 4.修改：1.根据id查询
	 */
	@ApiOperation("根据id查询")
	@GetMapping("/get/{id}")
	public Result get(@PathVariable Long id){
		SysRole sysRole = sysRoleService.getById(id);
		return Result.ok(sysRole);
	}

	/**
	 * 修改：2.最终修改
	 */
	@ApiOperation("修改角色")
	@PostMapping("/update")
	public Result update(@RequestBody SysRole sysRole){
		// 调用service方法添加
		boolean is_success = sysRoleService.updateById(sysRole);
		if (is_success){
			return Result.ok();
		}else {
			return Result.fail();
		}
	}
	/**
	 * 5.删除:1根据id
	 */
	@ApiOperation("根据id删除")
	@DeleteMapping("/remove/{id}")
	public Result remove(@PathVariable Long id){
		boolean is_success = sysRoleService.removeById(id);
		if (is_success){
			return Result.ok();
		}else {
			return Result.fail();
		}
	}

	/**
	 * 5.删除:2批量删除
	 * [1,2,3]
	 */
	@ApiOperation("批量删除")
	@DeleteMapping("/batchRemove")
	public Result batchRemove(@RequestBody List<Long> idList){
		boolean is_success = sysRoleService.removeByIds(idList);
		if (is_success){
			return Result.ok();
		}else {
			return Result.fail();
		}
	}

}


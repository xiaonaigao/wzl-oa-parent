package com.wzl.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wzl.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wang
 * @version 1.0
 */
@Repository
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
}

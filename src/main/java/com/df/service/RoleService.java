package com.df.service;

import java.util.List;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/18 - 14:54
 */
public interface RoleService {

    List<String> findRolesByUserId(Long userId);
}

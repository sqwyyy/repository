package com.Controller;



import com.pojo.Role;
import com.result.Result;
import com.result.ResultFactory;
import com.service.PermissionService;
import com.service.RoleMenuService;
import com.service.RolePermissionService;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @date 2020/7/14 - 21:56
 */
@CrossOrigin
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    RoleMenuService roleMenuService;

    @Autowired
    RolePermissionService rolePermissionService;



    @GetMapping("/api/admin/role")
    public Result listRoles() {
        return ResultFactory.buildSuccessResult(roleService.listWithPermsAndMenus());
    }

    @PutMapping("/api/admin/role")
    public Result editRole(@RequestBody Role requestRole) {
        roleService.UpdateRole(requestRole);
        rolePermissionService.savePermChanges(requestRole.getId(), requestRole.getPerms());
        String message = "修改角色信息成功";
        return ResultFactory.buildSuccessResult(message);
    }

    @PostMapping("/api/admin/role")
    public Result addRole(@RequestBody Role requestRole) {
        roleService.addorupdate(requestRole);
        String message = "添加用户成功";
        return ResultFactory.buildSuccessResult(message);
    }


    @GetMapping("/api/admin/role/perm")
    public Result listPerms() {
        return ResultFactory.buildSuccessResult(permissionService.listall());
    }

    @PutMapping("/api/admin/role/menu")
    public Result updateRoleMenu(@RequestParam int rid, @RequestBody Map<String, List<Integer>> menusIds) {
        roleMenuService.updateRoleMenu(rid, menusIds);
        return ResultFactory.buildSuccessResult("更新成功");
    }



}

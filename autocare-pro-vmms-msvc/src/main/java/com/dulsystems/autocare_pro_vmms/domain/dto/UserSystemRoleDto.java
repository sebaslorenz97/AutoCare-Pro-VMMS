package com.dulsystems.autocare_pro_vmms.domain.dto;

public record UserSystemRoleDto(
        //REQUEST FIELDS FOR INNER OPERATIONS WITH USERS ROLE
        String systemRoleId,
        String systemRoleAssignedAt,
        String usernameId
) {}

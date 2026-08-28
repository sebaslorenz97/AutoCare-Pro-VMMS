package com.dulsystems.autocare_pro_vmms.domain.dto;

public record UserDto(
        //REQUEST FIELDS FOR LOGIN & USER
        String usernameId,
        String userPassword,
        //REQUEST FIELDS FOR USER
        String userFullName,
        String userMecId,
        String userEnterpriseRole,
        String userEmail,
        Boolean userIsLocked,
        Boolean userIsDisabled,

        //REQUEST FIELDS FOR INNER OPERATIONS WITH USERS ROLE
        String userSystemRole,
        String userSystemRoleAssignedAt
) {}

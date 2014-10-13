package co.fingerprintsoft.spring.data;

import org.springframework.security.acls.AclPermissionEvaluator;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.core.Authentication;

public class CustomAclPermissionEvaluator extends org.springframework.security.acls.AclPermissionEvaluator {


    public CustomAclPermissionEvaluator(AclService aclService) {
        super(aclService);
    }

    public boolean hasPermission(Authentication authentication, Object domainObject, Object permission) {
        return domainObject == null || super.hasPermission(authentication, domainObject, permission);
    }

}

package co.fingerprintsoft.spring.data;

import java.util.Collection;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.acls.domain.AclAuthorizationStrategyImpl;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomAuthorizationStrategyImpl extends AclAuthorizationStrategyImpl {

    private GrantedAuthority[] grantedAuthorities;

    public CustomAuthorizationStrategyImpl(GrantedAuthority... auths) {
        super(auths);
        grantedAuthorities = auths;
    }

    public void securityCheck(Acl acl, int changeType) {
        try {
            super.securityCheck(acl, changeType);
        } catch (AccessDeniedException ace) {
            SecurityContext context = SecurityContextHolder.getContext();

            if (context != null) {
                Authentication authentication = context.getAuthentication();
                if (authentication != null) {
                    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                    if (authorities != null && !authorities.isEmpty()) {
                        if (grantedAuthorities != null && grantedAuthorities.length > 0) {

                            for (GrantedAuthority authority : grantedAuthorities) {
                                if (authorities.contains(authority)) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            throw new AccessDeniedException(
                    "Principal does not have required ACL permissions to perform requested operation");
        }
    }
}

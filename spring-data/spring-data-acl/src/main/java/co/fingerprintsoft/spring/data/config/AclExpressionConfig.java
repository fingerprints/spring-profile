package co.fingerprintsoft.spring.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.acls.AclPermissionCacheOptimizer;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import co.fingerprintsoft.spring.data.CustomAclPermissionEvaluator;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class AclExpressionConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    DefaultMethodSecurityExpressionHandler expressionHandler;

    @Autowired
    AclService aclService;

    @Bean
    public DefaultMethodSecurityExpressionHandler expressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(permissionEvaluator());
        expressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclService));
        return expressionHandler;
    }

    @Bean
    public org.springframework.security.acls.AclPermissionEvaluator permissionEvaluator() {
        return new CustomAclPermissionEvaluator(aclService);
    }

    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return expressionHandler;
    }

}

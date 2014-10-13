package co.fingerprintsoft.spring.data.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.acls.domain.AclAuthorizationStrategy;
import org.springframework.security.acls.domain.ConsoleAuditLogger;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import co.fingerprintsoft.spring.data.CustomAuthorizationStrategyImpl;

@Configuration
public class ACLStrategyConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EhCacheBasedAclCache aclCache;

    @Bean
    public BasicLookupStrategy lookupStrategy() {
        return new BasicLookupStrategy(dataSource, aclCache, grantingStrategy(), new ConsoleAuditLogger());
    }

    @Bean
    public AclAuthorizationStrategy grantingStrategy() {
        return new CustomAuthorizationStrategyImpl(new SimpleGrantedAuthority("ADD_APPLICATION"));
    }

}

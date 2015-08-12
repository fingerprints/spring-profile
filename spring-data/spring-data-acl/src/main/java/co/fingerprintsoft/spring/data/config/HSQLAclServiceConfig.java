package co.fingerprintsoft.spring.data.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;
import org.springframework.security.acls.jdbc.BasicLookupStrategy;
import org.springframework.security.acls.jdbc.JdbcMutableAclService;
import org.springframework.security.acls.model.AclService;

@Configuration
public class HSQLAclServiceConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EhCacheBasedAclCache aclCache;

    @Autowired
    BasicLookupStrategy lookupStrategy;

    @Bean
    public AclService aclService() {
        return new JdbcMutableAclService(dataSource, lookupStrategy, aclCache);
    }


}

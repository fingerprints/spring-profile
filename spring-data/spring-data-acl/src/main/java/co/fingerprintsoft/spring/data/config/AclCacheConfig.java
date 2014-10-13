package co.fingerprintsoft.spring.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.acls.domain.EhCacheBasedAclCache;

import net.sf.ehcache.Ehcache;

@Configuration
public class AclCacheConfig {

    @Autowired
    private Ehcache ehcache;

    @Bean
    public EhCacheBasedAclCache aclCache() {
        return new EhCacheBasedAclCache(ehcache);
    }

}

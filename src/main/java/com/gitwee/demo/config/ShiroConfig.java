package com.gitwee.demo.config;

import com.gitwee.demo.shiro.DemoRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactory = new ShiroFilterFactoryBean();
        shiroFilterFactory.setSecurityManager(securityManager);

        Map<String,String> chainDefinitionMap = new HashMap<>();
        chainDefinitionMap.put("/static/**", "anon");
        chainDefinitionMap.put("/**", "authc");
        shiroFilterFactory.setFilterChainDefinitionMap(chainDefinitionMap);

        shiroFilterFactory.setLoginUrl("/login");
        shiroFilterFactory.setSuccessUrl("/");
        shiroFilterFactory.setUnauthorizedUrl("/403");

        return shiroFilterFactory;
    }

    @Bean
    public SecurityManager securityManager(AuthorizingRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return  securityManager;
    }

    @Bean
    public AuthorizingRealm shiroRealm() {
        AuthorizingRealm demoRealm = new DemoRealm();
        return  demoRealm;
    }

}

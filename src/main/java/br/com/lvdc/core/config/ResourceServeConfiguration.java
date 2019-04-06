package br.com.lvdc.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServeConfiguration extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID = "restService";
	
	public void configure(ResourceServerSecurityConfigurer resource)throws Exception{
		resource.resourceId(RESOURCE_ID);
	}
	
	
	public void configure(HttpSecurity http) throws Exception{
		 http
         .logout()
         .invalidateHttpSession(true)
         .clearAuthentication(true)
         .and().authorizeRequests()
         .antMatchers("/perfil/**").hasAnyRole("ADMIN, OREIA")
         .antMatchers("/usuario/**").hasAnyRole("ADMIN, OREIA")
         .anyRequest().denyAll()
         .antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
	}

}

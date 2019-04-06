package br.com.lvdc.core.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import br.com.lvdc.core.service.UserDatailService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	private TokenStore tokenStore = new InMemoryTokenStore();
	private static final String RESOURCE_ID = "restService";
	
	@Autowired
	private UserDatailService userDatailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager autenticationManager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endPointConfigurer) {
		endPointConfigurer.tokenStore(tokenStore)
						  .authenticationManager(autenticationManager)
						  .userDetailsService(userDatailsService);
	}
	
	public void configure(ClientDetailsServiceConfigurer cliente) throws Exception{
		cliente
        .inMemory()
        .withClient("cliente")
        .authorizedGrantTypes("password", "authorization_code", "refresh_token").scopes("bar", "read", "write")
        .refreshTokenValiditySeconds(2592000)
        .resourceIds(RESOURCE_ID)
        .secret(passwordEncoder().encode("123"))
        .accessTokenValiditySeconds(200000988);
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setTokenStore(tokenStore);
		return tokenServices;
	}
	
	

}

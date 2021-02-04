package kr.co.bomb.sample.common.config;


import kr.co.bomb.sample.auth.handler.AuthFailHandler;
import kr.co.bomb.sample.auth.handler.AuthSuccessHandler;
import kr.co.bomb.sample.auth.provider.AuthProvider;
import kr.co.bomb.sample.auth.repo.BombTokenRepository;
import kr.co.bomb.sample.auth.service.BombUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@ComponentScan(basePackages = {"kr.co.bomb.sample.*"})
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProvider authProvider;
    @Autowired
    AuthFailHandler authFailHandler;
    @Autowired
    AuthSuccessHandler authSuccessHandler;
    @Autowired
    BombTokenRepository bombTokenRepository;
    @Autowired
    BombUserDetailService bombUserDetailService;
    @Value("${juvis.mall.prop.token.key}")
    private String tokenKey;
    @Value("${juvis.mall.prop.token.expire-time}")
    private int expireTime;
    @Value("${juvis.mall.prop.auth.login-page-url}")
    private String loginPageUrl;
    @Value("${juvis.mall.prop.auth.login-process-url}")
    private String loginProcessUrl;
    @Value("${juvis.mall.prop.auth.logout-url}")
    private String logOutUrl;

    @Value("${juvis.mall.prop.auth.user-name-param}")
    private String userNameParam;
    @Value("${juvis.mall.prop.auth.password-param}")
    private String pwParam;
    @Value("${juvis.mall.prop.auth.remember-me-param}")
    private String rememParam;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                                   "/assets/*/**"
                );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
            .authorizeRequests()
                //.mvcMatchers("/","/assets/*/**","/login/**","/product/**",loginPageUrl,loginProcessUrl,logOutUrl).permitAll()
                //.mvcMatchers("/**").hasRole("USER")
                 .mvcMatchers("/**").permitAll()
            .and()
            .userDetailsService(bombUserDetailService)
            .authenticationProvider(authProvider)
            .formLogin()
                .loginPage(loginPageUrl)
                .loginProcessingUrl(loginProcessUrl)
                .defaultSuccessUrl("/")
                .usernameParameter(userNameParam)
                .passwordParameter(pwParam)
                .failureHandler(authFailHandler)
                .successHandler(authSuccessHandler)
                .permitAll()
            .and()
                .logout()
                .logoutUrl(logOutUrl)
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
                 .rememberMe()
                 .tokenRepository(bombTokenRepository)
                 .userDetailsService(bombUserDetailService)
                 .key(tokenKey)
                 .rememberMeParameter(rememParam)
                 .tokenValiditySeconds(expireTime)
            .and()
            .csrf().disable()//csrf 공격 제어를 위함 해당코드 사용시 파라미터 필요
            .headers().frameOptions().disable()
            .and()
            .httpBasic()
        ;
    }
}

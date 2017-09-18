package by.itransition.pandora.configuration;

import by.itransition.pandora.security.handler.RestAccessDeniedHandler;
import by.itransition.pandora.security.handler.RestAuthenticationEntryPoint;
import by.itransition.pandora.security.service.JwtAuthenticationFilter;
import by.itransition.pandora.security.service.JwtAuthenticationProvider;
import by.itransition.pandora.security.service.JwtUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    {
        //TODO: remove this!
        System.out.println("--- SecurityConfiguration -----!");
    }

    // TODO: remember about value: String[] allowedUrlsForPost
    private static final String[] allowedUrlsForPost = new String[]{"/auth/login"};

    @Autowired
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    public void configureAuthentication(final AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .and()
                .addFilterAfter(new JwtAuthenticationFilter(authenticationManagerBean()), BasicAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .accessDeniedHandler(new RestAccessDeniedHandler())
                .and()
                .csrf().disable()
//                .and().formLogin()
//                .loginProcessingUrl("/auth/login")
        ;
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.POST, allowedUrlsForPost)
                .antMatchers(HttpMethod.OPTIONS, "*");
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(this.jwtAuthenticationProvider)
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(this.passwordEncoder());
    }

   /* @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new JwtUserDetailsServiceImpl();
    }*/


}

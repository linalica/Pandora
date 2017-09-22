package by.itransition.pandora.configuration;

import by.itransition.pandora.security.model.CustomUserDetailsServiceImpl;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

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

   /* @Autowired
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
*/
   @Autowired
   private UserDetailsService userDetailsService;

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
                //.authenticationProvider(this.jwtAuthenticationProvider)
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(this.passwordEncoder());
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new CustomUserDetailsServiceImpl();
    }
}

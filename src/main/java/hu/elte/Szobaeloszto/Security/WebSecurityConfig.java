package hu.elte.Szobaeloszto.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Value("${need.test}")
    private boolean test;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      if(!test){
      http
          .cors()
              .and()
          .csrf().disable()
          .authorizeRequests()
              .antMatchers("/h2/**", "/users/register").permitAll()   // important!
              .anyRequest().authenticated()
              .and()
          .httpBasic()
              .authenticationEntryPoint(getBasicAuthEntryPoint())
              .and()
          .headers()      // important!
              .frameOptions().disable()
              .and()
          .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
       }else{
         http
          .cors()
              .and()
          .csrf().disable()
          .authorizeRequests()
              .antMatchers("/**").permitAll()   // important!
              .anyRequest().authenticated()
              .and()
          .httpBasic()
              .authenticationEntryPoint(getBasicAuthEntryPoint())
              .and()
          .headers()      // important!
              .frameOptions().disable()
              .and()
          .sessionManagement()
              .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        }
    }    
    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      if(!test){
        auth
          .userDetailsService(userDetailsService)
          .passwordEncoder(passwordEncoder());
        }else{
        auth
          .inMemoryAuthentication()
          .withUser("user").password("$2y$12$jqpNRrQCbmi.8A1KacIXVuw4Aq5iWA2.NbVOZFKOs59eaAcv/liqO").roles("ADMIN");
    }
    }
    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      if(!test){
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }else{
        auth
          .inMemoryAuthentication()
          .withUser("user").password("$2y$12$jqpNRrQCbmi.8A1KacIXVuw4Aq5iWA2.NbVOZFKOs59eaAcv/liqO").roles("ADMIN");
        }
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }
}
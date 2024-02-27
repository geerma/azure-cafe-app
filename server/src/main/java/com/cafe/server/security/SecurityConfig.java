package com.cafe.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Resources:
 * 
 * https://www.youtube.com/watch?v=9J-b6OlPy24
 * https://docs.spring.io/spring-security/reference/servlet/architecture.html
 * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
 * https://github.com/murraco/spring-boot-jwt/blob/master/src/main/java/murraco/security/JwtTokenProvider.java
 * 
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Autowired
    private CafeUserDetailsService cafeUserDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // @Value("${spring.security.debug:false}")
    // boolean securityDebug;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(
                        authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                                .antMatchers("/admin/**").hasRole("ADMIN")
                                .antMatchers("/users/**").hasAnyAuthority("USER", "ADMIN")
                                .antMatchers("/customers/**").hasAnyAuthority("USER", "ADMIN")
                                .antMatchers("/carts/**").hasAnyAuthority("USER", "ADMIN")
                                .antMatchers("/cartitems/**").hasAnyAuthority("USER", "ADMIN")
                                .antMatchers("/orders/**").hasAnyAuthority("USER", "ADMIN")
                                .antMatchers(HttpMethod.DELETE, "/admin/**").hasAnyAuthority("ADMIN")
                                .antMatchers("/auth/**").permitAll()
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        // .sessionManagement(httpSecuritySessionManagementConfigurer ->
        // httpSecuritySessionManagementConfigurer
        // .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return cafeUserDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(cafeUserDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter(jwtTokenProvider);
    }

    /**
     * Due to deprecation of "WebSecurityConfigurerAdapter", could not use
     * AuthenticationManagerBean
     * 
     * Reference:
     * https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
     * 
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}

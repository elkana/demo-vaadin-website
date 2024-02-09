package com.example.demovaadinwebsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import com.example.demovaadinwebsite.ui.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**", "/icons/**", "/images/**", "/styles/**")
                // .requestMatchers("/h2-console/**", "/icons/**", "/images/**", "/styles/**", "/**")
                .permitAll());
        // https://reflectoring.io/spring-security/
        // .sessionManagement((sm) -> {
        // sm.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(1)
        // .expiredUrl("/login?invalid-session=true");
        // sm.invalidSessionUrl("/login?invalid-session=true");
        // }
        // .maximumSessions(1)
        // .maxSessionsPreventsLogin(true)
        // );

        super.configure(http);
        setLoginView(http, LoginView.class);
        // why http splitted ? read
        //
        // https://stackoverflow.com/questions/74582626/vaadin-websecurity-connect-to-h2-database-forbidden
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(f -> f.disable()));
        // http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
        // http.sessionManagement().maximumSessions(1).and().invalidSessionUrl("/expired");
        // http.sessionManagement((sm) -> {
        // sm.sessionCreationPolicy(SessionCreationPolicy.ALWAYS).maximumSessions(1)
        // .expiredUrl("/login?expired=true");
        // sm.invalidSessionUrl("/login?invalid-session=true");
        // });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // https://stackoverflow.com/questions/49374506/method-md5passwordencoder-doesnt-work-for-me-in-spring5
        // spring says md5 is not secured anymore
        return new BCryptPasswordEncoder();
    }

    // @Bean
    // public HttpSessionEventPublisher httpSessionEventPublisher() {
    // return new HttpSessionEventPublisher();
    // }

}

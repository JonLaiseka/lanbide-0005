package com.ipartek.formacion.spring.mf0966spring.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// https://www.baeldung.com/spring-security-jdbc-authentication

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	DataSource dataSource;
	
	// PASSWORD ENCODER
	@Bean
	PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	
	// AUTENTICACIÓN
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email,password,true "
		            + "from usuarios "
		            + "where email = ?")
			.authoritiesByUsernameQuery("select u.email, CONCAT('ROLE_', r.nombre) "
		      		+ "from usuarios u "
		      		+ "join roles r on r.id = u.roles_id "
		      		+ "where email = ?");
	}
	
	// AUTORIZACIÓN
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}
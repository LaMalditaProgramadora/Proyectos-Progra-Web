package com.example.demoSecurity.config;

import com.example.demoSecurity.service.impl.JpaUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	@Autowired
	private LoginSucessHandler sucessHandler;

	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeRequests()
					// Para permitir nuestro js y css (en nuestra carpeta static)
					.antMatchers("/*.js", "/*.css").permitAll()
					// Para permitir creación de usuarios sin necesidad de estar logueado
					.antMatchers("/users/**").permitAll()
					// Para que solo un usuario logueado con esos roles acceda a /home
					.antMatchers("/home").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
					// Para que solo un usuario logueado con esos roles vea la lista de productos
					.antMatchers("/products").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
					// Para que solo un usuario con ROLE_ADMIN pueda crear un producto
					.antMatchers("/products/**").access("hasRole('ROLE_ADMIN')")
					// Lógica del login (configurado en LoginSucessHandler)
					.and().formLogin().successHandler(sucessHandler).loginPage("/login").loginProcessingUrl("/login")
					// Si el login es exitoso, retorna a /home
					.defaultSuccessUrl("/home").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
					// Si el usuario va a una ruta sin acceso, devuelve a /error_403 (Configurado en MvcConfig)
					.and().exceptionHandling().accessDeniedPage("/error403");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
}

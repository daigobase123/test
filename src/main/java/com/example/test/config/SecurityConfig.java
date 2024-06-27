package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.test.handler.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	
    	http
    	   .authorizeHttpRequests()
           .requestMatchers("/hello", "/login", "/role").permitAll()
           .requestMatchers("/test2").hasAnyRole("USER")
           .anyRequest().authenticated()
	    	.and()
	    	.csrf().disable()
	    	.formLogin().usernameParameter("userName")          //ユーザ名のリクエストパラメータ名
	        .passwordParameter("password")
	        .successHandler(new CustomLoginSuccessHandler())
	        .failureUrl("/ffff")
	        ;         //パスワードのリクエストパラメータ名
        // 認可の設定
//        http.authorizeHttpRequests(authz -> authz
//        		.requestMatchers("/").permitAll()           //ページは全ユーザからのアクセスを許可
//                .requestMatchers("/login").permitAll()  //loginPageは、全ユーザからのアクセスを許可
//                .anyRequest().authenticated()               //上記ページ以外は認証を求める
//                );
//        // ログイン設定
//        http.formLogin(login -> login                   //フォーム認証の有効化
//                .loginPage("/login")                //ログインフォームを表示するパス
//                .loginProcessingUrl("/authenticate")    //フォーム認証処理のパス
//                .usernameParameter("userName")          //ユーザ名のリクエストパラメータ名
//                .passwordParameter("password")          //パスワードのリクエストパラメータ名
//                .defaultSuccessUrl("/home")             //認証成功時に遷移するデフォルトのパス
//                .failureUrl("/loginPage?error=true")    //認証失敗時に遷移するパス
//        		);
//        // ログアウト設定
//        http.logout(logout -> logout
//                .logoutSuccessUrl("/loginPage")         //ログアウト成功時に遷移するパス
//                .permitAll()                            //全ユーザに対してアクセスを許可
//                );
        return http.build();
    }
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

}
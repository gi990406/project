package net.softsociety.blog.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security 설정
 */
@Configuration
@Order(0)
public class WebSecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/",
                        "/member/join",
                        "/images/**",
                        "/css/**",
                        "/script/**"
                ).permitAll()  				//설정한 리소스의 접근을 인증절차 없이 허용
                .anyRequest().authenticated()   	//위의 경로 외에는 모두 로그인을 해야 함
                .and()
                .formLogin()						//일반적인 폼을 이용한 로그인 처리/실패 방법을 사용
                .loginPage("/member/loginForm")		//시큐리티에서 제공하는 기본 폼이 아닌 사용자가 만든 폼 사용
                .loginProcessingUrl("/member/login").permitAll()	//인증 처리를 하는 URL을 설정. 로그인 폼의 action으로 지정
                .usernameParameter("blogid")		//로그인폼의 아이디 입력란의 name
                .passwordParameter("blogpwd")		//로그인폼의 비밀번호 입력란의 name
                .and()
                .logout()
                .logoutSuccessUrl("/").permitAll()	//로그아웃 시에 이동할 경로
                .and()
                .cors()
                .and()
                .httpBasic();

        return http.build();
    }

    //인증을 위한 쿼리
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                // 인증 (로그인)
                .usersByUsernameQuery(
                        "select blogid username, blogpwd password, enabled " +
                                "from blog_member " +
                                "where blogid = ?")
                // 권한
                .authoritiesByUsernameQuery(
                        "select blogid username, rolename role_name " +
                                "from blog_member " +
                                "where blogid = ?");
    }
    // 단방향 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

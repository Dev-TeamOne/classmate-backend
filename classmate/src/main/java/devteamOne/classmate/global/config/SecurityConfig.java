package devteamOne.classmate.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import devteamOne.classmate.global.jwt.JwtService;
import devteamOne.classmate.global.jwt.filter.JwtAuthenticationProcessingFilter;
import devteamOne.classmate.global.login.filter.CustomJsonAuthenticationFilter;
import devteamOne.classmate.global.login.handler.LoginFailureHandler;
import devteamOne.classmate.global.login.handler.LoginSuccessHandler;
import devteamOne.classmate.global.login.service.LoginService;
import devteamOne.classmate.global.oauth.handler.OAuth2LoginFailureHandler;
import devteamOne.classmate.global.oauth.handler.OAuth2LoginSuccessHandler;
import devteamOne.classmate.global.oauth.service.CustomOAuth2UserService;
import devteamOne.classmate.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final LoginService loginService;
    private final JwtService jwtService;

    private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
    private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .requestMatchers("/sign-up").permitAll()
                .anyRequest().authenticated()

                .and()
                .oauth2Login()
                .successHandler(oAuth2LoginSuccessHandler)
                .failureHandler(oAuth2LoginFailureHandler)
                .userInfoEndpoint().userService(customOAuth2UserService);

        http.addFilterAfter(customJsonAuthenticationFilter(), LogoutFilter.class);
        http.addFilterBefore(jwtAuthenticationProcessingFilter(), CustomJsonAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(loginService);
        return new ProviderManager(provider);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler(jwtService, userRepository);
    }

    @Bean
    public LoginFailureHandler loginFailureHandler() {
        return new LoginFailureHandler();
    }


    @Bean
    public CustomJsonAuthenticationFilter customJsonAuthenticationFilter() {
        CustomJsonAuthenticationFilter customJsonAuthenticationFilter =
                new CustomJsonAuthenticationFilter(objectMapper);

        customJsonAuthenticationFilter.setAuthenticationManager(authenticationManager());
        customJsonAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler());
        customJsonAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler());

        return customJsonAuthenticationFilter;
    }

    @Bean
    public JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() {
        return new JwtAuthenticationProcessingFilter(jwtService, userRepository);
    }
}
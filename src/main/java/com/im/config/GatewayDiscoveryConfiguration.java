package com.im.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Created by IntelliJ IDEA.
 * Author: I'm
 * Date: 2021/10/22
 */
@Configuration
@EnableDiscoveryClient
public class GatewayDiscoveryConfiguration {

    @Bean
    public DiscoveryClientRouteDefinitionLocator
    discoveryClientRouteLocator(ReactiveDiscoveryClient discoveryClient, DiscoveryLocatorProperties discoveryLocatorProperties) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, discoveryLocatorProperties);
    }

//    @Bean
//    public ReactiveClientRegistrationRepository reactiveClientRegistrationRepository(OAuth2ClientProperties oAuth2ClientProperties) {
//        List<ClientRegistration> clientRegistrations = new ArrayList<>();
//
//        // because autoconfigure does not work for an unknown reason, here the ClientRegistrations are manually configured based on the application.yml
//        oAuth2ClientProperties.getRegistration()
//                .forEach((k, v) -> {
//                    String tokenUri = oAuth2ClientProperties.getProvider().get(k).getTokenUri();
//                    ClientRegistration clientRegistration = ClientRegistration
//                            .withRegistrationId(k)
//                            .tokenUri(tokenUri)
//                            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                            .build();
//                    clientRegistrations.add(clientRegistration);
//                });
//
//        return new InMemoryReactiveClientRegistrationRepository(clientRegistrations);
//    }
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        // Authenticate through configured OpenID Provider
//        http.oauth2Login();
////        // Also logout at the OpenID Connect provider
////        http.logout(logout -> logout.logoutSuccessHandler(
////                new OidcClientInitiatedServerLogoutSuccessHandler(reactiveClientRegistrationRepository)));
//        // Require authentication for all requests
//        http.authorizeExchange().anyExchange().authenticated();
//
//        http.oauth2ResourceServer().jwt();
//
//        // Allow showing /home within a frame
//        http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
//        // Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
//        http.csrf().disable();
//        return http.build();
//    }

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("r1", r -> r.host("gateway.proxy.gygxzc.cn")
//                        .and()
//                        .path("/resource")
//                        .uri("http://192.168.200.54:11002"))
//                .route("r2", r -> r.host("gateway.proxy.gygxzc.cn")
//                        .and()
//                        .path("/lab-auth")
//                        .uri("http://192.168.200.54:8080"))
//                .build()
//                ;
//    }

}

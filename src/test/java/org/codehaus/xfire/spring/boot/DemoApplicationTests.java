package org.codehaus.xfire.spring.boot;

import org.docx4j.exportfo.spring.boot.Docx4jExportfoAutoConfiguration;
import org.docx4j.exportfo.spring.boot.Docx4jExportfoProperties;
import org.junit.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/** Tests the existing configuration scaffold, not document conversion or CAS services. */
public class DemoApplicationTests {

    // Explicit registration is intentional: this starter has no auto-configuration imports file.
    // This runner does not load the unrelated datasource/application resource examples or start a server.
    private final ApplicationContextRunner runner = new ApplicationContextRunner()
            .withUserConfiguration(Docx4jExportfoAutoConfiguration.class);

    @Test
    public void contextLoads() {
        runner.withPropertyValues("cas.enabled=true").run(context -> {
            assertThat(context).hasNotFailed().hasSingleBean(Docx4jExportfoAutoConfiguration.class)
                    .hasSingleBean(Docx4jExportfoProperties.class);
            Docx4jExportfoProperties properties = context.getBean(Docx4jExportfoProperties.class);
            assertThat(properties.isEnabled()).isTrue();
            assertThat(properties.isUseSession()).isTrue();
            assertThat(properties.isRedirectAfterValidation()).isTrue();
            assertThat(properties.getMillisBetweenCleanUps()).isEqualTo(60000L);
            assertThat(properties.getTolerance()).isEqualTo(1000L);
            assertThat(properties.getSignOutFilterUrlPatterns()).containsExactly("/*");
        });
    }

    @Test
    public void missingEnableFlagDoesNotRegisterConfiguration() {
        runner.run(context -> assertThat(context).hasNotFailed()
                .doesNotHaveBean(Docx4jExportfoAutoConfiguration.class)
                .doesNotHaveBean(Docx4jExportfoProperties.class));
    }

    @Test
    public void disabledConfigurationDoesNotBindProperties() {
        runner.withPropertyValues("cas.enabled=false", "cas.tolerance=not-a-number")
                .run(context -> assertThat(context).hasNotFailed()
                        .doesNotHaveBean(Docx4jExportfoAutoConfiguration.class)
                        .doesNotHaveBean(Docx4jExportfoProperties.class));
    }

    @Test
    public void unrelatedPrefixDoesNotEnableConfiguration() {
        runner.withPropertyValues("docx4j.enabled=true")
                .run(context -> assertThat(context).hasNotFailed()
                        .doesNotHaveBean(Docx4jExportfoAutoConfiguration.class));
    }

    @Test
    public void malformedNumericPropertyFailsEnabledContext() {
        runner.withPropertyValues("cas.enabled=true", "cas.tolerance=not-a-number")
                .run(context -> {
                    assertThat(context).hasFailed();
                    assertThat(context.getStartupFailure()).hasRootCauseInstanceOf(NumberFormatException.class);
                });
    }

    @Test
    public void enabledContextBindsExistingCasPropertyContract() {
        // Exercise external relaxed-name binding and conversion, not direct setter/getter round trips.
        // All URLs and class names are inert configuration values; no CAS endpoint is contacted.
        runner.withPropertyValues(
                "cas.enabled=true",
                "cas.configuration-strategy=PROPERTY_FILE",
                "cas.cas-server-login-url=https://cas.invalid/login",
                "cas.cas-server-url-prefix=https://cas.invalid",
                "cas.eagerly-create-sessions=false",
                "cas.accept-any-proxy=false",
                "cas.allowed-proxy-chains=https://proxy.invalid",
                "cas.artifact-parameter-name=ticket",
                "cas.artifact-parameter-over-post=true",
                "cas.assertion-thread-local-filter-url-patterns=/assert/*,/shared/*",
                "cas.authentication-redirect-strategy-class=example.RedirectStrategy",
                "cas.authentication-filter-url-patterns=/auth/*",
                "cas.cipher-algorithm=AES",
                "cas.encode-service-url=false",
                "cas.encoding=UTF-8",
                "cas.exception-on-validation-failure=false",
                "cas.gateway=true",
                "cas.gateway-storage-class=example.GatewayStorage",
                "cas.hostname-verifier=example.HostnameVerifier",
                "cas.hostname-verifier-config=test-verifier",
                "cas.ignore-case=true",
                "cas.ignore-pattern=/public/.*",
                "cas.ignore-init-configuration=true",
                "cas.logout-parameter-name=logoutRequest",
                "cas.millis-between-clean-ups=120000",
                "cas.proxy-callback-url=https://app.invalid/callback",
                "cas.proxy-receptor-url=/proxy-receptor",
                "cas.proxy-granting-ticket-storage-class=example.TicketStorage",
                "cas.request-wrapper-filter-url-patterns=/wrapped/*",
                "cas.redirect-after-validation=false",
                "cas.renew=true",
                "cas.relay-state-parameter-name=relayState",
                "cas.role-attribute=roles",
                "cas.secret-key=unit-test-only-not-a-secret",
                "cas.service-url=https://app.invalid/service",
                "cas.server-name=https://app.invalid",
                "cas.sign-out-filter-url-patterns=/logout/*",
                "cas.ssl-config-file=classpath:test-ssl.properties",
                "cas.ticket-validation-filter-url-patterns=/validate/*",
                "cas.ticket-validator-class=example.TicketValidator",
                "cas.tolerance=2500",
                "cas.use-session=false"
        ).run(context -> {
            assertThat(context).hasNotFailed().hasSingleBean(Docx4jExportfoProperties.class);
            Docx4jExportfoProperties p = context.getBean(Docx4jExportfoProperties.class);
            assertThat(p.isEnabled()).isTrue();
            assertThat(p.getConfigurationStrategy()).isEqualTo("PROPERTY_FILE");
            assertThat(p.getCasServerLoginUrl()).isEqualTo("https://cas.invalid/login");
            assertThat(p.getCasServerUrlPrefix()).isEqualTo("https://cas.invalid");
            assertThat(p.isEagerlyCreateSessions()).isFalse();
            assertThat(p.isAcceptAnyProxy()).isFalse();
            assertThat(p.getAllowedProxyChains()).isEqualTo("https://proxy.invalid");
            assertThat(p.getArtifactParameterName()).isEqualTo("ticket");
            assertThat(p.isArtifactParameterOverPost()).isTrue();
            assertThat(p.getAssertionThreadLocalFilterUrlPatterns()).containsExactly("/assert/*", "/shared/*");
            assertThat(p.getAuthenticationRedirectStrategyClass()).isEqualTo("example.RedirectStrategy");
            assertThat(p.getAuthenticationFilterUrlPatterns()).containsExactly("/auth/*");
            assertThat(p.getCipherAlgorithm()).isEqualTo("AES");
            assertThat(p.isEncodeServiceUrl()).isFalse();
            assertThat(p.getEncoding()).isEqualTo("UTF-8");
            assertThat(p.isExceptionOnValidationFailure()).isFalse();
            assertThat(p.isGateway()).isTrue();
            assertThat(p.getGatewayStorageClass()).isEqualTo("example.GatewayStorage");
            assertThat(p.getHostnameVerifier()).isEqualTo("example.HostnameVerifier");
            assertThat(p.getHostnameVerifierConfig()).isEqualTo("test-verifier");
            assertThat(p.isIgnoreCase()).isTrue();
            assertThat(p.getIgnorePattern()).isEqualTo("/public/.*");
            assertThat(p.isIgnoreInitConfiguration()).isTrue();
            assertThat(p.getLogoutParameterName()).isEqualTo("logoutRequest");
            assertThat(p.getMillisBetweenCleanUps()).isEqualTo(120000L);
            assertThat(p.getProxyCallbackUrl()).isEqualTo("https://app.invalid/callback");
            assertThat(p.getProxyReceptorUrl()).isEqualTo("/proxy-receptor");
            assertThat(p.getProxyGrantingTicketStorageClass()).isEqualTo("example.TicketStorage");
            assertThat(p.getRequestWrapperFilterUrlPatterns()).containsExactly("/wrapped/*");
            assertThat(p.isRedirectAfterValidation()).isFalse();
            assertThat(p.isRenew()).isTrue();
            assertThat(p.getRelayStateParameterName()).isEqualTo("relayState");
            assertThat(p.getRoleAttribute()).isEqualTo("roles");
            assertThat(p.getSecretKey()).isEqualTo("unit-test-only-not-a-secret");
            assertThat(p.getServiceUrl()).isEqualTo("https://app.invalid/service");
            assertThat(p.getServerName()).isEqualTo("https://app.invalid");
            assertThat(p.getSignOutFilterUrlPatterns()).containsExactly("/logout/*");
            assertThat(p.getSslConfigFile()).isEqualTo("classpath:test-ssl.properties");
            assertThat(p.getTicketValidationFilterUrlPatterns()).containsExactly("/validate/*");
            assertThat(p.getTicketValidatorClass()).isEqualTo("example.TicketValidator");
            assertThat(p.getTolerance()).isEqualTo(2500L);
            assertThat(p.isUseSession()).isFalse();
        });
    }
}

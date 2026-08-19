/*
 * Copyright (c) 2010-2020, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.docx4j.exportfo.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(Docx4jExportfoProperties.PREFIX)
/**
 * <p>Auto-configuration for Docx4jExportfoProperties.</p>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class Docx4jExportfoProperties {

	public static final String PREFIX = "cas";

	/**
	 * Enable Cas.
	 */
	private boolean enabled = false;
	/**
	 * DEFAULT,JNDI,WEB_XML,PROPERTY_FILE,SYSTEM_PROPERTIES
	 */
	private String configurationStrategy;

	/**
	 * Defines the location of the CAS server login URL, i.e.
	 * https://localhost:8443/cas/login
	 */
	private String casServerLoginUrl;
	/** The prefix url of the CAS server. */
	private String casServerUrlPrefix;

	private boolean eagerlyCreateSessions = true;

	private boolean acceptAnyProxy = true;
	private String allowedProxyChains;
	/**
	 * Specifies the name of the request parameter on where to find the artifact
	 * (i.e. ticket).
	 */
	private String artifactParameterName;
	private boolean artifactParameterOverPost = false;
	private String[] assertionThreadLocalFilterUrlPatterns = new String[] { "/*" };
	private String authenticationRedirectStrategyClass;
	private String[] authenticationFilterUrlPatterns = new String[] { "/*" };

	private String cipherAlgorithm;
	/**
	 * Sets where response.encodeUrl should be called on service urls when
	 * constructed.
	 */
	private boolean encodeServiceUrl = true;

	private String encoding;

	private boolean exceptionOnValidationFailure = true;

	/**
	 * Whether to send the gateway request or not. Valid values are eithertrue/false
	 * (or no value at all). Note that renew cannot be specified as local
	 * init-paramsetting.
	 */
	private boolean gateway = false;
	private String gatewayStorageClass;

	private String hostnameVerifier;
	private String hostnameVerifierConfig;

	private boolean ignoreCase = false;
	private String ignorePattern;

	private boolean ignoreInitConfiguration = false;
	private String logoutParameterName;

	private long millisBetweenCleanUps = 60000L;
	private String proxyCallbackUrl;
	private String proxyReceptorUrl;
	private String proxyGrantingTicketStorageClass;
	private String[] requestWrapperFilterUrlPatterns = new String[] { "/*" };
	private boolean redirectAfterValidation = true;
	/**
	 * Whether to send the renew request or not. Valid values are eithertrue/false
	 * (or no value at all). Note that renew cannot be specified as local
	 * init-paramsetting.
	 */
	private boolean renew = false;
	/** Name of parameter containing the state of the CAS server webflow. */
	private String relayStateParameterName;
	private String roleAttribute;
	
	private String secretKey;

	/** The exact url of the service. */
	private String serviceUrl;
	/**
     * The name of the server.  Should be in the following format: {protocol}:{hostName}:{port}.
     * Standard ports can be excluded. 
     */
	private String serverName;
	private String[] signOutFilterUrlPatterns = new String[] { "/*" };
	private String sslConfigFile;

	private String[] ticketValidationFilterUrlPatterns = new String[] { "/*" };
	private String ticketValidatorClass;
	private long tolerance = 1000L;

	private boolean useSession = true;

	/** @return return whether enabled is enabled. */
	public boolean isEnabled() {
		return enabled;
	}

	/** @param enabled set the enabled. */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/** @return return the configuration strategy. */
	public String getConfigurationStrategy() {
		return configurationStrategy;
	}

	/** @param configurationStrategy set the configuration strategy. */
	public void setConfigurationStrategy(String configurationStrategy) {
		this.configurationStrategy = configurationStrategy;
	}

	/** @return return the cas server login url. */
	public String getCasServerLoginUrl() {
		return casServerLoginUrl;
	}

	/** @param casServerLoginUrl set the cas server login url. */
	public void setCasServerLoginUrl(String casServerLoginUrl) {
		this.casServerLoginUrl = casServerLoginUrl;
	}

	/** @return return the cas server url prefix. */
	public String getCasServerUrlPrefix() {
		return casServerUrlPrefix;
	}

	/** @param casServerUrlPrefix set the cas server url prefix. */
	public void setCasServerUrlPrefix(String casServerUrlPrefix) {
		this.casServerUrlPrefix = casServerUrlPrefix;
	}

	/** @return return whether eagerly create sessions is enabled. */
	public boolean isEagerlyCreateSessions() {
		return eagerlyCreateSessions;
	}

	/** @param eagerlyCreateSessions set the eagerly create sessions. */
	public void setEagerlyCreateSessions(boolean eagerlyCreateSessions) {
		this.eagerlyCreateSessions = eagerlyCreateSessions;
	}

	/** @return return whether accept any proxy is enabled. */
	public boolean isAcceptAnyProxy() {
		return acceptAnyProxy;
	}

	/** @param acceptAnyProxy set the accept any proxy. */
	public void setAcceptAnyProxy(boolean acceptAnyProxy) {
		this.acceptAnyProxy = acceptAnyProxy;
	}

	/** @return return the allowed proxy chains. */
	public String getAllowedProxyChains() {
		return allowedProxyChains;
	}

	/** @param allowedProxyChains set the allowed proxy chains. */
	public void setAllowedProxyChains(String allowedProxyChains) {
		this.allowedProxyChains = allowedProxyChains;
	}

	/** @return return the artifact parameter name. */
	public String getArtifactParameterName() {
		return artifactParameterName;
	}

	/** @param artifactParameterName set the artifact parameter name. */
	public void setArtifactParameterName(String artifactParameterName) {
		this.artifactParameterName = artifactParameterName;
	}

	/** @return return whether artifact parameter over post is enabled. */
	public boolean isArtifactParameterOverPost() {
		return artifactParameterOverPost;
	}

	/** @param artifactParameterOverPost set the artifact parameter over post. */
	public void setArtifactParameterOverPost(boolean artifactParameterOverPost) {
		this.artifactParameterOverPost = artifactParameterOverPost;
	}

	/** @return return the assertion thread local filter url patterns. */
	public String[] getAssertionThreadLocalFilterUrlPatterns() {
		return assertionThreadLocalFilterUrlPatterns;
	}

	/** @param assertionThreadLocalFilterUrlPatterns set the assertion thread local filter url patterns. */
	public void setAssertionThreadLocalFilterUrlPatterns(String[] assertionThreadLocalFilterUrlPatterns) {
		this.assertionThreadLocalFilterUrlPatterns = assertionThreadLocalFilterUrlPatterns;
	}

	/** @return return the authentication redirect strategy class. */
	public String getAuthenticationRedirectStrategyClass() {
		return authenticationRedirectStrategyClass;
	}

	/** @param authenticationRedirectStrategyClass set the authentication redirect strategy class. */
	public void setAuthenticationRedirectStrategyClass(String authenticationRedirectStrategyClass) {
		this.authenticationRedirectStrategyClass = authenticationRedirectStrategyClass;
	}

	/** @return return the authentication filter url patterns. */
	public String[] getAuthenticationFilterUrlPatterns() {
		return authenticationFilterUrlPatterns;
	}

	/** @param authenticationFilterUrlPatterns set the authentication filter url patterns. */
	public void setAuthenticationFilterUrlPatterns(String[] authenticationFilterUrlPatterns) {
		this.authenticationFilterUrlPatterns = authenticationFilterUrlPatterns;
	}

	/** @return return the cipher algorithm. */
	public String getCipherAlgorithm() {
		return cipherAlgorithm;
	}

	/** @param cipherAlgorithm set the cipher algorithm. */
	public void setCipherAlgorithm(String cipherAlgorithm) {
		this.cipherAlgorithm = cipherAlgorithm;
	}

	/** @return return whether encode service url is enabled. */
	public boolean isEncodeServiceUrl() {
		return encodeServiceUrl;
	}

	/** @param encodeServiceUrl set the encode service url. */
	public void setEncodeServiceUrl(boolean encodeServiceUrl) {
		this.encodeServiceUrl = encodeServiceUrl;
	}

	/** @return return the encoding. */
	public String getEncoding() {
		return encoding;
	}

	/** @param encoding set the encoding. */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/** @return return whether exception on validation failure is enabled. */
	public boolean isExceptionOnValidationFailure() {
		return exceptionOnValidationFailure;
	}

	/** @param exceptionOnValidationFailure set the exception on validation failure. */
	public void setExceptionOnValidationFailure(boolean exceptionOnValidationFailure) {
		this.exceptionOnValidationFailure = exceptionOnValidationFailure;
	}

	/** @return return whether gateway is enabled. */
	public boolean isGateway() {
		return gateway;
	}

	/** @param gateway set the gateway. */
	public void setGateway(boolean gateway) {
		this.gateway = gateway;
	}

	/** @return return the gateway storage class. */
	public String getGatewayStorageClass() {
		return gatewayStorageClass;
	}

	/** @param gatewayStorageClass set the gateway storage class. */
	public void setGatewayStorageClass(String gatewayStorageClass) {
		this.gatewayStorageClass = gatewayStorageClass;
	}

	/** @return return the hostname verifier. */
	public String getHostnameVerifier() {
		return hostnameVerifier;
	}

	/** @param hostnameVerifier set the hostname verifier. */
	public void setHostnameVerifier(String hostnameVerifier) {
		this.hostnameVerifier = hostnameVerifier;
	}

	/** @return return the hostname verifier config. */
	public String getHostnameVerifierConfig() {
		return hostnameVerifierConfig;
	}

	/** @param hostnameVerifierConfig set the hostname verifier config. */
	public void setHostnameVerifierConfig(String hostnameVerifierConfig) {
		this.hostnameVerifierConfig = hostnameVerifierConfig;
	}

	/** @return return whether ignore case is enabled. */
	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/** @param ignoreCase set the ignore case. */
	public void setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
	}

	/** @return return the ignore pattern. */
	public String getIgnorePattern() {
		return ignorePattern;
	}

	/** @param ignorePattern set the ignore pattern. */
	public void setIgnorePattern(String ignorePattern) {
		this.ignorePattern = ignorePattern;
	}

	/** @return return whether ignore init configuration is enabled. */
	public boolean isIgnoreInitConfiguration() {
		return ignoreInitConfiguration;
	}

	/** @param ignoreInitConfiguration set the ignore init configuration. */
	public void setIgnoreInitConfiguration(boolean ignoreInitConfiguration) {
		this.ignoreInitConfiguration = ignoreInitConfiguration;
	}

	/** @return return the logout parameter name. */
	public String getLogoutParameterName() {
		return logoutParameterName;
	}

	/** @param logoutParameterName set the logout parameter name. */
	public void setLogoutParameterName(String logoutParameterName) {
		this.logoutParameterName = logoutParameterName;
	}

	/** @return return the millis between clean ups. */
	public long getMillisBetweenCleanUps() {
		return millisBetweenCleanUps;
	}

	/** @param millisBetweenCleanUps set the millis between clean ups. */
	public void setMillisBetweenCleanUps(long millisBetweenCleanUps) {
		this.millisBetweenCleanUps = millisBetweenCleanUps;
	}

	/** @return return the proxy callback url. */
	public String getProxyCallbackUrl() {
		return proxyCallbackUrl;
	}

	/** @param proxyCallbackUrl set the proxy callback url. */
	public void setProxyCallbackUrl(String proxyCallbackUrl) {
		this.proxyCallbackUrl = proxyCallbackUrl;
	}

	/** @return return the proxy receptor url. */
	public String getProxyReceptorUrl() {
		return proxyReceptorUrl;
	}

	/** @param proxyReceptorUrl set the proxy receptor url. */
	public void setProxyReceptorUrl(String proxyReceptorUrl) {
		this.proxyReceptorUrl = proxyReceptorUrl;
	}

	/** @return return the proxy granting ticket storage class. */
	public String getProxyGrantingTicketStorageClass() {
		return proxyGrantingTicketStorageClass;
	}

	/** @param proxyGrantingTicketStorageClass set the proxy granting ticket storage class. */
	public void setProxyGrantingTicketStorageClass(String proxyGrantingTicketStorageClass) {
		this.proxyGrantingTicketStorageClass = proxyGrantingTicketStorageClass;
	}

	/** @return return the request wrapper filter url patterns. */
	public String[] getRequestWrapperFilterUrlPatterns() {
		return requestWrapperFilterUrlPatterns;
	}

	/** @param requestWrapperFilterUrlPatterns set the request wrapper filter url patterns. */
	public void setRequestWrapperFilterUrlPatterns(String[] requestWrapperFilterUrlPatterns) {
		this.requestWrapperFilterUrlPatterns = requestWrapperFilterUrlPatterns;
	}

	/** @return return whether redirect after validation is enabled. */
	public boolean isRedirectAfterValidation() {
		return redirectAfterValidation;
	}

	/** @param redirectAfterValidation set the redirect after validation. */
	public void setRedirectAfterValidation(boolean redirectAfterValidation) {
		this.redirectAfterValidation = redirectAfterValidation;
	}

	/** @return return whether renew is enabled. */
	public boolean isRenew() {
		return renew;
	}

	/** @param renew set the renew. */
	public void setRenew(boolean renew) {
		this.renew = renew;
	}

	/** @return return the relay state parameter name. */
	public String getRelayStateParameterName() {
		return relayStateParameterName;
	}

	/** @param relayStateParameterName set the relay state parameter name. */
	public void setRelayStateParameterName(String relayStateParameterName) {
		this.relayStateParameterName = relayStateParameterName;
	}

	/** @return return the role attribute. */
	public String getRoleAttribute() {
		return roleAttribute;
	}

	/** @param roleAttribute set the role attribute. */
	public void setRoleAttribute(String roleAttribute) {
		this.roleAttribute = roleAttribute;
	}

	/** @return return the secret key. */
	public String getSecretKey() {
		return secretKey;
	}

	/** @param secretKey set the secret key. */
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	/** @return return the service url. */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/** @param serviceUrl set the service url. */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/** @return return the server name. */
	public String getServerName() {
		return serverName;
	}

	/** @param serverName set the server name. */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	/** @return return the sign out filter url patterns. */
	public String[] getSignOutFilterUrlPatterns() {
		return signOutFilterUrlPatterns;
	}

	/** @param signOutFilterUrlPatterns set the sign out filter url patterns. */
	public void setSignOutFilterUrlPatterns(String[] signOutFilterUrlPatterns) {
		this.signOutFilterUrlPatterns = signOutFilterUrlPatterns;
	}

	/** @return return the ssl config file. */
	public String getSslConfigFile() {
		return sslConfigFile;
	}

	/** @param sslConfigFile set the ssl config file. */
	public void setSslConfigFile(String sslConfigFile) {
		this.sslConfigFile = sslConfigFile;
	}

	/** @return return the ticket validation filter url patterns. */
	public String[] getTicketValidationFilterUrlPatterns() {
		return ticketValidationFilterUrlPatterns;
	}

	/** @param ticketValidationFilterUrlPatterns set the ticket validation filter url patterns. */
	public void setTicketValidationFilterUrlPatterns(String[] ticketValidationFilterUrlPatterns) {
		this.ticketValidationFilterUrlPatterns = ticketValidationFilterUrlPatterns;
	}

	/** @return return the ticket validator class. */
	public String getTicketValidatorClass() {
		return ticketValidatorClass;
	}

	/** @param ticketValidatorClass set the ticket validator class. */
	public void setTicketValidatorClass(String ticketValidatorClass) {
		this.ticketValidatorClass = ticketValidatorClass;
	}

	/** @return return the tolerance. */
	public long getTolerance() {
		return tolerance;
	}

	/** @param tolerance set the tolerance. */
	public void setTolerance(long tolerance) {
		this.tolerance = tolerance;
	}

	/** @return return whether use session is enabled. */
	public boolean isUseSession() {
		return useSession;
	}

	/** @param useSession set the use session. */
	public void setUseSession(boolean useSession) {
		this.useSession = useSession;
	}

}

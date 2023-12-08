package com.azure.test.processorissue;

import com.azure.core.credential.TokenCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.spring.cloud.autoconfigure.context.AzureTokenCredentialAutoConfiguration;
import com.azure.spring.cloud.core.customizer.AzureServiceClientBuilderCustomizer;
import com.azure.spring.cloud.core.implementation.credential.resolver.AzureTokenCredentialResolver;
import com.azure.spring.cloud.core.implementation.factory.credential.DefaultAzureCredentialBuilderFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(AzureTokenCredentialAutoConfiguration.class)
public class ApplicationConfiguration {

    @Bean(name = "springCloudAzureDefaultCredential")
    @Order
    TokenCredential tokenCredential(DefaultAzureCredentialBuilderFactory factory,
                                    AzureTokenCredentialResolver resolver) {
        ClientSecretCredentialBuilder builder = new ClientSecretCredentialBuilder();
        builder.tenantId("63a3e82d-f852-453c-cb7f-d97aa2cd0a96")
                .clientId("51bf36r9-f56e-9o3e-r99t-6er2e0658t47")
                .clientSecret("D4F9T~U6jDSF1lGG5tYUsc.UGHvGjV5WErf8l");
        return builder.build();
    }

    @Bean
    AzureServiceClientBuilderCustomizer<ServiceBusClientBuilder> customEndPointCustomizer() {
        return new AzureServiceClientBuilderCustomizer<ServiceBusClientBuilder>() {
            @Override
            public void customize(ServiceBusClientBuilder serviceBusClientBuilder) {
                serviceBusClientBuilder.customEndpointAddress("https://link.custom.org");
            }
        };
    }

}

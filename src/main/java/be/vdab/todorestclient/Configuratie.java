package be.vdab.todorestclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
class Configuratie {
    @Bean
    Requests requests(RestClient.Builder builder, @Value("${todo.url}") String url) throws Exception {
        var client = builder.baseUrl(url).build();
        var adapter = RestClientAdapter.create(client);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(Requests.class);
    }
}

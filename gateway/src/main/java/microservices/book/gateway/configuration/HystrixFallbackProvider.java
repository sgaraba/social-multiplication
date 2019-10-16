package microservices.book.gateway.configuration;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

public class HystrixFallbackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        return "multiplication";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new FallbackHttpResponse();
    }
}

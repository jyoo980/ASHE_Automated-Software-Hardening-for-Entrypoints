package edu.njit.jerse.ashe.llm.google;

import edu.njit.jerse.ashe.llm.api.ApiRequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Service implementation for interacting with the Google LLM API.
 * <p>
 * This service provides methods for constructing API requests to Google and
 * retrieving API responses using the provided HTTP client.
 */
public class GoogleRequestHandler implements ApiRequestHandler {

    private static final Logger LOGGER = LogManager.getLogger(GoogleRequestHandler.class);

    /**
     * Period after which a log message is emitted indicating a system is
     * waiting for an API response. This is used for scheduled logging to give feedback
     * while waiting for a potentially long-running API call.
     *
     */
    private final long googleResponseLoggingPeriodInSec;

    /**
     * Maximum duration to wait for the API response.
     */
    private final long googleResponseTimeoutInSec;

    public GoogleRequestHandler() {
        this.googleResponseLoggingPeriodInSec = 10;
        this.googleResponseTimeoutInSec = 60;
    }

    // TODO: documentation
    @Override
    public HttpRequest apiRequest(String apiKey, String apiUri, String apiRequestBody) {
        LOGGER.info("Constructing API request to {}", apiUri);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUri))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer" + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(apiRequestBody))
                .build();
        LOGGER.debug("API request constructed successfully");

        return request;
    }

    @Override
    public HttpResponse<String> apiResponse(HttpRequest request, HttpClient client) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}

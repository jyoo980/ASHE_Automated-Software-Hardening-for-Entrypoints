package edu.njit.jerse.ashe.llm.api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * The {@code ApiRequestHandler} interface provides methods for interacting with an API.
 * It defines methods to create API requests and fetch API responses.
 */
public interface ApiRequestHandler {

    /**
     * Creates an API request.
     *
     * @param apiKey          the API key required for the request
     * @param apiUri          the URI endpoint for the API request
     * @param apiRequestBody  the body content for the API request
     * @return the constructed {@link HttpRequest} object
     */
    HttpRequest apiRequest(String apiKey, String apiUri, String apiRequestBody);

    /**
     * Retrieves the API response based on a given request.
     *
     * @param request the {@link HttpRequest} object
     * @param client  the {@link HttpClient} to send the request
     * @return the {@link HttpResponse} object containing the API's response as a string
     * @throws InterruptedException If the request is interrupted
     * @throws TimeoutException If the request does not complete in time
     */
    HttpResponse<String> apiResponse(HttpRequest request, HttpClient client) throws InterruptedException, ExecutionException, TimeoutException;
}

package com.jfrog.bintray.client.api.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.MultipleBintrayCallException;
import org.apache.http.HttpResponse;

import java.io.Closeable;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Noam Y. Tenne
 */
public interface Bintray extends Closeable {

    SubjectHandle subject(String subject);

    RepositoryHandle repository(String repositoryPath);

    PackageHandle pkg(String packagePath);

    VersionHandle version(String versionPath);

    InternalHandle internal();

    /**
     * Following are generic HTTP requests you can perform against Bintray's API, as defined in your created client
     * (so the uri parameter should be the required path after api.bintray.com).
     * You can also optionally add your own headers to the requests.
     */

    HttpResponse get(String uri, Map<String, String> headers) throws BintrayCallException;

    HttpResponse head(String uri, Map<String, String> headers) throws BintrayCallException;

    HttpResponse post(String uri, Map<String, String> headers, InputStream elementInputStream) throws BintrayCallException;

    HttpResponse patch(String uri, Map<String, String> headers, InputStream elementInputStream) throws BintrayCallException;

    HttpResponse delete(String uri, Map<String, String> headers) throws BintrayCallException;

    /**
     * PUT single item
     */
    HttpResponse put(String uri, Map<String, String> headers, InputStream elementInputStream) throws BintrayCallException;

    /**
     * Concurrently executes a list of {@link org.apache.http.client.methods.HttpPut} requests, which are not handled by
     * the default response handler to avoid any BintrayCallExceptions being thrown before all requests have executed.
     *
     * @return A list of all errors thrown while performing the requests or empty list if all requests finished OK
     */
    HttpResponse put(Map<String, InputStream> uriAndStreamMap, Map<String, String> headers) throws MultipleBintrayCallException;

    @Override
    void close();
}
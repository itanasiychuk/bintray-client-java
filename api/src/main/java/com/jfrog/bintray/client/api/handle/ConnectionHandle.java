package com.jfrog.bintray.client.api.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.model.Connection;

import java.io.IOException;
import java.util.Collection;

/**
 * @author Ihor Tanasiychuk
 */
public interface ConnectionHandle extends Handle<Collection<Connection>> {
    Collection<Connection> get() throws IOException, BintrayCallException;
}

package com.jfrog.bintray.client.api.handle;

import com.jfrog.bintray.client.api.BintrayCallException;
import com.jfrog.bintray.client.api.model.SystemInfo;

import java.io.IOException;

/**
 * @author Ihor Tanasiychuk
 */
public interface SystemInfoHandle extends Handle<SystemInfo> {
    SystemInfo get() throws IOException, BintrayCallException;
}

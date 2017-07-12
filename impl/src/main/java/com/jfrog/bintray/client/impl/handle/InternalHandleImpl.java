package com.jfrog.bintray.client.impl.handle;

import com.jfrog.bintray.client.api.handle.ConnectionHandle;
import com.jfrog.bintray.client.api.handle.InternalHandle;
import com.jfrog.bintray.client.api.handle.SystemInfoHandle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jfrog.bintray.client.impl.handle.ConnectionHandleImpl.ConnectionType.ARTIFACTORY;
import static com.jfrog.bintray.client.impl.handle.ConnectionHandleImpl.ConnectionType.EDGE;

/**
 * @author Ihor Tanasiychuk
 */
public class InternalHandleImpl implements InternalHandle {
    private static final Logger log = LoggerFactory.getLogger(InternalHandleImpl.class);

    private SystemInfoHandle systemInfoHandle;
    private ConnectionHandle artifactoryConnectionHandle;
    private ConnectionHandle edgeConnectionHandle;

    InternalHandleImpl(BintrayImpl bintrayHandle) {
        this.systemInfoHandle = new SystemInfoHandleImpl(bintrayHandle);
        this.artifactoryConnectionHandle = new ConnectionHandleImpl(bintrayHandle, ARTIFACTORY);
        this.edgeConnectionHandle = new ConnectionHandleImpl(bintrayHandle, EDGE);
    }

    public SystemInfoHandle systemInfo() {
        return systemInfoHandle;
    }

    public ConnectionHandle artifactories() {
        return artifactoryConnectionHandle;
    }

    public ConnectionHandle edges() {
        return edgeConnectionHandle;
    }
}

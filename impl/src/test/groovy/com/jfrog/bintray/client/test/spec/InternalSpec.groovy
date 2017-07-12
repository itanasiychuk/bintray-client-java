package com.jfrog.bintray.client.test.spec

import com.jfrog.bintray.client.api.model.Connection
import com.jfrog.bintray.client.api.model.SystemInfo
import spock.lang.Ignore
import spock.lang.Specification

import static com.jfrog.bintray.client.test.BintraySpecSuite.bintray
/**
 * @author Ihor Tanasiychuk
 */
class InternalSpec extends Specification {
    def 'Get system info'() {
        when:
        SystemInfo systemInfo = bintray.internal().systemInfo().get()

        then:
        systemInfo
        systemInfo.getDefaultOrganization()
        systemInfo.getType()
        systemInfo.getType() == 'Bintray'
        systemInfo.getStatus()
        systemInfo.getStatus() == 'ACTIVE'
        systemInfo.getVersion()
    }

    @Ignore("How to add artifactory distribution connections to bintray? Endpoint?")
    def 'Get artifactory distribution connections'() {
        setup:
        //TODO: Add connection to bintray
        when:
        Collection<Connection> connections = bintray.internal().artifactories().get()

        then:
        connections
        //connections.size() == 0
    }

    @Ignore("How to add edge distribution connections to bintray? Endpoint?")
    def 'Get edge distribution connections'() {
        setup:
        //TODO: Add connection to bintray
        when:
        Collection<Connection> connections = bintray.internal().edges().get()

        then:
        connections
        //connections.size() == 0
    }
}

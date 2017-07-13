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

    @Ignore("How to add/remove artifactory distribution connections to bintray? Endpoint?")
    def 'Get artifactory distribution connections'() {
        setup:
        //TODO: Add connection to bintray
        def hours = 2
        when:
        Collection<Connection> connections = bintray.internal().artifactories(hours).get()

        then:
        connections
        //connections.size() == 0
    }

    @Ignore("How to add/remove edge distribution connections to bintray? Endpoint?")
    def 'Get edge distribution connections'() {
        setup:
        //TODO: Add connection to bintray
        def hours = 2
        when:
        Collection<Connection> connections = bintray.internal().edges(hours).get()

        then:
        connections
        //connections.size() == 0
    }
}

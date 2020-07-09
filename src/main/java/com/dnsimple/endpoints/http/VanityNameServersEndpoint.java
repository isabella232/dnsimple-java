package com.dnsimple.endpoints.http;

import com.dnsimple.VanityNameServers;
import com.dnsimple.data.NameServer;
import com.dnsimple.response.EmptyResponse;
import com.dnsimple.response.ListResponse;

import static com.dnsimple.endpoints.http.HttpMethod.DELETE;
import static com.dnsimple.endpoints.http.HttpMethod.PUT;
import static java.util.Collections.emptyMap;

public class VanityNameServersEndpoint implements VanityNameServers {
    private final HttpEndpointClient client;

    public VanityNameServersEndpoint(HttpEndpointClient client) {
        this.client = client;
    }

    public ListResponse<NameServer> enableVanityNameServers(String accountId, String domainId) {
        return client.list(PUT, accountId + "/vanity/" + domainId, emptyMap(), null, NameServer.class);
    }

    public EmptyResponse disableVanityNameServers(String accountId, String domainId) {
        return client.empty(DELETE, accountId + "/vanity/" + domainId, emptyMap(), null);
    }
}


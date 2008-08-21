package org.mobicents.slee.resource.diameter.base.events.avp;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.StringTokenizer;

import net.java.slee.resource.diameter.base.events.avp.DiameterURIAvp;
public class DiameterURIAvpImpl implements DiameterURIAvp{

	public DiameterURIAvpImpl(String fqdn, int port, int protocol, int transport, boolean secure) {
        this.secure = secure;
        this.hostname = fqdn;
        this.port = port;
        this.protocol = protocol;
        this.transport = transport;
    }

    public DiameterURIAvpImpl(String uri) throws URISyntaxException {
        parseUri(uri);
    }

    public boolean getSecure() {
        return secure;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public int getProtocol() {
        return protocol;
    }

    public int getTransport() {
        return transport;
    }

    /**
     * Return the contents of this URI as a byte array.  Technically this type derives from OctetString, so we
     * need to be able to return the value in the base type.
     * @return the result of toString().getBytes()
     */

    public byte[] getBytes() {
        return toString().getBytes();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer( secure ? "aaas" : "aaa" );
        buffer.append("://").append(hostname);
        if(port != DEFAULT_DIAMETER_PORT) buffer.append(":").append(port);
        if(transport != TRANSPORT_TCP) {
            buffer.append(";transport=");
            switch(transport) {
                case TRANSPORT_SCTP: buffer.append("sctp"); break;
                case TRANSPORT_UDP: buffer.append("udp"); break;
            }
        }
        if(protocol != PROTOCOL_DIAMETER) {
            buffer.append(";protocol=");
            switch(protocol) {
                case PROTOCOL_RADIUS: buffer.append("radius"); break;
                case PROTOCOL_TACACSPLUS: buffer.append("tacacs+"); break;
            }
        }
        return buffer.toString();
    }

    private void parseUri(String uri) throws URISyntaxException {
        URI parsedUri;
        int semiColonPos = uri.indexOf(';');
        if (semiColonPos > 0) {
            parsedUri = new URI(uri.substring(0,semiColonPos));
            StringTokenizer st = new StringTokenizer(uri.substring(semiColonPos+1), ";=", false);
            while(st.hasMoreTokens()) {
                String name = st.nextToken();
                if(name.equals("transport")) {
                    transport = matchTransport(st.nextToken());
                }
                else if(name.equals("protocol")) {
                    protocol = matchProtocol(st.nextToken());
                }
                else  {
                    throw new URISyntaxException(name,"unknown URI option");
                }
            }
        }
        else {
            parsedUri = new URI(uri);
        }
        if(parsedUri.getScheme().equals("aaa")) {
            secure = false;
        }
        else if(parsedUri.getScheme().equals("aaas")) {
            secure = true;
        }
        else {
            throw new URISyntaxException(parsedUri.getScheme(),"invalid scheme (must be aaa or aaas)");
        }
        hostname = parsedUri.getHost();
        port = parsedUri.getPort() > 0 ? parsedUri.getPort() : DEFAULT_DIAMETER_PORT;
    }

    private int matchTransport(String transportString) {
        if(transportString.equals("tcp")) {
            return TRANSPORT_TCP;
        }
        else if(transportString.equals("sctp")) {
            return TRANSPORT_SCTP;
        }
        else if(transportString.equals("udp")) {
            return TRANSPORT_UDP;
        }
        else throw new IllegalArgumentException("Unknown transport: " + transportString);
    }

    private int matchProtocol(String protocolString) {
        if(protocolString.equals("diameter")) {
            return PROTOCOL_DIAMETER;
        }
        else if(protocolString.equals("radius")) {
            return PROTOCOL_RADIUS;
        }
        else if(protocolString.equals("tacacs+")) {
            return PROTOCOL_TACACSPLUS;
        }
        else throw new IllegalArgumentException("Unknown protocol: " + protocolString);
    }

    public static final int TRANSPORT_TCP = 0;
    public static final int TRANSPORT_SCTP = 1;
    public static final int TRANSPORT_UDP = 2;

    public static final int PROTOCOL_DIAMETER = 0;
    public static final int PROTOCOL_RADIUS = 1;
    public static final int PROTOCOL_TACACSPLUS = 2;

    private static final int DEFAULT_DIAMETER_PORT = 3868;

    private boolean secure;   //  false = aaa:   true = aaas:
    private String hostname;
    private int port;
    private int protocol;
    private int transport;
	
}

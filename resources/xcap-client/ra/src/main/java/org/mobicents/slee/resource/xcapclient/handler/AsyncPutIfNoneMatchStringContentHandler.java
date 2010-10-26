package org.mobicents.slee.resource.xcapclient.handler;

import java.net.URI;

import org.mobicents.slee.resource.xcapclient.XCAPClientResourceAdaptor;
import org.mobicents.slee.resource.xcapclient.XCAPResourceAdaptorActivityHandle;
import org.mobicents.xcap.client.XcapResponse;
import org.mobicents.xcap.client.auth.Credentials;
import org.mobicents.xcap.client.header.Header;

/**
 * Handles an async put if ETag matches none request, using String content.
 * 
 * @author emmartins
 * 
 */
public class AsyncPutIfNoneMatchStringContentHandler extends
		AbstractAsyncHandler {

	protected String mimetype;
	protected String content;
	protected String eTag;

	public AsyncPutIfNoneMatchStringContentHandler(
			XCAPClientResourceAdaptor ra,
			XCAPResourceAdaptorActivityHandle handle, URI uri, String eTag,
			String mimetype, String content, Header[] additionalRequestHeaders,
			Credentials credentials) {
		super(ra, handle, ra.getPutResponseEventType(), uri, additionalRequestHeaders, credentials);
		this.mimetype = mimetype;
		this.content = content;
		this.eTag = eTag;
	}

	@Override
	protected XcapResponse doRequest() throws Exception {
		return ra.getClient().putIfNoneMatch(uri, eTag, mimetype, content,
				additionalRequestHeaders, credentials);
	}

}
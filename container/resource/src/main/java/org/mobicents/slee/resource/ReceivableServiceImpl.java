/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource;

import javax.slee.ServiceID;
import javax.slee.resource.ReceivableService;

/**
 * Implementation of the SLEE 1.1 specs {@link ReceivableService} class.
 * @author martins
 *
 */
public class ReceivableServiceImpl implements ReceivableService {

	private final ServiceID service;
	private final ReceivableEvent[] receivableEvents;
	
	public ReceivableServiceImpl(ServiceID service,ReceivableEvent[] receivableEvents) {
		this.service = service;
		this.receivableEvents = receivableEvents;
	}
	
	public ReceivableEvent[] getReceivableEvents() {
		return receivableEvents;
	}

	public ServiceID getService() {
		return service;
	}

	@Override
	public int hashCode() {
		return service.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == this.getClass()) {
			return ((ReceivableServiceImpl)obj).service.equals(this.service);
		}
		else {
			return false;
		}
	}
}

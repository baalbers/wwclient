/* gvSIG. Geographic Information System of the Valencian Government
*
* Copyright (C) 2007-2008 Infrastructures and Transports Department
* of the Valencian Government (CIT)
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
* MA  02110-1301, USA.
*
*/

/*
* AUTHORS (In addition to CIT):
* 2009 IVER T.I   {{Task}}
*/

/**
 *
 */
package org.gvsig.tools.persistence.xml;

import java.io.InputStream;
import java.io.OutputStream;

import org.gvsig.tools.persistence.PersistentState;
import org.gvsig.tools.persistence.exception.PersistenceException;
import org.gvsig.tools.persistence.exception.PersistenceValidateExceptions;
import org.gvsig.tools.persistence.impl.AbstractPersistenceManager;
import org.gvsig.tools.persistence.impl.AbstractPersistentState;
import org.gvsig.tools.persistence.spi.PersistenceManagerServices;
import org.gvsig.tools.persistence.spi.PersistentContextServices;
import org.gvsig.tools.persistence.spi.PersistentIdentifier;
import org.gvsig.tools.persistence.spi.PersistentStateServices;
import org.kxml2.io.KXmlParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * @author jmvivo
 *
 */
public class XMLPersistenceManager extends AbstractPersistenceManager {

	private static final String VERSION = "2.0.0";

	class XMLPersistentState extends AbstractPersistentState {

		XMLPersistentState(PersistenceManagerServices manager, PersistentContextServices context, PersistentIdentifier id) {
			super(manager, context, id);
		}

	}

	public XMLPersistenceManager() {
		super();
	}
	

	public PersistentStateServices createPersistentState(	PersistentContextServices context, PersistentIdentifier id) {
		return new XMLPersistentState(this, context, id);
	}

	public PersistentState loadState(InputStream in)
			throws PersistenceException {
		PersistentContextServices context = this.getNewContext();

		XMLPersistentStateReader xmlReader = getReaderInstance();

		KXmlParser parser = new KXmlParser();

		try {
			parser.setInput(in, null);
		} catch (XmlPullParserException e) {
			throw new PersistenceException(e);
		}
		xmlReader.read(context, parser);

		return context.getRoot().getState();
	}

	public void saveState(PersistentState state, OutputStream out)
			throws PersistenceException, PersistenceValidateExceptions {
		XMLPersistentStateWriter xmlWriter = getWriterInstance();

		xmlWriter.write((PersistentStateServices) state, out);

	}

	protected XMLPersistentStateReader getReaderInstance(){
		return new XMLPersistentStateReader(this);
	}

	protected XMLPersistentStateWriter getWriterInstance() {
		return new XMLPersistentStateWriter(this);
	}

	public String version() {
		return VERSION;
	}


}

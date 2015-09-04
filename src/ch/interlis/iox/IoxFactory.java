/* This file is part of the iox project.
 * For more information, please see <http://www.eisenhutinformatik.ch/iox/>.
 *
 * Copyright (c) 2006 Eisenhut Informatik AG
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package ch.interlis.iox;

import ch.interlis.iom.IomObject;

/**
 * Factory for creating IomObjects.
 * An application may prefer to use specific java classes for a particular type instead of
 * a dynamic approach like IomObject. In that case it should create an implementation of this interface, that
 * creates the corresponding java object based on the provided type name.
 * @author ceis
 */
public interface IoxFactory {

	/**
	 * Create a IomObject with the given type and OID.
	 *
	 * @param type of object to create.
	 *        On top of the types defined by the transfer description, there are a few
	 *        predefined types invoked directly from the Interlis readers:<br><ul>
         *        <li>REF : Reference to another object defined by its REFOID.</li>
         *        <li>COORD : Coordinate object (2D or 3D).Contains attributes <code>C1</code>, <code>C2</code> and optionally <code>C2</code></li>
         *        <li>ARC : Arc midpoint coordinate object (always 2D). Contains attributes <code>A1</code> and <code>A2</code></li>
         *        <li>POLYLINE : Object representing a polyline. </code></li>
         *        <li>SEGMENTS : Container for the points of a polyline (<code>COORD</code> and <code>ARC</code> objects).
         *                       Contains an attribute named <code>segment</code> containing COORD's and ARC's.</li>
         *        <li>SURFACE : ? tbd</li>
         *        <li>BOUNDARY : ? tbd</li>
         *        <li>MULTISURFACE : ? tbd</li>
         *        <li>iom04.metamodel.* : Various model metadata</li>
	 *        </ul>
	 * @param oid may be <code>null</code>.
	 * @return null if the factory doesn't know how to create an object for given type.
	 */
	public IomObject createIomObject(String type, String oid) throws IoxException;

}

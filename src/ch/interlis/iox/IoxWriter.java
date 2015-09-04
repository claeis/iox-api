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

/** Interface to write a transfer file in object streaming mode.
 * Usage:
 * <pre>
 *  IoxWriter writer=...;
 *	writer.write(StartTransferEvent);
 *	...
 *  while(more baskets){
 *		writer.write(StartBasketEvent);
 *		...
 *		while(more objects){
 *  		...
 *			writer.write(ObjectEvent);
 *  		...
 *		}
 * 		...
 *		writer.write(EndBasketEvent);
 *  }
 *	writer.write(EndTransferEvent);
 * </pre>
 * @author ce
 * @version $Revision: 1.0 $ $Date: 28.06.2006 $
 */
public interface IoxWriter
{
	/** writes the next event to this writer. 
	 * The flow of events that a writer expects, is
	 * <pre>StartTransferEvent {StartBasketEvent {ObjectEvent} EndBasketEvent} EndTransferEvent</pre>
	 * @param event
	 * @throws IoxException
	 */
    void write(IoxEvent event)	throws IoxException;
	/** Frees any resources associated with this Writer. 
	 * This method closes the underlying output stream only, if it was opened by this writer.
	 */ 
	void close() throws IoxException;
	/** Writes any cached events to the underlying output mechanism.
	 */
	void flush() throws IoxException;
	/** sets the factory collection to be used. An implementation should intantiate with a 
	 *  default factory collection and not require a call to this function. 
	 */
	public void setFactory(IoxFactoryCollection factory)  throws IoxException;
	/** gets the current factory collection.
	 */
	public IoxFactoryCollection getFactory()  throws IoxException;
	/** creates a IomObject with the given type and oid.
	 * @param type of object to create
	 * @param oid may be null
	 * @return null if factory don know how to create object for given type.
	 */
	public IomObject createIomObject(String type,String oid)   throws IoxException;
}

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

import ch.interlis.iom.IomConstants;

/** start of a basket. What a basket is, depends on the transfer file format. 
 * In any format objects are surrounded by a StartBasketEvent/EndBasketEvent.
 * @author ce
 * @version $Revision: 1.0 $ $Date: 26.06.2006 $
 */
public interface StartBasketEvent extends IoxEvent {
	/** gets the identifier of this basket.
	 */
	String getBid();
	/** gets the consistency of this basket.
	 * @see IomConstants
	 */
	int getConsistency();
	/** gets the end state of this basket. 
	 * Only if kind==IOM_INITIAL or kind==IOM_UPDATE.
	 */
	String getEndstate();
	/** gets the transfer mode of this basket.
	 * IOM_FULL if not an incremental transfer.
	 * @see IomConstants
	 */
	int getKind();
	/** gets the start state of this basket. 
	 * Only if kind==IOM_UPDATE.
	 */
	String getStartstate();
	/** gets the sub-types of this basket's type, if it contains polymorphic content.
	 */
	String[] getTopicv();
	/** gets the type of this basket.
	 */
	String getType();
}

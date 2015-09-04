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
package ch.interlis.iom;

/** defines enumerations used by IOX.
 * <ul>
 * <li>values for the consistency of an object or a basket</li>
 * <li>values for the kind of a basket</li>
 * <li>values for the operation mode of an object</li>
 * </ul>
 * @author ceis
 *
 */
public interface IomConstants
{
	/** The object or basket is complete and unmodified.
	 */
    public static int IOM_COMPLETE = 0;
	/** The object or basket was stripped-down, because it's an extract.
	 */
	public static int IOM_INCOMPLETE = 1;
	/** The object or basket contains data that violates consistency rules, 
	 * because it was automatically merged from seperate sources.
	 */
	public static int IOM_INCONSISTENT = 2;
	/** The object or basket contains data that was modified by a merger tool to ensure consistency rules, 
	 * while it was automatically merged from seperate sources.
	 */
	public static int IOM_ADAPTED = 3;
    /** This is a new object.
     */
	public static int IOM_OP_INSERT = 0;
    /** This is a modifed object.
     */
	public static int IOM_OP_UPDATE = 1;
    /** This is an object that no longer exists.
     */
	public static int IOM_OP_DELETE = 2;
    /** This is a complete basket without persistent identifiers.  Only IOM_OP_INSERT allowed.
     */
	public static int IOM_FULL = 0;
    /** This is an update basket. This is only useful after an IOM_INITIAL basket. 
     */
	public static int IOM_UPDATE = 1;
    /** This is a complete basket with persistent identifiers. Only IOM_OP_INSERT allowed.
     */
	public static int IOM_INITIAL = 2;
}
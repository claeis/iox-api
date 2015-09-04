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

/** defines the generic object.
 * <ul>
 * <li>Each object has a type</li>
 * <li>Each object may have an identity</li>
 * <li>Each object has a set of properties</li>
 * <li>Each property has none, one or more values</li>
 * <li>A value is either primitive (String) or structured (IomObject; IomObject is a recursive structure)</li>
 * </ul>
 * The most important functions are:
 * <ul>
 * <li>getobjecttag() type of oject</li>
 * <li>getobjectoid() identity of object</li>
 * <li>getattrcount() number of properties</li>
 * <li>getattrvaluecount() number of values of a property</li>
 * <li>getattrvalue() value of property (if primitive)</li>
 * <li>getattrobj() value of property (if structured)</li>
 * </ul>
 * To test, if a property is primitve or structured, use
<pre><code>
if(obj.getattrvalue("attrname")==null){
     IomObject struct=obj.getattrobj("attrname",0);
}
</code></pre>
 * @author ce
 * @version $Revision: 1.0 $ $Date: 11.04.2006 $
 */
public interface IomObject {
	/** disposes the underlying native object.
	 * @deprecated
	 */
	public abstract void delete();
	/** gets the line of the object in the file, if read from a file.
	 */
	public abstract int getobjectline();
	/** sets the line of the object in the file, if read from a file.
	 */
	public abstract void setobjectline(int line);
	/** gets the column of the object in the file, if read from a file.
	 */
	public abstract int getobjectcol();
	/** sets the column of the object in the file, if read from a file.
	 */
	public abstract void setobjectcol(int col);
	/** gets the type of the object.
	 */
	public abstract String getobjecttag();
	/** sets the type of the object.
	 */
	public abstract void setobjecttag(String tag);
	/** gets the identifier of the object.
	 */
	public abstract String getobjectoid();
	/** sets the identifier of the object.
	 */
	public abstract void setobjectoid(String oid);
	/** gets the identifier of the referenced object, if this object is a reference value.
	 */
	public abstract String getobjectrefoid();
	/** sets the identifier of the referenced object, if this object is a reference value.
	 */
	public abstract void setobjectrefoid(String refoid);
	/** gets the identifier of the basket containing the referenced object, if this object is a reference value.
	 */
	public abstract String getobjectrefbid();
	/** sets the identifier of the basket containing the referenced object, if this object is a reference value.
	 */
	public abstract void setobjectrefbid(String refbid);
	/** gets the ordering index, if this object is a reference value of an ordered relationship.
	 * In ordered relationships the attribute ORDER_POS (value > 0!) defines the 
	 * absolute position of this reference in the ordered list of references that 
	 * are part of this transfer basket.
	 */
	public abstract long getobjectreforderpos();
	/** sets the ordering index, if this object is a reference value of an ordered relationship.
	 */
	public abstract void setobjectreforderpos(long orderPos);
	/** gets the operation mode (insert, update, delete) of this object.
	 * @deprecated
	 */
	public abstract int getobjectoperation();
	/** sets the operation mode (insert, update, delete) of this object.
	 * @deprecated
	 */
	public abstract void setobjectoperation(int operation);
	/** gets the consistency (complete, incomplete, inconsistent, adapted) of this object.
	 * @deprecated
	 */
	public abstract int getobjectconsistency();
	/** sets the consistency (complete, incomplete, inconsistent, adapted) of this object.
	 * @deprecated
	 */
	public abstract void setobjectconsistency(int consistency);
	/** gets the number of xml-subelements.
	 * @deprecated
	 */
	public abstract int getxmlelecount();
	/** gets the name of the xml-element with the given xml-element index.
	 * @deprecated
	 */
	public abstract String getxmleleattrname(int xmlEleIndex);
	/** gets the attribute value index of the xml-element with the given xml-element index.
	 * @deprecated
	 */
	public abstract int getxmlelevalueidx(int xmlEleIndex);
	/** gets the simple value of the xml-element with the given xml-element index.
	 * @return the value or null if not a simple value.
	 * @deprecated
	 */
	public abstract String getxmleleprim(int xmlEleIndex);
	/** gets the structured value of the xml-element with the given xml-element index.
	 * @deprecated
	 */
	public abstract IomObject getxmleleobj(int xmlEleIndex);
	/** gets the number of attributes of this object.
	 * This is not the same as the number of attributes of the class of this object.
	 * Together with getttrname() this function enables to query an object without knowing the class definition.
	 * <pre><code>
	 * for(int i=0;i&lt;obj.getattrcount();i++){
	 *   String propName=obj.getattrname(i);
	 *   String value=obj.getattrvalue(propName);
	 *   if(value!=null){
	 *      ...
	 *   }
	 * }
	 * </code></pre>
	 * @return gets the number of atrributes with at least one value.
	 */
	public abstract int getattrcount();
	/** gets an attribute name.
	 * Together with getttrcount() this function enables to query an object without knowing the class definition.
	 * <pre><code>
	 * for(int i=0;i&lt;obj.getattrcount();i++){
	 *   String propName=obj.getattrname(i);
	 *   String value=obj.getattrvalue(propName);
	 *   if(value!=null){
	 *      ...
	 *   }
	 * }
	 * </code></pre>
	 * @param index The index is opaque and only useable to enumerate all defined attributes of this object.
	 * @return the name of the attribute.
	 */
	public abstract String getattrname(int index);
	/** gets the number of values of a given attribute.
	 * @param attrName name of attribute
	 * @return number of values
	 */
	public abstract int getattrvaluecount(String attrName);
	/** gets the value of an attribute with a primitive type.
	 * @param attrName name of attribute
	 * @return primitive value
	 */
	public abstract String getattrvalue(String attrName);
	/** sets the value of an attribute with a primitve type.
	 * @param attrName name of attribute
	 * @param value new primitive value
	 */
	public abstract void setattrvalue(String attrName, String value);
	/** Removes any values for a given attribute.
	 * Sets it to NULL, UNDEFINED.
	 * @param attrName name of attribute
	 */
	public abstract void setattrundefined(String attrName);
	/** gets the value of an indexed attribute with a primitive type.
	 * @param attrName name of attribute
	 * @param index index of value to retrieve
	 * @return primitive value
	 */
	public abstract String getattrprim(String attrName, int index);
	/** gets the value of an indexed attribute with a structured type.
	 * @param attrName name of attribute
	 * @param index index of value to retrieve
	 * @return structured value
	 */
	public abstract IomObject getattrobj(String attrName, int index);
	/** @deprecated
	 */
	public abstract IomObject changeattrobj(
		String attrName,
		int index,
		String type);
	/** changes the value of an indexed attribute with a structured type.
	 * @param attrName name of attribute
	 * @param index index of value to change
	 * @param value new value
	 */
	public abstract void changeattrobj(
		String attrName,
		int index,
		IomObject value);
	/** @deprecated
	 */
	public abstract IomObject insertattrobj(
		String attrName,
		int index,
		String type);
	/** inserts a new value to an indexed attribute with a structured type.
	 * Shifts the value currently at that position (if any) and any 
	 * subsequent values to the right (adds one to their indices).
	 * @param attrName name of attribute
	 * @param index index at which the specified value is to be inserted
	 * @param value new value
	 */
	public abstract void insertattrobj(
		String attrName,
		int index,
		IomObject value);
	/** @deprecated
	 */
	public abstract IomObject addattrobj(String attrName, String type);
	/** appends a new value to an indexed attribute with a structured type.
	 * @param attrName name of attribute
	 * @param value new value
	 */
	public abstract void addattrobj(String attrName, IomObject value);
	/** removes a value from an indexed attibute with a structured type.
	 * @param attrName name of attribute
	 * @param index index ov value to remove
	 */
	public abstract void deleteattrobj(String attrName, int index);
}
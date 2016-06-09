package ch.interlis.iox;

import java.util.Set;

import ch.interlis.iom.IomObject;

/** Pool to pass data that a IoxReader can do some validation and the 
 * IoxValidator doesn't repeat them.
 * @author ceis
 *
 */
public interface IoxValidationDataPool extends IoxDataPool {
	public Set<String> getValidationIliQnames();
	public Set<String> getValidationNames(String iliQname);
	public boolean isValidationDone(String iliQname, String validationName);
	public void setValidationDone(String iliQname,String validationName,boolean done);
}

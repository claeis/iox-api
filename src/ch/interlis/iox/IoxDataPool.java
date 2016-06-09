package ch.interlis.iox;

import java.util.Set;

import ch.interlis.iom.IomObject;

/** Pool to hold (interlis) data and pass index structures from 
 * one processing step to the next.
 * @author ceis
 *
 */
public interface IoxDataPool {
	public void addDataObject(IomObject obj);
	public IomObject getDataObject(String tid);
	public IomObject getTargetDataObject(String sourceTid,String roleOrRefAttrName); // must know the model to do that
	
	public Set<String> getIntermediateValues();
	public Object getIntermediateValue(String valueName);
	public void setIntermediateValue(String valueName,Object value);
	/** sets the model.
	 * 
	 * @param td Interlis model.
	 */
	public void setModel(Object transferDescription);
}

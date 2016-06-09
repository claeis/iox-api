package ch.interlis.iox;

import java.util.Set;

/** ili-Model specific configuration, such as check multiplicity of a specific attribute. 
 * Use Settings for general, model independent, validator config.
 * 
 * @author ceis
 *
 */
public interface IoxValidationConfig {
	public Set<String> getIliQnames();
	public Set<String> getConfigParams(String iliQname);
	public String getConfigValue(String iliQname, String configParam);
	public void setConfigValue(String iliQname,String configParam,String value);
}

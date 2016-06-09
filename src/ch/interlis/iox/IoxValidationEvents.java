package ch.interlis.iox;

import java.util.List;

public interface IoxValidationEvents {
	public void addEvent(IoxValidationEvent ex);
	public void addError(IoxException ex);
	public void addWarning(IoxException ex);
	public List<IoxValidationEvent> getEvents();
	public void clearEvents();
}

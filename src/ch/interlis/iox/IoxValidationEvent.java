package ch.interlis.iox;

public interface IoxValidationEvent {
	public final static int ERROR=1;
	public final static int WARNING=2;
	public int getEventKind();
	public IoxException getException();
}

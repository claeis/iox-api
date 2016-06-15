package ch.interlis.iox;

import java.util.Date;

public interface IoxLogEvent {
	public final static int ERROR=7;
	public final static int WARNING=6;
	public final static int INFO=5;
	public final static int DETAIL_INFO=2;
	public int getEventKind();
	public Throwable getException();
	public StackTraceElement getOrigin();
	public String getEventMsg();
	public String getRawEventMsg();
	public Date getEventDateTime();
	public String getEventId();
	public String getDataSource();
	public Integer getSourceLineNr();
	public String getSourceObjectTag();
	public String getSourceObjectTechId();
	public String getSourceObjectXtfId();
	public String getSourceObjectUsrId();
	public String getModelEleQName();
	public Double getGeomC1();
	public Double getGeomC2();
	public Double getGeomC3();
}

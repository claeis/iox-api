package ch.interlis.iox;

/** main validator interface.
 * 
 * @author ceis
 *
 */
public interface IoxValidator {
	/** adds a data event to the validator.
	 * Validation might happen immediately or later, at last when 
	 * EndTransferEvent is received.
	 * Validation errors are added to the error collector.
	 * @param event
	 */
	public void validate(IoxEvent event);
	/** frees/closes any resources.
	 * Aborts validation, doesn't continue/finish validation.
	 * Validation must be finished when receiving the EndTransferEvent.
	 */
	public void close();
	/** get the error collector.
	 * 
	 * @return the error collector
	 */
	public IoxLogging getLoggingHandler();
	public void setLoggingHandler(IoxLogging errs);
	/** gets the data pool.
	 * 
	 * @return the data pool
	 */
	public IoxValidationDataPool getDataPool();
}

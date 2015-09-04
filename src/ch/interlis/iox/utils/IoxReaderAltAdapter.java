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
package ch.interlis.iox.utils;

import ch.interlis.iom.IomObject;
import ch.interlis.iox.EndBasketEvent;
import ch.interlis.iox.EndTransferEvent;
import ch.interlis.iox.IoxEvent;
import ch.interlis.iox.IoxException;
import ch.interlis.iox.IoxReader;
import ch.interlis.iox.IoxReaderAlt;
import ch.interlis.iox.ObjectEvent;
import ch.interlis.iox.StartBasketEvent;
import ch.interlis.iox.StartTransferEvent;

/** Adapter to read a transfer file in 
 * an alternative streaming mode.
 * @author ce
 * @version $Revision: 1.0 $ $Date: 28.06.2006 $
 */
public class IoxReaderAltAdapter implements IoxReaderAlt {
	private IoxReader is=null;
	private int state=0;
	public IoxReaderAltAdapter(IoxReader in)
	{
		is=in;
		state=0;
	}
	public StartTransferEvent readHeader()
	throws IoxException
	{
		if(state==0){
			IoxEvent event=null;
			event=is.read();
			// empty file?
			if(event==null){
				return null;
			}
			if(event instanceof StartTransferEvent){
				state=20;
				return (StartTransferEvent)event;
			}
			throw new IoxException("unexpected event type "+event.getClass().getName());
		}
		throw new IllegalStateException();
	}
	public StartBasketEvent readBasket()
	throws IoxException
	{
		if(state==20){
			IoxEvent event=null;
			event=is.read();
			if(event instanceof EndTransferEvent){
				state=0;
				return null;
			}
			if(event instanceof StartBasketEvent){
				state=30;
				return (StartBasketEvent)event;
			}
			throw new IoxException("unexpected event type "+event.getClass().getName());
		}
		throw new IllegalStateException();
	}
	public IomObject readObject()
	throws IoxException
	{
		if(state==30){
			IoxEvent event=null;
			event=is.read();
			if(event instanceof ObjectEvent){
				state=30;
				return ((ObjectEvent)event).getIomObject();
			}
			if(event instanceof EndBasketEvent){
				state=20;
				return null;
			}
			throw new IoxException("unexpected event type "+event.getClass().getName());
		}
		throw new IllegalStateException();
	}
	public void close()
	throws IoxException
	{
		if(is!=null){
			is=null;
		}
		state=0;
	}
	/* TODO move to new test class
	public static void main(String args[])
	{
		EhiLogger.getInstance().setTraceFiler(false);
		try{
			IoxReaderAlt reader=new IoxReaderAltAdapter(new ItfReader(new java.io.FileInputStream(args[0])));
			StartTransferEvent header=reader.readHeader();
			if(header!=null){
				StartBasketEvent basket;
				while((basket=reader.readBasket())!=null){
					System.out.println("topic "+basket.getType()+", bid "+basket.getBid());
					IomObject iomObj;
					while((iomObj=reader.readObject())!=null){
						// System.out.println("class "+iomObj.getobjecttag()+", oid "+iomObj.getobjectoid());
					}
				}
			}
		}catch(Exception ex){
			EhiLogger.logError(ex);
		}
	}
	*/
}

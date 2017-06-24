package test;

public class PersistMessageHandler implements SOAPHandler<SOAPMessageContext> {
	public static final String PERSISTENCE_DIR_PROP = "samples.persistence.directory";

	public Set<QName> getHeaders() {
		return null;
	}

	public boolean handleMessage(SOAPMessageContext ctxt) {
	    System.out.println("Entered PersistMessageHandler.handleMessage");
	    //  return if inbound message
	    if ( !((Boolean)ctxt.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)).
	        booleanValue()) { return true; }
	    SOAPMessage msg = ctxt.getMessage();
	    File persistenceDir = (File) ctxt.get(PERSISTENCE_DIR_PROP);
	    Iterator itr;
	    try {
	      itr = msg.getSOAPHeader().examineAllHeaderElements();
	      String msgId = null;
	    }
	    while (itr.hasNext() && msgId == null) {
	        SOAPHeaderElement headerElt = (SOAPHeaderElement) itr.next();
	        QName headerQName = headerElt.getElementQName();
	        if (headerQName.equals(AddMessageIdHandler.MSGID_HEADER)) {
	          msgId = headerElt.getAttribute("id");
	        }
	      }
	      if ( msgId == null ) {
	        System.out.println("No message ID header.");
	        return false;
	      }
	      File msgFile = new File(persistenceDir, msgId+".xml");
	      msgFile.createNewFile();
	      msg.writeTo(new FileOutputStream(msgFile));
	    }catch(

	Exception e)
	{
	      e.printStackTrace();
	      return false;
	    }return true;
}}
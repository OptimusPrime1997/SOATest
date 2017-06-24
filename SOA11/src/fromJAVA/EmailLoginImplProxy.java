package fromJAVA;

public class EmailLoginImplProxy implements fromJAVA.EmailLoginImpl {
  private String _endpoint = null;
  private fromJAVA.EmailLoginImpl emailLoginImpl = null;
  
  public EmailLoginImplProxy() {
    _initEmailLoginImplProxy();
  }
  
  public EmailLoginImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmailLoginImplProxy();
  }
  
  private void _initEmailLoginImplProxy() {
    try {
      emailLoginImpl = (new fromJAVA.EmailLoginImplServiceLocator()).getEmailLoginImplPort();
      if (emailLoginImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)emailLoginImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)emailLoginImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (emailLoginImpl != null)
      ((javax.xml.rpc.Stub)emailLoginImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fromJAVA.EmailLoginImpl getEmailLoginImpl() {
    if (emailLoginImpl == null)
      _initEmailLoginImplProxy();
    return emailLoginImpl;
  }
  
  public java.lang.String emailLogin(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (emailLoginImpl == null)
      _initEmailLoginImplProxy();
    return emailLoginImpl.emailLogin(arg0, arg1);
  }
  
  
}
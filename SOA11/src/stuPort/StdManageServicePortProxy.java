package stuPort;

public class StdManageServicePortProxy implements stuPort.StdManageServicePort {
  private String _endpoint = null;
  private stuPort.StdManageServicePort stdManageServicePort = null;
  
  public StdManageServicePortProxy() {
    _initStdManageServicePortProxy();
  }
  
  public StdManageServicePortProxy(String endpoint) {
    _endpoint = endpoint;
    _initStdManageServicePortProxy();
  }
  
  private void _initStdManageServicePortProxy() {
    try {
      stdManageServicePort = (new stuPort.StdManageServiceLocator()).getstdManageServicePort();
      if (stdManageServicePort != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)stdManageServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)stdManageServicePort)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (stdManageServicePort != null)
      ((javax.xml.rpc.Stub)stdManageServicePort)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public stuPort.StdManageServicePort getStdManageServicePort() {
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort;
  }
  
  public java.lang.String deleteStd(java.lang.String arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.deleteStd(arg0);
  }
  
  public stuPort.StudentType queryStd(java.lang.String arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.queryStd(arg0);
  }
  
  public stuPort.CourseScoreType[] searchStdScore(java.lang.String arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.searchStdScore(arg0);
  }
  
  public java.lang.String addStd(stuPort.StudentType arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.addStd(arg0);
  }
  
  public java.lang.String updateStd(stuPort.StudentType arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.updateStd(arg0);
  }
  
  public stuPort.CourseScoreType[] updateStdScore(stuPort.CourseScoreType[] arg0) throws java.rmi.RemoteException{
    if (stdManageServicePort == null)
      _initStdManageServicePortProxy();
    return stdManageServicePort.updateStdScore(arg0);
  }
  
  
}
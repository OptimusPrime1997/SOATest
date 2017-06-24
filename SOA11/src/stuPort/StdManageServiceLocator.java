/**
 * StdManageServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;

public class StdManageServiceLocator extends org.apache.axis.client.Service implements stuPort.StdManageService {

    public StdManageServiceLocator() {
    }


    public StdManageServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StdManageServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for stdManageServicePort
    private java.lang.String stdManageServicePort_address = "http://localhost:8081/stdManageService";

    public java.lang.String getstdManageServicePortAddress() {
        return stdManageServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String stdManageServicePortWSDDServiceName = "stdManageServicePort";

    public java.lang.String getstdManageServicePortWSDDServiceName() {
        return stdManageServicePortWSDDServiceName;
    }

    public void setstdManageServicePortWSDDServiceName(java.lang.String name) {
        stdManageServicePortWSDDServiceName = name;
    }

    public stuPort.StdManageServicePort getstdManageServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(stdManageServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getstdManageServicePort(endpoint);
    }

    public stuPort.StdManageServicePort getstdManageServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            stuPort.StdManageServicePortBindingStub _stub = new stuPort.StdManageServicePortBindingStub(portAddress, this);
            _stub.setPortName(getstdManageServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setstdManageServicePortEndpointAddress(java.lang.String address) {
        stdManageServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (stuPort.StdManageServicePort.class.isAssignableFrom(serviceEndpointInterface)) {
                stuPort.StdManageServicePortBindingStub _stub = new stuPort.StdManageServicePortBindingStub(new java.net.URL(stdManageServicePort_address), this);
                _stub.setPortName(getstdManageServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("stdManageServicePort".equals(inputPortName)) {
            return getstdManageServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "stdManageService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "stdManageServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("stdManageServicePort".equals(portName)) {
            setstdManageServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

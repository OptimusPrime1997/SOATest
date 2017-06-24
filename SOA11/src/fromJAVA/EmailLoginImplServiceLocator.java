/**
 * EmailLoginImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fromJAVA;

public class EmailLoginImplServiceLocator extends org.apache.axis.client.Service implements fromJAVA.EmailLoginImplService {

    public EmailLoginImplServiceLocator() {
    }


    public EmailLoginImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmailLoginImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmailLoginImplPort
    private java.lang.String EmailLoginImplPort_address = "http://localhost:8080/assignment10/services/EmailLoginPort";

    public java.lang.String getEmailLoginImplPortAddress() {
        return EmailLoginImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmailLoginImplPortWSDDServiceName = "EmailLoginImplPort";

    public java.lang.String getEmailLoginImplPortWSDDServiceName() {
        return EmailLoginImplPortWSDDServiceName;
    }

    public void setEmailLoginImplPortWSDDServiceName(java.lang.String name) {
        EmailLoginImplPortWSDDServiceName = name;
    }

    public fromJAVA.EmailLoginImpl getEmailLoginImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmailLoginImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmailLoginImplPort(endpoint);
    }

    public fromJAVA.EmailLoginImpl getEmailLoginImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            fromJAVA.EmailLoginImplPortBindingStub _stub = new fromJAVA.EmailLoginImplPortBindingStub(portAddress, this);
            _stub.setPortName(getEmailLoginImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmailLoginImplPortEndpointAddress(java.lang.String address) {
        EmailLoginImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (fromJAVA.EmailLoginImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                fromJAVA.EmailLoginImplPortBindingStub _stub = new fromJAVA.EmailLoginImplPortBindingStub(new java.net.URL(EmailLoginImplPort_address), this);
                _stub.setPortName(getEmailLoginImplPortWSDDServiceName());
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
        if ("EmailLoginImplPort".equals(inputPortName)) {
            return getEmailLoginImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://fromJAVA/", "EmailLoginImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://fromJAVA/", "EmailLoginImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmailLoginImplPort".equals(portName)) {
            setEmailLoginImplPortEndpointAddress(address);
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

/**
 * StdNotFoundFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment7.wsdlservice.test;

public class StdNotFoundFault extends java.lang.Exception {
    private static final long serialVersionUID = 1497289016382L;
    private assignment7.wsdlservice.test.StdManageServiceStub.TargetNotFound faultMessage;

    public StdNotFoundFault() {
        super("StdNotFoundFault");
    }

    public StdNotFoundFault(java.lang.String s) {
        super(s);
    }

    public StdNotFoundFault(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public StdNotFoundFault(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        assignment7.wsdlservice.test.StdManageServiceStub.TargetNotFound msg) {
        faultMessage = msg;
    }

    public assignment7.wsdlservice.test.StdManageServiceStub.TargetNotFound getFaultMessage() {
        return faultMessage;
    }
}

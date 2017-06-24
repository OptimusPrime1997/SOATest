/**
 * OtherFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment7.wsdlservice.test;

public class OtherFault extends java.lang.Exception {
    private static final long serialVersionUID = 1497289016347L;
    private assignment7.wsdlservice.test.StdManageServiceStub.OtherError faultMessage;

    public OtherFault() {
        super("OtherFault");
    }

    public OtherFault(java.lang.String s) {
        super(s);
    }

    public OtherFault(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public OtherFault(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        assignment7.wsdlservice.test.StdManageServiceStub.OtherError msg) {
        faultMessage = msg;
    }

    public assignment7.wsdlservice.test.StdManageServiceStub.OtherError getFaultMessage() {
        return faultMessage;
    }
}

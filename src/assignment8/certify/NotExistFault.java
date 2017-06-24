/**
 * NotExistFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment8.certify;

public class NotExistFault extends java.lang.Exception {
    private static final long serialVersionUID = 1497460452308L;
    private assignment8.certify.NotExistFault faultMessage;

    public NotExistFault() {
        super("NotExistFault");
    }

    public NotExistFault(java.lang.String s) {
        super(s);
    }

    public NotExistFault(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public NotExistFault(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        assignment8.certify.CertifyStudentServiceStub.NotExistFault msg) {
        faultMessage = msg;
    }

    public assignment8.certify.NotExistFault getFaultMessage() {
        return faultMessage;
    }
}

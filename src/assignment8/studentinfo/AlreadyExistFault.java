/**
 * AlreadyExistFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment8.studentinfo;

public class AlreadyExistFault extends java.lang.Exception {
    private static final long serialVersionUID = 1497460308743L;
    private assignment8.studentinfo.AlreadyExistFault faultMessage;

    public AlreadyExistFault() {
        super("AlreadyExistFault");
    }

    public AlreadyExistFault(java.lang.String s) {
        super(s);
    }

    public AlreadyExistFault(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public AlreadyExistFault(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        assignment8.studentinfo.StudentInfoServiceStub.AlreadyExistFault msg) {
        faultMessage = msg;
    }

    public assignment8.studentinfo.AlreadyExistFault getFaultMessage() {
        return faultMessage;
    }
}

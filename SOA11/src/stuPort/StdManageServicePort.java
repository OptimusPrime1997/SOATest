/**
 * StdManageServicePort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;

import javax.jws.WebService;

@WebService
public interface StdManageServicePort extends java.rmi.Remote {
    public java.lang.String addStd(stuPort.StudentType arg0) throws java.rmi.RemoteException;
    public java.lang.String updateStd(stuPort.StudentType arg0) throws java.rmi.RemoteException;
    public java.lang.String deleteStd(java.lang.String arg0) throws java.rmi.RemoteException;
    public stuPort.StudentType queryStd(java.lang.String arg0) throws java.rmi.RemoteException;
    public stuPort.CourseScoreType[] updateStdScore(stuPort.CourseScoreType[] arg0) throws java.rmi.RemoteException;
    public stuPort.CourseScoreType[] searchStdScore(java.lang.String arg0) throws java.rmi.RemoteException;
}

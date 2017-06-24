/**
 * StudentInfoServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment8.studentinfo;


/**
 *  StudentInfoServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class StudentInfoServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public StudentInfoServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public StudentInfoServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for modifyStudentInfo method
     * override this method for handling normal response from modifyStudentInfo operation
     */
    public void receiveResultmodifyStudentInfo() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from modifyStudentInfo operation
     */
    public void receiveErrormodifyStudentInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteStudentInfo method
     * override this method for handling normal response from deleteStudentInfo operation
     */
    public void receiveResultdeleteStudentInfo() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteStudentInfo operation
     */
    public void receiveErrordeleteStudentInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addStudentInfo method
     * override this method for handling normal response from addStudentInfo operation
     */
    public void receiveResultaddStudentInfo() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addStudentInfo operation
     */
    public void receiveErroraddStudentInfo(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getStudentInfo method
     * override this method for handling normal response from getStudentInfo operation
     */
    public void receiveResultgetStudentInfo(
        assignment8.studentinfo.StudentInfoServiceStub.Student result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getStudentInfo operation
     */
    public void receiveErrorgetStudentInfo(java.lang.Exception e) {
    }
}

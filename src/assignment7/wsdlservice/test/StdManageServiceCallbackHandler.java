/**
 * StdManageServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.5  Built on : May 06, 2017 (03:45:26 BST)
 */
package assignment7.wsdlservice.test;


/**
 *  StdManageServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class StdManageServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public StdManageServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public StdManageServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for updateStd method
     * override this method for handling normal response from updateStd operation
     */
    public void receiveResultupdateStd() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateStd operation
     */
    public void receiveErrorupdateStd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for queryStd method
     * override this method for handling normal response from queryStd operation
     */
    public void receiveResultqueryStd(
        assignment7.wsdlservice.test.StdManageServiceStub.Student result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from queryStd operation
     */
    public void receiveErrorqueryStd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for searchStdScore method
     * override this method for handling normal response from searchStdScore operation
     */
    public void receiveResultsearchStdScore(
        assignment7.wsdlservice.test.StdManageServiceStub.CourseScoreList result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from searchStdScore operation
     */
    public void receiveErrorsearchStdScore(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for addStd method
     * override this method for handling normal response from addStd operation
     */
    public void receiveResultaddStd() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from addStd operation
     */
    public void receiveErroraddStd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteStd method
     * override this method for handling normal response from deleteStd operation
     */
    public void receiveResultdeleteStd() {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteStd operation
     */
    public void receiveErrordeleteStd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for updateStdScore method
     * override this method for handling normal response from updateStdScore operation
     */
    public void receiveResultupdateStdScore(
        assignment7.wsdlservice.test.StdManageServiceStub.CourseScoreList result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateStdScore operation
     */
    public void receiveErrorupdateStdScore(java.lang.Exception e) {
    }
}

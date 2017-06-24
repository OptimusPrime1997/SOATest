/**
 * ScoreType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;

public class ScoreType  implements java.io.Serializable {
    private java.lang.String realScore;

    private java.lang.String studentNo;

    public ScoreType() {
    }

    public ScoreType(
           java.lang.String realScore,
           java.lang.String studentNo) {
           this.realScore = realScore;
           this.studentNo = studentNo;
    }


    /**
     * Gets the realScore value for this ScoreType.
     * 
     * @return realScore
     */
    public java.lang.String getRealScore() {
        return realScore;
    }


    /**
     * Sets the realScore value for this ScoreType.
     * 
     * @param realScore
     */
    public void setRealScore(java.lang.String realScore) {
        this.realScore = realScore;
    }


    /**
     * Gets the studentNo value for this ScoreType.
     * 
     * @return studentNo
     */
    public java.lang.String getStudentNo() {
        return studentNo;
    }


    /**
     * Sets the studentNo value for this ScoreType.
     * 
     * @param studentNo
     */
    public void setStudentNo(java.lang.String studentNo) {
        this.studentNo = studentNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ScoreType)) return false;
        ScoreType other = (ScoreType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.realScore==null && other.getRealScore()==null) || 
             (this.realScore!=null &&
              this.realScore.equals(other.getRealScore()))) &&
            ((this.studentNo==null && other.getStudentNo()==null) || 
             (this.studentNo!=null &&
              this.studentNo.equals(other.getStudentNo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRealScore() != null) {
            _hashCode += getRealScore().hashCode();
        }
        if (getStudentNo() != null) {
            _hashCode += getStudentNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ScoreType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "scoreType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realScore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realScore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studentNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "studentNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

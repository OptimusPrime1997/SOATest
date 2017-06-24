/**
 * CourseScoreType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;


public class CourseScoreType  implements java.io.Serializable {
	
	 private java.lang.String courseNo;

	 private stuPort.ScoreType score;

	 private java.lang.String scoreType;
	
    public CourseScoreType() {
    }

    public CourseScoreType(
           java.lang.String courseNo,
           stuPort.ScoreType score,
           java.lang.String scoreType) {
           this.courseNo = courseNo;
           this.score = score;
           this.scoreType = scoreType;
    }


    /**
     * Gets the courseNo value for this CourseScoreType.
     * 
     * @return courseNo
     */
    public java.lang.String getCourseNo() {
        return courseNo;
    }


    /**
     * Sets the courseNo value for this CourseScoreType.
     * 
     * @param courseNo
     */
    public void setCourseNo(java.lang.String courseNo) {
        this.courseNo = courseNo;
    }


    /**
     * Gets the score value for this CourseScoreType.
     * 
     * @return score
     */
    public stuPort.ScoreType getScore() {
        return score;
    }


    /**
     * Sets the score value for this CourseScoreType.
     * 
     * @param score
     */
    public void setScore(stuPort.ScoreType score) {
        this.score = score;
    }


    /**
     * Gets the scoreType value for this CourseScoreType.
     * 
     * @return scoreType
     */
    public java.lang.String getScoreType() {
        return scoreType;
    }


    /**
     * Sets the scoreType value for this CourseScoreType.
     * 
     * @param scoreType
     */
    public void setScoreType(java.lang.String scoreType) {
        this.scoreType = scoreType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CourseScoreType)) return false;
        CourseScoreType other = (CourseScoreType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.courseNo==null && other.getCourseNo()==null) || 
             (this.courseNo!=null &&
              this.courseNo.equals(other.getCourseNo()))) &&
            ((this.score==null && other.getScore()==null) || 
             (this.score!=null &&
              this.score.equals(other.getScore()))) &&
            ((this.scoreType==null && other.getScoreType()==null) || 
             (this.scoreType!=null &&
              this.scoreType.equals(other.getScoreType())));
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
        if (getCourseNo() != null) {
            _hashCode += getCourseNo().hashCode();
        }
        if (getScore() != null) {
            _hashCode += getScore().hashCode();
        }
        if (getScoreType() != null) {
            _hashCode += getScoreType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CourseScoreType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "courseScoreType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "courseNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "scoreType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("scoreType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "scoreType"));
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

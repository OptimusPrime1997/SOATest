/**
 * StudentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudentType", propOrder = {

})
@XmlRootElement
public class StudentType  implements java.io.Serializable {
	
	@XmlElement(name = "CourseScoreList", required = true)
	private CourseScoreType[] courseScoreList;
	@XmlElement(name = "Grade", required = true)
	private String grade;
	@XmlElement(name = "IndividualBaseInfo", required = true)
	private IndividualBaseInfoType individualBaseInfo;
	@XmlElement(name = "StudentNo", required = true)
	private String studentNo;

	
    public StudentType() {
    }

    public StudentType(
           stuPort.CourseScoreType[] courseScoreList,
           java.lang.String grade,
           stuPort.IndividualBaseInfoType individualBaseInfo,
           java.lang.String studentNo) {
           this.courseScoreList = courseScoreList;
           this.grade = grade;
           this.individualBaseInfo = individualBaseInfo;
           this.studentNo = studentNo;
    }


    /**
     * Gets the courseScoreList value for this StudentType.
     * 
     * @return courseScoreList
     */
    public stuPort.CourseScoreType[] getCourseScoreList() {
        return courseScoreList;
    }


    /**
     * Sets the courseScoreList value for this StudentType.
     * 
     * @param courseScoreList
     */
    public void setCourseScoreList(stuPort.CourseScoreType[] courseScoreList) {
        this.courseScoreList = courseScoreList;
    }

    public stuPort.CourseScoreType getCourseScoreList(int i) {
        return this.courseScoreList[i];
    }

    public void setCourseScoreList(int i, stuPort.CourseScoreType _value) {
        this.courseScoreList[i] = _value;
    }


    /**
     * Gets the grade value for this StudentType.
     * 
     * @return grade
     */
    public java.lang.String getGrade() {
        return grade;
    }


    /**
     * Sets the grade value for this StudentType.
     * 
     * @param grade
     */
    public void setGrade(java.lang.String grade) {
        this.grade = grade;
    }


    /**
     * Gets the individualBaseInfo value for this StudentType.
     * 
     * @return individualBaseInfo
     */
    public stuPort.IndividualBaseInfoType getIndividualBaseInfo() {
        return individualBaseInfo;
    }


    /**
     * Sets the individualBaseInfo value for this StudentType.
     * 
     * @param individualBaseInfo
     */
    public void setIndividualBaseInfo(stuPort.IndividualBaseInfoType individualBaseInfo) {
        this.individualBaseInfo = individualBaseInfo;
    }


    /**
     * Gets the studentNo value for this StudentType.
     * 
     * @return studentNo
     */
    public java.lang.String getStudentNo() {
        return studentNo;
    }


    /**
     * Sets the studentNo value for this StudentType.
     * 
     * @param studentNo
     */
    public void setStudentNo(java.lang.String studentNo) {
        this.studentNo = studentNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StudentType)) return false;
        StudentType other = (StudentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.courseScoreList==null && other.getCourseScoreList()==null) || 
             (this.courseScoreList!=null &&
              java.util.Arrays.equals(this.courseScoreList, other.getCourseScoreList()))) &&
            ((this.grade==null && other.getGrade()==null) || 
             (this.grade!=null &&
              this.grade.equals(other.getGrade()))) &&
            ((this.individualBaseInfo==null && other.getIndividualBaseInfo()==null) || 
             (this.individualBaseInfo!=null &&
              this.individualBaseInfo.equals(other.getIndividualBaseInfo()))) &&
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
        if (getCourseScoreList() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCourseScoreList());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCourseScoreList(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGrade() != null) {
            _hashCode += getGrade().hashCode();
        }
        if (getIndividualBaseInfo() != null) {
            _hashCode += getIndividualBaseInfo().hashCode();
        }
        if (getStudentNo() != null) {
            _hashCode += getStudentNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StudentType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "studentType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("courseScoreList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "courseScoreList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "courseScoreType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("grade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "grade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("individualBaseInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "individualBaseInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "individualBaseInfoType"));
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

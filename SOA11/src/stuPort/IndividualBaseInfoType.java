/**
 * IndividualBaseInfoType.java
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
@XmlType(name = "EmailLoginType", propOrder = {

})
@XmlRootElement
public class IndividualBaseInfoType  implements java.io.Serializable {
	
	@XmlElement(name = "DepartmentAttribute", required = true)
	private String departmentAttribute;
	@XmlElement(name = "DepartmentDescribe", required = true)
	private String departmentDescribe;
	@XmlElement(name = "DepartmentManager", required = true)
	private String departmentManager;
	@XmlElement(name = "DepartmentName", required = true)
	private String departmentName;
	@XmlElement(name = "DepartmentNo", required = true)
	private String departmentNo;
	
    private java.lang.String address;

    private java.lang.String birth;

    private stuPort.DepartmentType department;

    private java.lang.String educationBackground;

    private java.lang.String id;

    private java.lang.String maritalStatus;

    private java.lang.String name;

    private java.lang.String phoneNum;

    private java.lang.String sex;

    public IndividualBaseInfoType() {
    }

    public IndividualBaseInfoType(
           java.lang.String address,
           java.lang.String birth,
           stuPort.DepartmentType department,
           java.lang.String educationBackground,
           java.lang.String id,
           java.lang.String maritalStatus,
           java.lang.String name,
           java.lang.String phoneNum,
           java.lang.String sex) {
           this.address = address;
           this.birth = birth;
           this.department = department;
           this.educationBackground = educationBackground;
           this.id = id;
           this.maritalStatus = maritalStatus;
           this.name = name;
           this.phoneNum = phoneNum;
           this.sex = sex;
    }


    /**
     * Gets the address value for this IndividualBaseInfoType.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this IndividualBaseInfoType.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the birth value for this IndividualBaseInfoType.
     * 
     * @return birth
     */
    public java.lang.String getBirth() {
        return birth;
    }


    /**
     * Sets the birth value for this IndividualBaseInfoType.
     * 
     * @param birth
     */
    public void setBirth(java.lang.String birth) {
        this.birth = birth;
    }


    /**
     * Gets the department value for this IndividualBaseInfoType.
     * 
     * @return department
     */
    public stuPort.DepartmentType getDepartment() {
        return department;
    }


    /**
     * Sets the department value for this IndividualBaseInfoType.
     * 
     * @param department
     */
    public void setDepartment(stuPort.DepartmentType department) {
        this.department = department;
    }


    /**
     * Gets the educationBackground value for this IndividualBaseInfoType.
     * 
     * @return educationBackground
     */
    public java.lang.String getEducationBackground() {
        return educationBackground;
    }


    /**
     * Sets the educationBackground value for this IndividualBaseInfoType.
     * 
     * @param educationBackground
     */
    public void setEducationBackground(java.lang.String educationBackground) {
        this.educationBackground = educationBackground;
    }


    /**
     * Gets the id value for this IndividualBaseInfoType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this IndividualBaseInfoType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the maritalStatus value for this IndividualBaseInfoType.
     * 
     * @return maritalStatus
     */
    public java.lang.String getMaritalStatus() {
        return maritalStatus;
    }


    /**
     * Sets the maritalStatus value for this IndividualBaseInfoType.
     * 
     * @param maritalStatus
     */
    public void setMaritalStatus(java.lang.String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }


    /**
     * Gets the name value for this IndividualBaseInfoType.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this IndividualBaseInfoType.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the phoneNum value for this IndividualBaseInfoType.
     * 
     * @return phoneNum
     */
    public java.lang.String getPhoneNum() {
        return phoneNum;
    }


    /**
     * Sets the phoneNum value for this IndividualBaseInfoType.
     * 
     * @param phoneNum
     */
    public void setPhoneNum(java.lang.String phoneNum) {
        this.phoneNum = phoneNum;
    }


    /**
     * Gets the sex value for this IndividualBaseInfoType.
     * 
     * @return sex
     */
    public java.lang.String getSex() {
        return sex;
    }


    /**
     * Sets the sex value for this IndividualBaseInfoType.
     * 
     * @param sex
     */
    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IndividualBaseInfoType)) return false;
        IndividualBaseInfoType other = (IndividualBaseInfoType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.birth==null && other.getBirth()==null) || 
             (this.birth!=null &&
              this.birth.equals(other.getBirth()))) &&
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment()))) &&
            ((this.educationBackground==null && other.getEducationBackground()==null) || 
             (this.educationBackground!=null &&
              this.educationBackground.equals(other.getEducationBackground()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.maritalStatus==null && other.getMaritalStatus()==null) || 
             (this.maritalStatus!=null &&
              this.maritalStatus.equals(other.getMaritalStatus()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.phoneNum==null && other.getPhoneNum()==null) || 
             (this.phoneNum!=null &&
              this.phoneNum.equals(other.getPhoneNum()))) &&
            ((this.sex==null && other.getSex()==null) || 
             (this.sex!=null &&
              this.sex.equals(other.getSex())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getBirth() != null) {
            _hashCode += getBirth().hashCode();
        }
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        if (getEducationBackground() != null) {
            _hashCode += getEducationBackground().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getMaritalStatus() != null) {
            _hashCode += getMaritalStatus().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPhoneNum() != null) {
            _hashCode += getPhoneNum().hashCode();
        }
        if (getSex() != null) {
            _hashCode += getSex().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IndividualBaseInfoType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "individualBaseInfoType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birth");
        elemField.setXmlName(new javax.xml.namespace.QName("", "birth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department");
        elemField.setXmlName(new javax.xml.namespace.QName("", "department"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "departmentType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("educationBackground");
        elemField.setXmlName(new javax.xml.namespace.QName("", "educationBackground"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maritalStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maritalStatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phoneNum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phoneNum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sex");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sex"));
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

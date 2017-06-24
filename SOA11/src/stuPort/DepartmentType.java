/**
 * DepartmentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package stuPort;


public class DepartmentType  implements java.io.Serializable {
	
	private java.lang.String departmentAttribute;

    private java.lang.String departmentDescribe;

    private java.lang.String departmentManager;

    private java.lang.String departmentName;

    private java.lang.String departmentNo;
	

    public DepartmentType() {
    }

    public DepartmentType(
           java.lang.String departmentAttribute,
           java.lang.String departmentDescribe,
           java.lang.String departmentManager,
           java.lang.String departmentName,
           java.lang.String departmentNo) {
           this.departmentAttribute = departmentAttribute;
           this.departmentDescribe = departmentDescribe;
           this.departmentManager = departmentManager;
           this.departmentName = departmentName;
           this.departmentNo = departmentNo;
    }


    /**
     * Gets the departmentAttribute value for this DepartmentType.
     * 
     * @return departmentAttribute
     */
    public java.lang.String getDepartmentAttribute() {
        return departmentAttribute;
    }


    /**
     * Sets the departmentAttribute value for this DepartmentType.
     * 
     * @param departmentAttribute
     */
    public void setDepartmentAttribute(java.lang.String departmentAttribute) {
        this.departmentAttribute = departmentAttribute;
    }


    /**
     * Gets the departmentDescribe value for this DepartmentType.
     * 
     * @return departmentDescribe
     */
    public java.lang.String getDepartmentDescribe() {
        return departmentDescribe;
    }


    /**
     * Sets the departmentDescribe value for this DepartmentType.
     * 
     * @param departmentDescribe
     */
    public void setDepartmentDescribe(java.lang.String departmentDescribe) {
        this.departmentDescribe = departmentDescribe;
    }


    /**
     * Gets the departmentManager value for this DepartmentType.
     * 
     * @return departmentManager
     */
    public java.lang.String getDepartmentManager() {
        return departmentManager;
    }


    /**
     * Sets the departmentManager value for this DepartmentType.
     * 
     * @param departmentManager
     */
    public void setDepartmentManager(java.lang.String departmentManager) {
        this.departmentManager = departmentManager;
    }


    /**
     * Gets the departmentName value for this DepartmentType.
     * 
     * @return departmentName
     */
    public java.lang.String getDepartmentName() {
        return departmentName;
    }


    /**
     * Sets the departmentName value for this DepartmentType.
     * 
     * @param departmentName
     */
    public void setDepartmentName(java.lang.String departmentName) {
        this.departmentName = departmentName;
    }


    /**
     * Gets the departmentNo value for this DepartmentType.
     * 
     * @return departmentNo
     */
    public java.lang.String getDepartmentNo() {
        return departmentNo;
    }


    /**
     * Sets the departmentNo value for this DepartmentType.
     * 
     * @param departmentNo
     */
    public void setDepartmentNo(java.lang.String departmentNo) {
        this.departmentNo = departmentNo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepartmentType)) return false;
        DepartmentType other = (DepartmentType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.departmentAttribute==null && other.getDepartmentAttribute()==null) || 
             (this.departmentAttribute!=null &&
              this.departmentAttribute.equals(other.getDepartmentAttribute()))) &&
            ((this.departmentDescribe==null && other.getDepartmentDescribe()==null) || 
             (this.departmentDescribe!=null &&
              this.departmentDescribe.equals(other.getDepartmentDescribe()))) &&
            ((this.departmentManager==null && other.getDepartmentManager()==null) || 
             (this.departmentManager!=null &&
              this.departmentManager.equals(other.getDepartmentManager()))) &&
            ((this.departmentName==null && other.getDepartmentName()==null) || 
             (this.departmentName!=null &&
              this.departmentName.equals(other.getDepartmentName()))) &&
            ((this.departmentNo==null && other.getDepartmentNo()==null) || 
             (this.departmentNo!=null &&
              this.departmentNo.equals(other.getDepartmentNo())));
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
        if (getDepartmentAttribute() != null) {
            _hashCode += getDepartmentAttribute().hashCode();
        }
        if (getDepartmentDescribe() != null) {
            _hashCode += getDepartmentDescribe().hashCode();
        }
        if (getDepartmentManager() != null) {
            _hashCode += getDepartmentManager().hashCode();
        }
        if (getDepartmentName() != null) {
            _hashCode += getDepartmentName().hashCode();
        }
        if (getDepartmentNo() != null) {
            _hashCode += getDepartmentNo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepartmentType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://jw.nju.edu.cn/wsdl", "departmentType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentAttribute");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentAttribute"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentDescribe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentDescribe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentManager");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentManager"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departmentNo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departmentNo"));
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

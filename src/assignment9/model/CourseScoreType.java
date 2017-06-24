//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.31 at 09:22:55 PM CST 
//

package assignment9.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CourseScoreType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CourseScoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Score" type="{http://jw.nju.edu.cn/schema}ScoreType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ScoreType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CourseNo" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourseScoreType", propOrder = { "score" })
public class CourseScoreType implements Comparable<CourseScoreType> {

	@XmlElement(name = "Score", required = true)
	protected ScoreType score;
	@XmlAttribute(name = "ScoreType")
	protected String scoreType;
	@XmlAttribute(name = "CourseNo")
	protected String courseNo;

	/**
	 * Gets the value of the score property.
	 * 
	 * @return possible object is {@link ScoreType }
	 * 
	 */
	public ScoreType getScore() {
		return score;
	}

	/**
	 * Sets the value of the score property.
	 * 
	 * @param value
	 *            allowed object is {@link ScoreType }
	 * 
	 */
	public void setScore(ScoreType value) {
		this.score = value;
	}

	/**
	 * Gets the value of the scoreType property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getScoreType() {
		return scoreType;
	}

	/**
	 * Sets the value of the scoreType property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setScoreType(String value) {
		this.scoreType = value;
	}

	/**
	 * Gets the value of the courseNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCourseNo() {
		return courseNo;
	}

	/**
	 * Sets the value of the courseNo property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCourseNo(String value) {
		this.courseNo = value;
	}

	@Override
	public int compareTo(CourseScoreType o) {
		// TODO Auto-generated method stub
		if (this.getCourseNo().compareTo(o.getCourseNo()) != 0) {
			return this.getCourseNo().compareTo(o.getCourseNo());
		} else {
			if (this.getScoreType().compareTo(o.getScoreType()) != 0) {
				return this.getScoreType().compareTo(o.getScoreType());
			} else {
				return this.getScore().getRealScore().compareTo(o.getScore().getRealScore());
			}
		}
	}

}
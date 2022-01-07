package za.co.sfy.lucid.sams.domain;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for serviceStatus.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="serviceStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUCCESS"/>
 *     &lt;enumeration value="WARN"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "serviceStatus", namespace = "message")
@XmlEnum
public enum ServiceStatus {

    SUCCESS,
    WARN,
    ERROR;

    public String value() {
        return name();
    }

    public static ServiceStatus fromValue(String v) {
        return valueOf(v);
    }

}
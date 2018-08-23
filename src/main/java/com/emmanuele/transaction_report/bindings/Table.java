//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.08.23 alle 09:36:07 PM CEST 
//


package com.emmanuele.transaction_report.bindings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}tr" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="align" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="border" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="cellpadding" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="cellspacing" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tr"
})
@XmlRootElement(name = "table")
public class Table {

    @XmlElement(required = true)
    protected List<Tr> tr;
    @XmlAttribute(name = "align", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String align;
    @XmlAttribute(name = "border", required = true)
    protected BigInteger border;
    @XmlAttribute(name = "cellpadding", required = true)
    protected BigInteger cellpadding;
    @XmlAttribute(name = "cellspacing", required = true)
    protected BigInteger cellspacing;

    /**
     * Gets the value of the tr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tr }
     * 
     * 
     */
    public List<Tr> getTr() {
        if (tr == null) {
            tr = new ArrayList<Tr>();
        }
        return this.tr;
    }

    /**
     * Recupera il valore della proprietà align.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlign() {
        return align;
    }

    /**
     * Imposta il valore della proprietà align.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Recupera il valore della proprietà border.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBorder() {
        return border;
    }

    /**
     * Imposta il valore della proprietà border.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBorder(BigInteger value) {
        this.border = value;
    }

    /**
     * Recupera il valore della proprietà cellpadding.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCellpadding() {
        return cellpadding;
    }

    /**
     * Imposta il valore della proprietà cellpadding.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCellpadding(BigInteger value) {
        this.cellpadding = value;
    }

    /**
     * Recupera il valore della proprietà cellspacing.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCellspacing() {
        return cellspacing;
    }

    /**
     * Imposta il valore della proprietà cellspacing.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCellspacing(BigInteger value) {
        this.cellspacing = value;
    }

}

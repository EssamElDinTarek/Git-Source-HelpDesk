package com.sbm.helpdesk.persistence.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ahmed Magdy
 */
@Entity
@Table(name = "INFORMATIONAL_DETAILS")
@NamedQueries({
    @NamedQuery(name = "InformationalDetails.findAll", query = "SELECT i FROM InformationalDetails i"),
    @NamedQuery(name = "InformationalDetails.findByInfoId", query = "SELECT i FROM InformationalDetails i WHERE i.infoId = :infoId"),
    @NamedQuery(name = "InformationalDetails.findByColName", query = "SELECT i FROM InformationalDetails i WHERE i.colName = :colName"),
    @NamedQuery(name = "InformationalDetails.findByOldValue", query = "SELECT i FROM InformationalDetails i WHERE i.oldValue = :oldValue"),
    @NamedQuery(name = "InformationalDetails.findByNewValue", query = "SELECT i FROM InformationalDetails i WHERE i.newValue = :newValue"),
    @NamedQuery(name = "InformationalDetails.findByticketId", query = "SELECT i FROM InformationalDetails i WHERE i.ticketId.ticketId = :ticketId"),
    @NamedQuery(name = "InformationalDetails.findByUpdatedAt", query = "SELECT i FROM InformationalDetails i WHERE i.updatedAt = :updatedAt")})
public class InformationalDetails extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
	@Id
	@SequenceGenerator(name="INFORMATIONAL_DETAILS_INFOID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INFORMATIONAL_DETAILS_INFOID_GENERATOR")
	@Column(name="INFO_ID", unique=true, nullable=false, precision=22)
    private long infoId;
    @Column(name = "COL_NAME",length=255)
    private String colName;
    @Column(name = "OLD_VALUE",length=255)
    private String oldValue;
    @Column(name = "NEW_VALUE",length=255)
    private String newValue;
    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @JoinColumn(name = "UPDATED_BY", referencedColumnName = "USER_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Hduser updatedBy;
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Step stepId;
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "TICKET_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Ticket ticketId;

    public InformationalDetails() {
    }

    public long getInfoId() {
        return infoId;
    }

    public void setInfoId(long infoId) {
        this.infoId = infoId;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Hduser getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Hduser updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Step getStepId() {
        return stepId;
    }

    public void setStepId(Step stepId) {
        this.stepId = stepId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (infoId != null ? infoId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof InformationalDetails)) {
//            return false;
//        }
//        InformationalDetails other = (InformationalDetails) object;
//        if ((this.infoId == null && other.infoId != null) || (this.infoId != null && !this.infoId.equals(other.infoId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "entityClasses.InformationalDetails[ infoId=" + infoId + " ]";
//    }
    
}


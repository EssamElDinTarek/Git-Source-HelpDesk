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
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;


/**
 *
 * @author Ahmed Magdy
 */
@Entity
@Table(name = "BEHAVIORAL_DETAILS")
@NamedQueries({
    @NamedQuery(name = "BehavioralDetails.findAll", query = "SELECT b FROM BehavioralDetails b"),
    @NamedQuery(name = "BehavioralDetails.findByBehaviorId", query = "SELECT b FROM BehavioralDetails b WHERE b.behaviorId = :behaviorId"),
    @NamedQuery(name = "BehavioralDetails.findByBehaviorName", query = "SELECT b FROM BehavioralDetails b WHERE b.behaviorName = :behaviorName"),
    @NamedQuery(name = "BehavioralDetails.findByBehaviorValue", query = "SELECT b FROM BehavioralDetails b WHERE b.behaviorValue = :behaviorValue"),
    @NamedQuery(name = "BehavioralDetails.findByActionAt", query = "SELECT b FROM BehavioralDetails b WHERE b.actionAt = :actionAt")})
public class BehavioralDetails extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
	@Id
	@SequenceGenerator(name="BEHAVIORAL_DETAILS_BEHAVIORID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEHAVIORAL_DETAILS_BEHAVIORID_GENERATOR")
	@Column(name="BEHAVIOR_ID", unique=true, nullable=false, precision=22)
    private long behaviorId;
	
    @Column(name = "BEHAVIOR_NAME",length=255)
    private String behaviorName;
    
    @Column(name = "BEHAVIOR_VALUE",length=255)
    private String behaviorValue;
    
    @Column(name = "ACTION_AT")
    @Temporal(TemporalType.DATE)
    private Date actionAt;
    
    @JoinColumn(name = "ACTION_BY", referencedColumnName = "USER_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Hduser actionBy;
    
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Step stepId;
    
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "TICKET_ID")
    @ManyToOne(cascade = CascadeType.ALL)
    private Ticket ticketId;
    
    @Column(name = "ID")
    private long id;

    public BehavioralDetails() {
    }

    public long getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(long behaviorId) {
        this.behaviorId = behaviorId;
    }

    public String getBehaviorName() {
        return behaviorName;
    }

    public void setBehaviorName(String behaviorName) {
        this.behaviorName = behaviorName;
    }

    public String getBehaviorValue() {
        return behaviorValue;
    }

    public void setBehaviorValue(String behaviorValue) {
        this.behaviorValue = behaviorValue;
    }

    public Date getActionAt() {
        return actionAt;
    }

    public void setActionAt(Date actionAt) {
        this.actionAt = actionAt;
    }

    public Hduser getActionBy() {
        return actionBy;
    }

    public void setActionBy(Hduser actionBy) {
        this.actionBy = actionBy;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (behaviorId != null ? behaviorId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof BehavioralDetails)) {
//            return false;
//        }
//        BehavioralDetails other = (BehavioralDetails) object;
//        if ((this.behaviorId == null && other.behaviorId != null) || (this.behaviorId != null && !this.behaviorId.equals(other.behaviorId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "entityClasses.BehavioralDetails[ behaviorId=" + behaviorId + " ]";
//    }
    
}


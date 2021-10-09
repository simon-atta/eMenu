package com.emenu.model.section;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Restaurant table session model class.
 *
 * @author Simon Ghobreil.
 */
@Entity
@Table(name = "table_session")
public class RestaurantTableSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "session_id")
    private Long id;

    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "waiter_id")
    private Long waiterId;

    @Column(name = "status")
    private String status;

    @Column(name = "start_time")
    private Date startTimeStamp;

    @Column(name = "end_time")
    private Date endTimeStamp;

    public RestaurantTableSession() {
    }

    /**
     * @param id
     * @param tableId
     * @param waiterId
     * @param status
     * @param startTimeStamp
     * @param endTimeStamp
     */
    public RestaurantTableSession(Long id, Long tableId, Long waiterId, String status, Date startTimeStamp,
            Date endTimeStamp) {
        super();
        this.id = id;
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.status = status;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
    }

    /**
     * @param tableId
     * @param waiterId
     * @param status
     * @param startTimeStamp
     */
    public RestaurantTableSession(Long tableId, Long waiterId, String status, Date startTimeStamp) {
        super();
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.status = status;
        this.startTimeStamp = startTimeStamp;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the tableId
     */
    public Long getTableId() {
        return tableId;
    }

    /**
     * @param tableId
     *        the tableId to set
     */
    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    /**
     * @return the waiterId
     */
    public Long getWaiterId() {
        return waiterId;
    }

    /**
     * @param waiterId
     *        the waiterId to set
     */
    public void setWaiterId(Long waiterId) {
        this.waiterId = waiterId;
    }

    /**
     * @return the status
     */
    public String isStatus() {
        return status;
    }

    /**
     * @param status
     *        the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the startTimeStamp
     */
    public Date getStartTimeStamp() {
        return startTimeStamp;
    }

    /**
     * @param startTimeStamp
     *        the startTimeStamp to set
     */
    public void setStartTimeStamp(Date startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    /**
     * @return the endTimeStamp
     */
    public Date getEndTimeStamp() {
        return endTimeStamp;
    }

    /**
     * @param endTimeStamp
     *        the endTimeStamp to set
     */
    public void setEndTimeStamp(Date endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

}

package com.pareva.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name="mobileClubBillingPlans")
@NamedQueries(value= {
	      @NamedQuery(name="MobileClubBillingPlan.findByNetworkCode", query="SELECT m FROM MobileClubBillingPlan m WHERE m.networkCode = ?1"),
})
public class MobileClubBillingPlan implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "aUnique")
    private String unique;
    
    @Column(name="aSubUnique")
    private String subUnique;
    
    @Column(name="aExternalId")
    private String externalId = ""; //Keeping default values as blank if not set from Regions
    
    @Column(name="aClubUnique")
    private String clubUnique;
    
    @Column(name="aParsedMobile")
    private String parsedMobile;
    
    @Column(name="aActiveForBilling")
    private Integer activeForBilling;
    
    @Column(name="aActiveForAdvancement")
    private Integer activeForAdvancement;
    
    @Column(name="aSubscribed")
    private Date subscribed;
    
    @Column(name="aTariffClass")
    private Double tariffClass;
    
    @Column(name="aLastPaid")
    private Date lastPaid;
    
    @Column(name="aBillingEnd")
    private Date billingEnd;
    
    @Column(name="aPartialsRequired")
    private Double partialsRequired;
    
    @Column(name="aPartialsPaid")
    private Double partialsPaid;
    
    @Column(name="aAdhocsRemaining")
    private Double adhocsRemaining;
    
    @Column(name="aLastPush")
    private Date lastPush;
    
    @Column(name="aPushCount")
    private Double pushCount;
    
    @Column(name="aLastSuccess")
    private Date lastSuccess;
    
    @Column(name="aNextPush")
    private Date nextPush;
    
    @Column(name="aNetworkCode")
    private String networkCode;
    
    @Column(name="aContractType")
    private String contractType;
    
    @Column(name="aServiceDate")
    private Date serviceDate;
    
    @Column(name="aServiceDateBillsRemaining")
    private Double serviceDateBillsRemaining;
    
    @Column(name="aDynamicBillingEnds")
    private Date dynamicBillingEnds=new Date(0);
    
    @Column(name="aBillingState")
    private String billingState="";
    
    @Column(name="aPreviousSuccess")
    private Date previousSuccess=new Date(0);
    
    @Column(name="aPreviousPush")
    private Date previousPush=new Date(0);
    
    @Column(name="aParam1")
    private String param1="";
    
    @Column(name="aParam2")
    private String param2="";
    
    @Column(name="aPubId")
    private String publisherId="";
    
    @Column(name="aCampaign")
    private String aCampaign="";
    
    @Column(name="aRegionCode")
    private String aRegionCode;
    
    @Column(name="aRejectedCount")
    private int aRejectedCount;


    public MobileClubBillingPlan() {
    }

    public MobileClubBillingPlan(Object[] rawData) {
        //Integer.parseInt(String.valueOf(row[9])
        this.unique = ((String) rawData[0]);
        this.subUnique = ((String) rawData[1]);
        this.externalId = ((String) rawData[2]);
        this.parsedMobile = ((String) rawData[3]);
        this.clubUnique = ((String) rawData[4]);
        this.activeForBilling = Integer.parseInt(String.valueOf(rawData[5]));
        this.activeForAdvancement = Integer.parseInt(String.valueOf(rawData[6]));
        this.tariffClass = Double.parseDouble(String.valueOf(rawData[7]));
        this.subscribed = ((Date) rawData[8]);
        this.lastPaid = ((Date) rawData[9]);
        this.billingEnd = ((Date) rawData[10]);
        this.partialsRequired = (Double.parseDouble(String.valueOf(rawData[11])));
        this.partialsPaid = (Double.parseDouble(String.valueOf(rawData[12])));
        this.serviceDate = ((Date) rawData[13]);
        this.serviceDateBillsRemaining = (Double.parseDouble(String.valueOf(rawData[14])));
        this.adhocsRemaining = (Double.parseDouble(String.valueOf(rawData[15])));
        this.lastPush = ((Date) rawData[16]);
        this.pushCount = (Double.parseDouble(String.valueOf(rawData[17])));
        this.lastSuccess = ((Date) rawData[18]);
        this.nextPush = ((Date) rawData[19]);
        this.dynamicBillingEnds = ((Date) rawData[20]);
        this.networkCode = ((String) rawData[21]);
        this.contractType = ((String) rawData[22]);
        this.billingState = (String) rawData[23];
        this.previousSuccess = (Date) rawData[24];
        this.previousPush = (Date) rawData[25];
        this.aCampaign=(String) rawData[26];
        this.param1 = (String) rawData[27];
        this.param2 = (String) rawData[28];
        this.publisherId=(String) rawData[29];
        this.aRegionCode=(String) rawData[30];
        this.aRejectedCount=Integer.parseInt((String.valueOf(rawData[31])));

    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }

    public String getSubUnique() {
        return subUnique;
    }

    public void setSubUnique(String subUnique) {
        this.subUnique = subUnique;
    }

    public String getClubUnique() {
        return clubUnique;
    }

    public void setClubUnique(String clubUnique) {
        this.clubUnique = clubUnique;
    }

    public String getParsedMobile() {
        return parsedMobile;
    }

    public void setParsedMobile(String parsedMobile) {
        this.parsedMobile = parsedMobile;
    }

    public Integer getActiveForBilling() {
        return activeForBilling;
    }

    public void setActiveForBilling(Integer activeForBilling) {
        this.activeForBilling = activeForBilling;
    }

    public Integer getActiveForAdvancement() {
        return activeForAdvancement;
    }

    public void setActiveForAdvancement(Integer activeForAdvancement) {
        this.activeForAdvancement = activeForAdvancement;
    }

    public Date getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Date subscribed) {
        this.subscribed = subscribed;
    }

    public Double getTariffClass() {
        return tariffClass;
    }

    public void setTariffClass(Double tariffClass) {
        this.tariffClass = tariffClass;
    }

    public Date getLastPaid() {
        return lastPaid;
    }

    public void setLastPaid(Date lastPaid) {
        this.lastPaid = lastPaid;
    }

    public Date getBillingEnd() {
        return billingEnd;
    }

    public void setBillingEnd(Date billingEnd) {
        this.billingEnd = billingEnd;
    }

    public Double getPartialsRequired() {
        return partialsRequired;
    }

    public void setPartialsRequired(Double partialsRequired) {
        this.partialsRequired = partialsRequired;
    }

    public Double getPartialsPaid() {
        return partialsPaid;
    }

    public void setPartialsPaid(Double partialsPaid) {
        this.partialsPaid = partialsPaid;
    }

    public Double getAdhocsRemaining() {
        return adhocsRemaining;
    }

    public void setAdhocsRemaining(Double adhocsRemaining) {
        this.adhocsRemaining = adhocsRemaining;
    }

    public Date getLastPush() {
        return lastPush;
    }

    public void setLastPush(Date lastPush) {
        this.lastPush = lastPush;
    }

    public Double getPushCount() {
        return pushCount;
    }

    public void setPushCount(Double pushCount) {
        this.pushCount = pushCount;
    }

    public Date getLastSuccess() {
        return lastSuccess;
    }

    public void setLastSuccess(Date lastSuccess) {
        this.lastSuccess = lastSuccess;
    }

    public Date getNextPush() {
        return nextPush;
    }

    public void setNextPush(Date nextPush) {
        this.nextPush = nextPush;
    }

    public String getNetworkCode() {
        return networkCode;
    }

    public void setNetworkCode(String networkCode) {
        this.networkCode = networkCode;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Double getServiceDateBillsRemaining() {
        return serviceDateBillsRemaining;
    }

    public void setServiceDateBillsRemaining(Double serviceDateBillsRemaining) {
        this.serviceDateBillsRemaining = serviceDateBillsRemaining;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public Date getDynamicBillingEnds() {
        return dynamicBillingEnds;
    }

    public void setDynamicBillingEnds(Date dynamicBillingEnds) {
        this.dynamicBillingEnds = dynamicBillingEnds;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public Date getPreviousSuccess() {
        return previousSuccess;
    }

    public void setPreviousSuccess(Date previousSuccess) {
        this.previousSuccess = previousSuccess;
    }

    public Date getPreviousPush() {
        return previousPush;
    }

    public void setPreviousPush(Date previousPush) {
        this.previousPush = previousPush;
    }

      public String getParam1() {
        return param1;
    }

    public void setaParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getaCampaign() {
        return aCampaign;
    }

    public void setaCampaign(String aCampaign) {
        this.aCampaign = aCampaign;
    }

    public String getaRegionCode() {
        return aRegionCode;
    }

    public void setaRegionCode(String aRegionCode) {
        this.aRegionCode = aRegionCode;
    }

    public int getaRejectedCount() {
        return aRejectedCount;
    }

    public void setaRejectedCount(int aRejectedCount) {
        this.aRejectedCount = aRejectedCount;
    }
    
    
    
  @Override
    public String toString() {
        SimpleDateFormat shortDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat longDate = new SimpleDateFormat("yyyyMMdd-HHmmss");
        return "[unique=" + unique + ", " + parsedMobile + "," + clubUnique + "-SUBS " + longDate.format(subscribed) + ", tariffClass="
                + tariffClass + ", partialsPaid= " + partialsPaid + ", billingEnd=" + shortDate.format(billingEnd) + ", LastPaid="
                + shortDate.format(lastPaid) + ", LastSuccess=" + longDate.format(lastSuccess)
  + ", LastPush=" + longDate.format(lastPush)
                + ", ServiceDate=" + (serviceDate == null?"NULL":shortDate.format(serviceDate))
                + ", NextPush=" + longDate.format(nextPush) + ", externalId=" + externalId +", publisherid="+this.publisherId
  + ", Param1=["+param1+"], Param2=["+param2+"] ]";
    }
}
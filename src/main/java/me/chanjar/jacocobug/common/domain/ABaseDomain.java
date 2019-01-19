package me.chanjar.jacocobug.common.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class ABaseDomain implements Serializable {

  private static final long serialVersionUID = 8023881887762314483L;

  @Id
  @Column(name = "ID", columnDefinition = "varchar(64) ")

  private String id;

  public ABaseDomain() {
    super();
  }

  public ABaseDomain(String id) {
    super();
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Column(name = "COMPANY_ID", columnDefinition = "varchar(200) ")
  private String companyId = null;

  @Column(name = "DELETED", columnDefinition = "int(1) default 0 ")
  private Boolean deleted = false;

  @Column(name = "ADD_ACCOUNT", columnDefinition = "varchar(100) ")
  private String addAccount = null;

  @Column(name = "ADD_TIME", columnDefinition = "timestamp ")
  @CreatedDate
  private Date addTime = null;

  @Column(name = "EDIT_ACCOUNT", columnDefinition = "varchar(100) ")
  private String editAccount = null;

  @Column(name = "EDIT_TIME", columnDefinition = "timestamp ")
  @LastModifiedDate
  private Date editTime = null;

  @Column(name = "DELETE_ACCOUNT", columnDefinition = "varchar(100) ")
  private String deleteAccount = null;

  @Column(name = "DELETE_TIME", columnDefinition = "timestamp ")
  private Date deleteTime = null;

  public String getCompanyId() {
    return companyId;
  }

  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  public Boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public String getAddAccount() {
    return addAccount;
  }

  public void setAddAccount(String addAccount) {
    this.addAccount = addAccount;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public String getEditAccount() {
    return editAccount;
  }

  public void setEditAccount(String editAccount) {
    this.editAccount = editAccount;
  }

  public Date getEditTime() {
    return editTime;
  }

  public void setEditTime(Date editTime) {
    this.editTime = editTime;
  }

  public String getDeleteAccount() {
    return deleteAccount;
  }

  public void setDeleteAccount(String deleteAccount) {
    this.deleteAccount = deleteAccount;
  }

  public Date getDeleteTime() {
    return deleteTime;
  }

  public void setDeleteTime(Date deleteTime) {
    this.deleteTime = deleteTime;
  }

}

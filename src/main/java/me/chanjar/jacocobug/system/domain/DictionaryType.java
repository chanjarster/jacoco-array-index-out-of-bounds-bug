package me.chanjar.jacocobug.system.domain;

import me.chanjar.jacocobug.common.domain.ABaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_B_DICTIONARY_TYPE", uniqueConstraints = { @UniqueConstraint(columnNames = { "CODE" }) })
@org.hibernate.annotations.Table(appliesTo = "TB_B_DICTIONARY_TYPE", comment = "字典类型表")
public class DictionaryType extends ABaseDomain {

  /**
   *
   */
  private static final long serialVersionUID = -7355785282419690119L;

  @Column(name = "CODE", columnDefinition = "varchar(120) not null ")
  private String code;

  @Column(name = "NAME", columnDefinition = "varchar(200) not null ")
  private String name;

  @Column(name = "ENABLE", columnDefinition = "int(1) default 1 ")
  private Boolean enable = true;

  @Column(name = "MULTI_LEVEL", columnDefinition = "int(1) default 1 ")
  private Boolean multiLevel = true;

  @Column(name = "SORT", columnDefinition = "bigint(20) ")
  private Long sort;

  @Column(name = "IS_DATA_CENTER", columnDefinition = "int(1) default 1 ")
  private Boolean isDataCenter = false;

  public DictionaryType() {
    super();
  }

  public DictionaryType(String id) {
    super(id);
  }

  public DictionaryType(String code, String name, Boolean enable, Boolean multiLevel) {
    super();
    this.code = code;
    this.name = name;
    this.enable = enable;
    this.multiLevel = multiLevel;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public Boolean getMultiLevel() {
    return multiLevel;
  }

  public void setMultiLevel(Boolean multiLevel) {
    this.multiLevel = multiLevel;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  public Boolean getIsDataCenter() {
    return isDataCenter;
  }

  public void setIsDataCenter(Boolean isDataCenter) {
    this.isDataCenter = isDataCenter;
  }

}

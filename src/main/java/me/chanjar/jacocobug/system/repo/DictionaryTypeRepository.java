package me.chanjar.jacocobug.system.repo;

import me.chanjar.jacocobug.common.domain.ABaseDomain;
import me.chanjar.jacocobug.common.utils.UUIDUtils;
import me.chanjar.jacocobug.system.domain.DictionaryType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

@Repository
public class DictionaryTypeRepository {

  @Autowired
  private EntityManager entityManager;

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public String generateId() {
    return UUIDUtils.create();
  }

  @Transactional
  public <T extends ABaseDomain> void save(T... entitys) {
    for (T entity : entitys) {
      entity.setAddTime(new Date());
      entity.setDeleted(false);
      if (StringUtils.isBlank(entity.getId())) {
        entity.setId(generateId());
      }
      entityManager.persist(entity);
    }
  }

  @Transactional
  public void createDictionaryType(DictionaryType dictionaryType) {
    dictionaryType.setIsDataCenter(false);
    dictionaryType.setSort(new Date().getTime());//默认设置排序为日期long
    this.save(dictionaryType);
  }

}

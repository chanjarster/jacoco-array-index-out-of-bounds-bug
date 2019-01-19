package me.chanjar.jacocobug.system.repo;

import me.chanjar.jacocobug.IntegrationTestBase;
import me.chanjar.jacocobug.IntegrationTestConfiguration;
import me.chanjar.jacocobug.common.utils.DataDomainUtil;
import me.chanjar.jacocobug.system.domain.DictionaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@SpringBootTest(classes = IntegrationTestConfiguration.class)
@Test(groups = "DictionaryTypeGroup")
public class DictionaryTypeRepositoryIT extends IntegrationTestBase {

  @Autowired
  private DictionaryTypeRepository dictionaryTypeRepository;
  @Autowired
  DictionaryTypeTestFactory dictionaryTypeTestFactory;

  @DataProvider
  public Object[][] testDictionaryTypeData() {
    return new Object[][] {
        new Object[] { dictionaryTypeTestFactory.newRandom() },
        new Object[] { dictionaryTypeTestFactory.newRandom() } };
  }

  @Test(dataProvider = "testDictionaryTypeData")
  public void testDictionaryTypeSort(DictionaryType dictionaryType) {

    dictionaryTypeRepository.createDictionaryType(dictionaryType);
    DictionaryType entity2 = dictionaryTypeTestFactory.newRandom();
    DataDomainUtil.copy(entity2, dictionaryType);

  }

}

package me.chanjar.jacocobug.system.repo;

import me.chanjar.jacocobug.system.domain.DictionaryType;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class DictionaryTypeTestFactory {

  public DictionaryType newRandom() {
    return new DictionaryType(RandomStringUtils.randomAlphanumeric(6), RandomStringUtils.randomAlphanumeric(7), true,
        true);
  }

}

package me.chanjar.jacocobug.common.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DataDomainUtil {

  public static void setCompareValue(Object entity, String fieldName, Object fieldVlue) {
    try {
      Field field = null;
      for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
        try {
          field = clazz.getDeclaredField(fieldName);
          break;
        } catch (Exception e) {
        }
      }
      if (field != null) {
        field.setAccessible(true);
        // 设置该T的属性
        field.set(entity, fieldVlue);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static void setValue(Object entity, String fieldName, Object fieldVlue) {
    try {
      Field field = null;
      for (Class<?> clazz = entity.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
        try {
          field = clazz.getDeclaredField(fieldName);
          break;
        } catch (NoSuchFieldException e) {
          e.printStackTrace();
        }
      }
      if (fieldVlue != null) {
        Class class1 = field.getType();
        Class class2 = fieldVlue.getClass();
        // 判断两个类型是否相等
        if (class1.isAssignableFrom(class2)) {
          // setAccessible这行代码把对象上的id字段设置为public访问属性.
          field.setAccessible(true);
          // 设置该T的属性
          field.set(entity, fieldVlue);
        }
      } else {
        field.setAccessible(true);
        field.set(entity, fieldVlue);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static <T> T copy(T dataDomain, T modelDomain) {
    return copy(dataDomain, modelDomain, null);
  }

  public static <T> T copy(T dataDomain, T modelDomain, String... ignoreToNullProperty) {
    try {
      List<String> ignoreNullList = null;
      if (ignoreToNullProperty != null && ignoreToNullProperty.length > 0) {
        ignoreNullList = Arrays.asList(ignoreToNullProperty);
      }
      for (Class<?> clazz = modelDomain.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
        for (Field field : clazz.getDeclaredFields()) {
          String name = field.getName();
          field.setAccessible(true);
          Object value = field.get(modelDomain);
          if (value != null || (ignoreNullList != null && ignoreNullList.contains(name))) {
            setValue(dataDomain, name, value);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dataDomain;

  }

  public static <T> Object returnValue(String filedName, T domain) {
    try {
      Field field = null;
      for (Class<?> clazz = domain.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
        try {
          field = clazz.getDeclaredField(filedName);
          break;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (field != null) {
        field.setAccessible(true);
        return field.get(domain);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

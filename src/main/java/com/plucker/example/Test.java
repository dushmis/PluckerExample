package com.plucker.example;

import com.plucker.annotation.Cached;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {
  @Cached(duration = 1, durationUnit = TimeUnit.HOURS, maximumSize = 10000L)
  public Map<String, Object> methodThatTakesTooMuchTime(String objId) throws InterruptedException {
    final Map<String, Object> stringObjectMap = Collections.synchronizedMap(new HashMap<String, Object>());
    stringObjectMap.put("name", "steve");
    stringObjectMap.put("data", new HashSet<String>() {{
      add("one");
      add("two");
    }});
    TimeUnit.SECONDS.sleep(3);
    return stringObjectMap;
  }
//
//  @Cached(duration = 2, durationUnit = TimeUnit.HOURS, maximumSize = 100L)
//  public Void aVoid(String item) {
//    //noinspection MismatchedQueryAndUpdateOfCollection
//    List<String> strings = new ArrayList<>();
//    strings.add(item);
//    return null;
//  }

  @Cached(maximumSize = 2000L, duration = 5, expireAfterWrite = true, recordStats = true)
  public List<?> getListOfStuff(String name) {
    try {
      System.out.println("working = " + new Date());
      TimeUnit.SECONDS.sleep(10);
      System.out.println("working-ed = " + new Date());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }
}

package com.example.caricature;


import com.example.caricature.utils.RestTemplateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CaricatureApplicationTests {

    @Test
    public void rtPostObject(){
        String url = "https://m.titi001.com/query/books";
        Map t = RestTemplateUtil
            .create()
            .addBody("type","cartoon")
            .addBody("paged","false")
            .postForObj(url, Map.class);
      System.out.println(t);

    }

}

package com.example.springwork;

import com.example.springwork.utils.MahjongCalUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class SpringworkApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        MahjongCalUtils.CalShanten("11133456678999p");
    }

}

package com.HIBIKI_6.MahjongHelper;

import com.HIBIKI_6.MahjongHelper.utils.MahjongCalUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringworkApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        MahjongCalUtils.CalShanten("11133456678999p");
    }

}

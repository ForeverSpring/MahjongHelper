package com.HIBIKI_6.MahjongHelper.controller;

import com.HIBIKI_6.MahjongHelper.service.MahjongCalService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class MahjongHelperController {
    @Autowired
    MahjongCalService mahjongCalService;

    @GetMapping("Test")
    public @ResponseBody String Test() {
        return "服务器时间：" + LocalDateTime.now();
    }

    @ApiOperation("计算手牌")
    @GetMapping("/Help/{tehai}")
    public String CalTehai(@PathVariable String tehai) throws Exception {
        return mahjongCalService.CalTeHai(tehai);
    }

}

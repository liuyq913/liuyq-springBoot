package com.liuyq.reactor.controller;

import com.liuyq.reactor.domain.Account;
import com.liuyq.reactor.server.AccountServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author liuyuqing
 * @className MonoController
 * @description
 * @date 2021/7/9 3:20 下午
 */
@RestController
public class MonoController {

    @Resource
    private AccountServer accountServer;

    @GetMapping
    public Mono<Account> getAccount() {

        return accountServer.getAccountById(0L);
    }
}

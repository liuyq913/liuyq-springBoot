package com.liuyq.reactor.controller;

import com.liuyq.reactor.domain.Account;
import com.liuyq.reactor.server.AccountServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

/**
 * @author liuyuqing
 * @className TestController
 * @description
 * @date 2021/7/9 3:05 下午
 */
@RestController
public class FluxController {
    @Resource
    private AccountServer accountServer;

    /**
     * Flux 是包含0-n 个元素的异步队列
     *
     * @return
     */
    @GetMapping("/flux/accounts")
    public Flux<Account> getAccountList() {
        Flux<Account> accounts = accountServer.getAccounts();

        return accounts;
    }
}

package com.liuyq.reactor.server;

import com.liuyq.reactor.domain.Account;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyuqing
 * @className AccountServer
 * @description
 * @date 2021/7/9 3:19 下午
 */
@Service
public class AccountServer {

    public Flux<Account> getAccounts() {
        List<Account> accountList = new ArrayList<>();

        Account account = new Account();
        accountList.add(account);

        return Flux.fromIterable(accountList);
    }

    public Mono<Account> getAccountById(Long id) {
        Account account = new Account();

        return Mono.just(account);
    }
}

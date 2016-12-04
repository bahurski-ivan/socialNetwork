package ru.sbrf.socialnetwork.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.commons.responses.Response;
import ru.sbrf.socialnetwork.loginservice.domain.AccessTokenGenerator;
import ru.sbrf.socialnetwork.loginservice.domain.DateTimeToStringConverter;
import ru.sbrf.socialnetwork.loginservice.domain.Md5Generator;
import ru.sbrf.socialnetwork.loginservice.domain.objects.CheckToken;
import ru.sbrf.socialnetwork.loginservice.domain.objects.LoginDetails;
import ru.sbrf.socialnetwork.loginservice.domain.objects.LoginResponse;
import ru.sbrf.socialnetwork.loginservice.repository.AccessTokenRepository;
import ru.sbrf.socialnetwork.loginservice.repository.AccountRepository;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccessTokenCriteriaFactory;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccountCriteriaFactory;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by Ivan on 01/12/2016.
 */

@RestController
@Component
public class MainController {
    private final Md5Generator md5Generator;
    private final AccountRepository accountRepository;
    private final AccessTokenRepository tokenRepository;
    private final AccessTokenGenerator accessTokenGenerator;
    private final DateTimeToStringConverter dtStringConverter;
    private final AccountCriteriaFactory accountCriteriaFactory;
    private final AccessTokenCriteriaFactory accessTokenCriteriaFactory;


    @Autowired
    public MainController(Md5Generator md5Generator,
                          AccountRepository accountRepository,
                          AccessTokenRepository tokenRepository,
                          AccessTokenGenerator accessTokenGenerator,
                          DateTimeToStringConverter dtStringConverter,
                          AccountCriteriaFactory accountCriteriaFactory,
                          AccessTokenCriteriaFactory accessTokenCriteriaFactory) {
        this.md5Generator = md5Generator;
        this.accountRepository = accountRepository;
        this.tokenRepository = tokenRepository;
        this.dtStringConverter = dtStringConverter;
        this.accessTokenGenerator = accessTokenGenerator;
        this.accountCriteriaFactory = accountCriteriaFactory;
        this.accessTokenCriteriaFactory = accessTokenCriteriaFactory;
    }

    @ResponseBody
    @RequestMapping(value = "/check_token", method = RequestMethod.GET)
    public Response<?> checkToken(@ModelAttribute @Valid CheckToken accessToken) {
        Optional<AccessToken> token = tokenRepository.selectFirstRemoveIfInvalid(
                accessTokenCriteriaFactory.accessTokenByItsValue(accessToken.getAccessToken()),
                t -> t.getExpirationDate().isAfter(LocalDateTime.now())
        );

        return token.isPresent() ?
                Response.ofOk(true) :
                Response.ofOk(false);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Response<?> login(@ModelAttribute @Valid LoginDetails details) {
        AccessToken result = null;
        Optional<Account> account = accountRepository
                .selectFirst(accountCriteriaFactory.accountByUserName(details.getUserName()));

        if (account.isPresent()) {
            String passwordMd5 = md5Generator.generate(details.getPassword());
            if (passwordMd5.equals(account.get().getPasswordMd5()))
                result = getOrCreateTokenForAccount(account.get());
        }

        return result != null ?
                Response.ofOk(LoginResponse.ofToken(result, dtStringConverter)) :
                Response.ofError("invalid user name or password");
    }

    @ResponseBody
    @RequestMapping(value = "/create_new_account", method = RequestMethod.GET)
    public Response<?> createNewAccount(@ModelAttribute @Valid LoginDetails details) {
        Account result = null;
        Optional<Account> account = accountRepository
                .selectFirst(accountCriteriaFactory.accountByUserName(details.getUserName()));

        if (!account.isPresent()) {
            String passwordMd5 = md5Generator.generate(details.getPassword());
            Account newAccount = new Account(details.getUserName(), passwordMd5);
            result = accountRepository.add(newAccount);
        }

        return result != null ?
                Response.ofOk(result.getId()) :
                Response.ofError("account with given name already exist");
    }


    private AccessToken getOrCreateTokenForAccount(Account account) {
        Optional<AccessToken> token = tokenRepository.selectFirstRemoveIfInvalid(
                accessTokenCriteriaFactory.accessTokenByAccountId(account.getId()),
                t -> t.getExpirationDate().isAfter(LocalDateTime.now())
        );

        return token.isPresent() ? token.get() : createTokenForAccount(account);
    }

    private AccessToken createTokenForAccount(Account account) {
        AccessToken token = accessTokenGenerator.generate(account);
        tokenRepository.add(token);
        return token;
    }
}
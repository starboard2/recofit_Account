package recofit.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recofit.account.domain.VO.Address;
import recofit.account.domain.requestDto.SignInRequestDto;
import recofit.account.domain.requestDto.SignUpRequestDto;
import recofit.account.domain.requestDto.UpdateRequestDto;
import recofit.account.domain.responseDto.AccountInfoDto;
import recofit.account.domain.responseDto.SignInResponseDto;
import recofit.account.kafka.AccountProducer;
import recofit.account.service.AccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

    private final AccountService accountService;
    private final AccountProducer accountProducer;


    @PostMapping("/accounts/sign/up")
    public ResponseEntity<String> SignUp(@RequestBody @Valid SignUpRequestDto request) {

        accountService.signUp(request);

        return ResponseEntity.ok("OK");
    }

    @PostMapping("/accounts/sign/in")
    public ResponseEntity<SignInResponseDto> SignIn(@RequestBody @Valid SignInRequestDto request) {

        SignInResponseDto result = accountService.signIn(request);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/accounts/types/{userType}")
    public ResponseEntity<List<AccountInfoDto>> getAccountInfoByUserType(@PathVariable String userType) {
        List<AccountInfoDto> result = accountService.getAccountInfoByUserType(userType);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<AccountInfoDto> getAccountInfo(@PathVariable String accountId) {
        AccountInfoDto result = accountService.getAccountInfo(accountId);

        return ResponseEntity.ok(result);
    }

    @PutMapping("/accounts/{accountId}")
    public ResponseEntity<String> updateAccountInfo(@PathVariable String accountId,
                                                    @RequestBody @Valid UpdateRequestDto request) {
        accountService.updateAccountInfo(request);

        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/accounts/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/accounts/kafka")
    public String kafkaTest(@RequestBody Address address) {
        log.info("Address.getZipCode : " + address.getZipCode());
        log.info("Address.getDetail : " + address.getDetail());
        log.info("Address.getLatitude : " + address.getLatitude());
        log.info("Address.getLongitude : " + address.getLongitude());
        accountProducer.sendMessage("recofit-test", address);

        return "success";
    }

    @GetMapping("/accounts/test")
    public String accountTest() {
        return "account Test Success";
    }

    @PostMapping("/accounts/test2")
    public String accountTest2() {
        return "account Test2 Success";
    }

}

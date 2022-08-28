package recofit.account.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import recofit.account.domain.VO.Address;
import recofit.account.domain.entity.Account;
import recofit.account.domain.requestDto.SignInRequestDto;
import recofit.account.domain.requestDto.SignUpRequestDto;
import recofit.account.domain.requestDto.UpdateRequestDto;
import recofit.account.domain.responseDto.AccountInfoDto;
import recofit.account.domain.responseDto.SignInResponseDto;
import recofit.account.repository.AccountRepository;
import recofit.account.util.JwtUtil;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(@RequestBody @Valid SignUpRequestDto request) {
        Account account = makeAccount(request);

        validateDuplicateAccount(account);

        accountRepository.save(account);
    }

    public Account makeAccount(SignUpRequestDto request) {
        StringBuilder stringBuilder = new StringBuilder();
        return Account.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .userName(request.getUserName())
                .email(request.getEmail())
                .address(new Address(request.getZipCode(),
                        stringBuilder.append(request.getRoadAddress()).append(" ").append(request.getDetailAddress()).toString(),
                        null,
                        null))
                .userType(request.getUserType())
                .weight(Double.parseDouble(request.getWeight()))
                .build();
    }

    private void validateDuplicateAccount(Account account) {
        Optional<Account> findAccount = accountRepository.findById(account.getUserId());

        if (findAccount.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional
    public SignInResponseDto signIn(@RequestBody @Valid SignInRequestDto request) {
        Account account = accountRepository.findById(request.getUserId())
                .filter(a -> passwordEncoder.matches(request.getPassword(), a.getPassword()))
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));


        return SignInResponseDto.builder()
                .userId(account.getUserId())
                .userName(account.getUserName())
                .userType(account.getUserType())
                .accessToken(new JwtUtil().createAccessToken(account))
                .build();
    }

    @Transactional
    public List<AccountInfoDto> getAccountInfoByUserType(String userType) {
        List<Account> accountList = accountRepository.findByUserType(userType);

        return accountList.stream()
                .map(account -> AccountInfoDto.builder()
                        .userId(account.getUserId())
                        .userName(account.getUserName())
                        .userType(account.getUserType())
                        .address(account.getAddress())
                        .userEmail(account.getEmail())
                        .userRating(account.getRatings())
                        .userWeight(account.getWeight())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Transactional
    public AccountInfoDto getAccountInfo(String accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        return AccountInfoDto.builder()
                .userId(account.getUserId())
                .userName(account.getUserName())
                .userType(account.getUserType())
                .address(account.getAddress())
                .userEmail(account.getEmail())
                .userRating(account.getRatings())
                .userWeight(account.getWeight())
                .build();
    }

    @Transactional
    public void updateAccountInfo(UpdateRequestDto request) {
        Account account = accountRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        StringBuilder stringBuilder = new StringBuilder();
        Address address = new Address(request.getZipCode(),
                stringBuilder.append(request.getRoadAddress()).append(" ").append(request.getDetailAddress()).toString(),
                null,
                null);

        account.updateAccountInfo(request.getPassword(), request.getEmail(), address, request.getWeight());
    }

    @Transactional
    public void deleteAccount(String accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        accountRepository.deleteById(accountId);
    }

}

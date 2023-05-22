package com.sodamdadam.server.domain.user.service;

import com.sodamdadam.server.domain.user.dto.request.UserJoinRequest;
import com.sodamdadam.server.domain.user.entity.User;
import com.sodamdadam.server.domain.user.repository.UserRepository;
import com.sodamdadam.server.global.dto.response.SuccessResponse;
import com.sodamdadam.server.global.error.ErrorCode;
import com.sodamdadam.server.global.exception.SodamDadamException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserJoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public ResponseEntity<SuccessResponse> setUser(UserJoinRequest request) {
        validateUserIdNotExist(request.getId());
        User user = createUserFromRequest(request);
        userRepository.save(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(SuccessResponse.builder()
                .status(HttpStatus.CREATED.value())
                .message("UserJoin Success")
                .build());
    }

    private void validateUserIdNotExist(String id) {
        if (userRepository.findById(id).isPresent()) {
            throw new SodamDadamException(ErrorCode.ALREADY_ID_EXIST);
        }
    }

    private User createUserFromRequest(UserJoinRequest request) {
        return User.builder()
                .id(request.getId())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();
    }
}

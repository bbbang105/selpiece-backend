package kusitms.jangkku.domain.user.api;

import jakarta.servlet.http.HttpServletResponse;
import kusitms.jangkku.domain.user.application.UserService;
import kusitms.jangkku.domain.user.constant.UserSuccessStatus;
import kusitms.jangkku.domain.user.dto.UserDto;
import kusitms.jangkku.domain.user.exception.UserErrorResult;
import kusitms.jangkku.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 기본 정보를 입력 받아 저장하는 API
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDto.UserRegisterResponse>> registerUser(
            HttpServletResponse response,
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody UserDto.UserRegisterRequest userRegisterRequest) {

        UserDto.UserRegisterResponse userRegisterResponse = userService.registerUser(response, authorizationHeader, userRegisterRequest);
        return ApiResponse.onSuccess(UserSuccessStatus.SUCCESS_REGISTER_USER, userRegisterResponse);
    }

    // 닉네임 중복 여부를 반환하는 API
    @GetMapping("/check-nickname/{nickname}")
    public ResponseEntity<ApiResponse<Object>> checkNickname(
            @PathVariable("nickname") String nickname) {

        if (!userService.isDuplicate(nickname)) {
            return ApiResponse.onSuccess(UserSuccessStatus.IS_NICKNAME_POSSIBLE);
        } else {
            return ApiResponse.onFailure(UserErrorResult.IS_DUPLICATE_NICKNAME);
        }
    }

    // 프로필 사진을 업로드 API
    @PostMapping("/profile-img")
    public ResponseEntity<ApiResponse<Object>> uploadProfileImg(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam("file") MultipartFile file) {

        userService.uploadProfileImg(authorizationHeader, file);

        return ApiResponse.onSuccess(UserSuccessStatus.SUCCESS_UPLOAD_PROFILE_IMG);
    }
}
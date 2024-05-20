package kusitms.jangkku.domain.persona.api;

import kusitms.jangkku.domain.persona.application.DiscoverPersonaService;
import kusitms.jangkku.domain.persona.constant.PersonaSuccessStatus;
import kusitms.jangkku.domain.persona.dto.DiscoverPersonaDto;
import kusitms.jangkku.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class DiscoverPersonaController {
    private final DiscoverPersonaService discoverPersonaService;

    // 돌아보기 페르소나 질문을 응답 받는 API
    @GetMapping("/discover/question")
    public ResponseEntity<ApiResponse<DiscoverPersonaDto.QuestionResponse>> getNewQuestion(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam("category") String category) {

        DiscoverPersonaDto.QuestionResponse questionResponse = discoverPersonaService.getNewQuestion(authorizationHeader, category);

        return ApiResponse.onSuccess(PersonaSuccessStatus.CREATED_NEW_QUESTION, questionResponse);
    }

    // 돌아보기 페르소나 공감 & 요약을 응답 받는 API
    @PostMapping("/discover/answer")
    public ResponseEntity<ApiResponse<DiscoverPersonaDto.AnswerResponse>> getReactionAndSummary(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody DiscoverPersonaDto.AnswerRequest answerRequest) {

        DiscoverPersonaDto.AnswerResponse answerResponse = discoverPersonaService.getReactionAndSummary(authorizationHeader, answerRequest);

        return ApiResponse.onSuccess(PersonaSuccessStatus.CREATED_REACTION_AND_SUMMARY, answerResponse);
    }

    // 돌아보기 페르소나 카테고리별 채팅 내역을 조회하는 API
    @GetMapping("/discover/chattings")
    public ResponseEntity<ApiResponse<DiscoverPersonaDto.ChattingResponse>> getChattings(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam("category") String category) {

        DiscoverPersonaDto.ChattingResponse chattingResponse = discoverPersonaService.getChattings(authorizationHeader, category);

        return ApiResponse.onSuccess(PersonaSuccessStatus.GET_CHATTINGS, chattingResponse);
    }

    // 돌아보기 페르소나 답변 요약 내역을 조회하는 API
    @GetMapping("/discover/summaries")
    public ResponseEntity<ApiResponse<DiscoverPersonaDto.SummaryResponse>> getSummaries(
            @RequestHeader("Authorization") String authorizationHeader) {

        DiscoverPersonaDto.SummaryResponse summaryResponse = discoverPersonaService.getSummaries(authorizationHeader);

        return ApiResponse.onSuccess(PersonaSuccessStatus.GET_SUMMARIES, summaryResponse);
    }
}
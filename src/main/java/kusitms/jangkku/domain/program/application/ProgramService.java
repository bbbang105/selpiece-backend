package kusitms.jangkku.domain.program.application;

import kusitms.jangkku.domain.program.dto.ProgramDetailDto;
import kusitms.jangkku.domain.program.dto.ProgramDto;
import kusitms.jangkku.domain.program.dto.ProgramsHomeDto;

import java.util.List;

public interface ProgramService {
    List<ProgramDto.ProgrmsMainResponsetDto> getMainSelfUnderstanding();

    List<ProgramDto.ProgrmsMainResponsetDto> getMainBranding(String authorizationHeader);

    List<ProgramDto.ProgrmsMainResponsetDto> getMoreSelfUnderstanding(ProgramDto.ProgramSelfUnderstandingRequestDto requestDto);

    List<ProgramDto.ProgrmsMainResponsetDto> getMoreBranding(String authorizationHeader,ProgramDto.ProgramBrandingRequestDto requestDto);

    ProgramDetailDto.ProgramDetailResponseDto getDetailProgram(String authorizationHeader, Long programId, String type);

    List<ProgramsHomeDto.ProgramsHomeResponseDto> getHomeSelfUnderstanding(String authorizationHeader,ProgramDto.ProgramSelfUnderstandingRequestDto requestDto);

    List<ProgramsHomeDto.ProgramsHomeResponseDto> getHomeBranding(String authorizationHeader, ProgramDto.ProgramBrandingRequestDto requestDto);

    List<ProgramsHomeDto.ProgramsHomeResponseDto> getHomeBrandingNonLogin(ProgramDto.ProgramBrandingRequestDto requestDto);

    void applyPrograms(String authorizationHeader, ProgramDto.ProgramJoinRequestDto requestDto);
}

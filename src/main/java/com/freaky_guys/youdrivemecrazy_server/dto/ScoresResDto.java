package com.freaky_guys.youdrivemecrazy_server.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ScoresResDto {
    private List<ScoresDto> data;
}

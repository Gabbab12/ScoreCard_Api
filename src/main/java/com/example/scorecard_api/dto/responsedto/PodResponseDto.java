package com.example.scorecard_api.dto.responsedto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PodResponseDto {
   private String podName;
   private String podHealth;
   private int totalDecadevs;
   private String SA;
   private String Pa;
}

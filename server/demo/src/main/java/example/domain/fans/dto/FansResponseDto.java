package example.domain.fans.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FansResponseDto {
    private int fanId;
    private String nickname;
    private String profile;

}

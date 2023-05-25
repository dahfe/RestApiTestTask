package test.restapi.cities.dto.entityDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditCityDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private List<ImageDto> images;
}

package br.com.fase5.hackaton.mstelecall.mapper;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;
import br.com.fase5.hackaton.mstelecall.model.TeleCallModel;

public class TeleCallMapper {

    private TeleCallMapper(){}

    public static TeleCallDTO toDTO(TeleCallModel telecallModel) {
        return TeleCallDTO.builder()
                .uuid(telecallModel.getId())
                .initialDateTime(telecallModel.getInitialDateTime())
                .finalDateTime(telecallModel.getFinalDateTime())
                .build();
    }

    public static TeleCallModel toEntity(TeleCallDTO telecallDTO) {
        return TeleCallModel.builder()
                .id(telecallDTO.uuid())
                .initialDateTime(telecallDTO.initialDateTime())
                .finalDateTime(telecallDTO.finalDateTime())
                .build();
    }

}

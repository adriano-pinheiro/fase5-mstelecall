package br.com.fase5.hackaton.mstelecall.mapper;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;
import br.com.fase5.hackaton.mstelecall.model.TeleCallModel;

public class TeleCallMapper {

    private TeleCallMapper(){}

    public static TeleCallDTO toDto(TeleCallModel telecallModel) {
        return TeleCallDTO.builder()
                .uuid(telecallModel.getUuid())
                .initialDateTime(telecallModel.getInitialDateTime())
                .finalDateTime(telecallModel.getFinalDateTime())
                .build();
    }

    public static TeleCallModel toEntity(TeleCallDTO telecallDTO) {
        return TeleCallModel.builder()
                .uuid(telecallDTO.uuid())
                .initialDateTime(telecallDTO.initialDateTime())
                .finalDateTime(telecallDTO.finalDateTime())
                .build();
    }

}

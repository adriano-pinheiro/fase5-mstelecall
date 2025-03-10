package br.com.fase5.hackaton.mstelecall.service.impl;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;
import br.com.fase5.hackaton.mstelecall.exception.NotFoundException;
import br.com.fase5.hackaton.mstelecall.mapper.TeleCallMapper;
import br.com.fase5.hackaton.mstelecall.model.TeleCallModel;
import br.com.fase5.hackaton.mstelecall.repository.TeleCallRepository;
import br.com.fase5.hackaton.mstelecall.service.TeleCallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TeleCallServiceImpl implements TeleCallService {

    private final TeleCallRepository teleCallRepository;

    public TeleCallServiceImpl(TeleCallRepository teleCallRepository) {
        this.teleCallRepository = teleCallRepository;
    }

    @Override
    @Transactional
    public TeleCallDTO save() {
        TeleCallModel teleCallModel = new TeleCallModel();
        teleCallModel.setId(UUID.randomUUID());
        return TeleCallMapper.toDTO(teleCallRepository.save(teleCallModel));
    }

    @Override
    public TeleCallDTO update(UUID id) {
        TeleCallModel teleCallModel = teleCallRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("O ID da TeleChamada não foi localizado."));

        updateDatesTeleCall(teleCallModel);

        return TeleCallMapper.toDTO(teleCallRepository.save(teleCallModel));

    }

    private void updateDatesTeleCall(TeleCallModel teleCallModel) {

        if (teleCallModel.getInitialDateTime() == null && teleCallModel.getFinalDateTime() == null) {
            teleCallModel.setInitialDateTime(LocalDateTime.now());
        } else if (teleCallModel.getInitialDateTime() != null && teleCallModel.getFinalDateTime() == null) {
            teleCallModel.setFinalDateTime(LocalDateTime.now());
        } else {
            teleCallModel.setInitialDateTime(LocalDateTime.now());
            teleCallModel.setFinalDateTime(null);
        }

    }

}

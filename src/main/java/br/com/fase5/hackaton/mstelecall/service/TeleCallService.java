package br.com.fase5.hackaton.mstelecall.service;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;

import java.util.UUID;

public interface TeleCallService {
    TeleCallDTO save();
    TeleCallDTO update(UUID id);
}

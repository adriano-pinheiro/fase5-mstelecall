package br.com.fase5.hackaton.mstelecall.service.impl;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;
import br.com.fase5.hackaton.mstelecall.exception.NotFoundException;
import br.com.fase5.hackaton.mstelecall.model.TeleCallModel;
import br.com.fase5.hackaton.mstelecall.repository.TeleCallRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Profile("test")
class TeleCallServiceImplTest {

    @Mock
    private TeleCallRepository teleCallRepository;

    @InjectMocks
    private TeleCallServiceImpl teleCallService;

    private UUID id;
    private TeleCallModel teleCallModel;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        teleCallModel = new TeleCallModel();
        teleCallModel.setId(id);
    }

    @Test
    void shouldUpdateInitialDateTimeWhenBothDatesAreNull() {
        when(teleCallRepository.findById(id)).thenReturn(Optional.of(teleCallModel));
        when(teleCallRepository.save(any(TeleCallModel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        TeleCallDTO updatedDTO = teleCallService.update(id);

        assertNotNull(updatedDTO.initialDateTime());
        assertNull(updatedDTO.finalDateTime());
        verify(teleCallRepository, times(1)).save(any(TeleCallModel.class));
    }

    @Test
    void shouldUpdateFinalDateTimeWhenOnlyInitialDateIsSet() {
        teleCallModel.setInitialDateTime(LocalDateTime.now().minusDays(1));

        when(teleCallRepository.findById(id)).thenReturn(Optional.of(teleCallModel));
        when(teleCallRepository.save(any(TeleCallModel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        TeleCallDTO updatedDTO = teleCallService.update(id);

        assertNotNull(updatedDTO.initialDateTime());
        assertNotNull(updatedDTO.finalDateTime());
        verify(teleCallRepository, times(1)).save(any(TeleCallModel.class));
    }

    @Test
    void shouldResetFinalDateTimeWhenBothDatesAreSet() {
        teleCallModel.setInitialDateTime(LocalDateTime.now().minusDays(2));
        teleCallModel.setFinalDateTime(LocalDateTime.now().minusDays(1));

        when(teleCallRepository.findById(id)).thenReturn(Optional.of(teleCallModel));
        when(teleCallRepository.save(any(TeleCallModel.class))).thenAnswer(invocation -> invocation.getArgument(0));

        TeleCallDTO updatedDTO = teleCallService.update(id);

        assertNotNull(updatedDTO.initialDateTime());
        assertNull(updatedDTO.finalDateTime());
        verify(teleCallRepository, times(1)).save(any(TeleCallModel.class));
    }

    @Test
    void shouldThrowNotFoundExceptionWhenIdDoesNotExist() {
        when(teleCallRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> teleCallService.update(id));

        verify(teleCallRepository, never()).save(any(TeleCallModel.class));
    }
}

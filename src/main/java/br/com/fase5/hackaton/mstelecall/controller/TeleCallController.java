package br.com.fase5.hackaton.mstelecall.controller;

import br.com.fase5.hackaton.mstelecall.dto.TeleCallDTO;
import br.com.fase5.hackaton.mstelecall.service.TeleCallService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/telecall")
@Tag(name = "TeleChamada", description = "Endpoints para Gerenciamento de TeleChamadas")
public class TeleCallController {

    private final TeleCallService teleCallService;

    public TeleCallController(TeleCallService teleCallService){
        this.teleCallService = teleCallService;
    }

    @Operation(summary = "Criar uma TeleChamada",
            description = "Este endpoint cria uma TeleChamada no sistema.")
    @PostMapping
    public ResponseEntity<TeleCallDTO> save() {
        TeleCallDTO telecall = teleCallService.save();
        return new ResponseEntity<>(telecall, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualizar a TeleChamada",
            description = "Este endpoint inicia ou encerra um TeleChamada ")
    @PutMapping("/{id}")
    public ResponseEntity<TeleCallDTO> update(@PathVariable UUID id){
        TeleCallDTO teleCall = teleCallService.update(id);
        return ResponseEntity.ok(teleCall);
    }

}

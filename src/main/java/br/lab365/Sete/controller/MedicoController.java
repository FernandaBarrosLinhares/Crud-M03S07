package br.lab365.Sete.controller;

import br.lab365.Sete.Dto.MedicoDto;
import br.lab365.Sete.model.MedicoModel;
import br.lab365.Sete.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("medico")
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody @Valid MedicoDto medicoDto){
        var medicoModel = new MedicoModel();

        BeanUtils.copyProperties(medicoDto, medicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
    }
    @GetMapping("medicos")
    public ResponseEntity<List<MedicoModel>> getAllMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }
    @GetMapping("medico/{id}")
    public ResponseEntity<Object> getOneMedico(@PathVariable(value="id") UUID id){
        Optional<MedicoModel> medicoO = medicoRepository.findById(id);
        if(medicoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found");
        }

        Optional<MedicoDto> medicoDto = medicoO.map(MedicoDto::new);
        return ResponseEntity.status(HttpStatus.OK).body(medicoDto.get());
    }

    @PutMapping("medico/{id}")
    public ResponseEntity<Object> updateMedico(@PathVariable(value="id") UUID id,
                                              @RequestBody @Valid MedicoDto alunoDto){
        Optional<MedicoModel> medicoO = medicoRepository.findById(id);
        if(medicoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found.");
        }
        var MedicoModel = medicoO.get();
        BeanUtils.copyProperties(alunoDto, MedicoModel);
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(MedicoModel));
    }

    @DeleteMapping("medico/{id}")
    public ResponseEntity<Object> deleteMedico(@PathVariable(value="id") UUID id){
        Optional<MedicoModel> medicoO = medicoRepository.findById(id);
        if(medicoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medico not found");
        }

        medicoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Medico deleted successfully.");

    }
}

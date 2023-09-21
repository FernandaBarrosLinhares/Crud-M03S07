package br.lab365.Sete.Dto;


import br.lab365.Sete.model.MedicoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record MedicoDto(

        @NotEmpty(message = "O campo Nome é obrigatório.")
        String nome,

        @NotBlank(message = "O campo Telefone é obrigatório.")
        @Size(min=16, max=16)
        String telefone,

        @NotBlank(message = "O campo E-mail é obrigatorio")
        @Email
                String email,

        @NotBlank(message= "o campo CRM é obrigatório")
        String crm
) {

    public MedicoDto(MedicoModel medico){
        this(medico.getNome(),medico.getEmail(), medico.getTelefone(),medico.getCrm());
    }


}

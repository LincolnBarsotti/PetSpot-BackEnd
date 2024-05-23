package br.com.petspot.model.dto.logindto;

import jakarta.validation.constraints.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record RegisterUserDto(
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*()_+{}|;':\"/.,<>?])[a-zA-Z0-9~!@#$%^&*()_+{}|;':\"/.,<>?]+$",
                message = "Senha inválida!")
                @Min(value = 8, message = "Senha precisa ter no mínimo 8 caracteres")
                @Max(value = 23, message = "Senha precisa ter no máximo 23 caracteres")
        String senha,
        @NotBlank
        String nome,
        @NotBlank
        String sobrenome,
        @NotBlank
        String dataDeNascimento
) {

     public Date getDate() {
         SimpleDateFormat inputFormatter = new SimpleDateFormat("yyyy-MM-dd");  // Input format
         SimpleDateFormat outputFormatter = new SimpleDateFormat("dd/MM/yyyy");  // Output format
            try {
                Date date = inputFormatter.parse(dataDeNascimento);
                return outputFormatter.parse(outputFormatter.format(date));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
}

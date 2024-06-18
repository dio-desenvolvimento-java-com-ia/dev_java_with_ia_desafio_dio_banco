package org.example.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Cliente {
    private String nome;
    private String email;
    private String telefone;

}

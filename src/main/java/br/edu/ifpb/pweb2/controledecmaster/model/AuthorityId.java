package br.edu.ifpb.pweb2.controledecmaster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public Static class AuthorityId implements Serializable {
    private String username;
    private String authority;
    }
}

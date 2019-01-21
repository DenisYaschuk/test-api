package com.testapi.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Token {
    @NonNull
    @Id
    private long token;

    @CreatedDate
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private LocalDateTime creationDateTime;


    public Token(long token) {
        this.token = token;
    }
}

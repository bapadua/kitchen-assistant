package io.github.bapadua.fooder.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Expirity {
    private LocalDate start;
    private LocalDate end;
}

package io.github.marrafon91.estudos.controller.exceptions;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class StandardError {

    private final Integer status;
    private final String mensagem;
    private final Long timeStamp;
}

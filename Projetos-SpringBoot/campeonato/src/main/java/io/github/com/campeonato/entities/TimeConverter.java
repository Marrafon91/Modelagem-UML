package io.github.com.campeonato.entities;

import io.github.com.campeonato.entities.enums.Time;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TimeConverter implements AttributeConverter<Time, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Time time) {
        if (time == null) {
            return null;
        }
        return time.getCodigo();
    }

    @Override
    public Time convertToEntityAttribute(Integer codigo) {
        if (codigo == null) {
            return null;
        }
        return Time.fromCodigo(codigo);
    }
}

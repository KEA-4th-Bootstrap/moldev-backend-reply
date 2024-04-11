package org.bootstrap.reply.utils;

import jakarta.persistence.AttributeConverter;
import lombok.Getter;

@Getter
public class AbstractEnumCodeAttributeConverter<T extends Enum<T>> implements AttributeConverter<T, Integer> {
    private Class<T> targetEnumClass;

    public AbstractEnumCodeAttributeConverter(Class<T> targetEnumClass) {
        this.targetEnumClass = targetEnumClass;
    }

    @Override
    public Integer convertToDatabaseColumn(T attribute) {
        return EnumValueUtils.toDBCode(attribute);
    }

    @Override
    public T convertToEntityAttribute(Integer dbData) {
        return EnumValueUtils.toEntityCode(targetEnumClass, dbData);
    }
}


package company.vk.genatulin.internshiptask.converters;

import org.springframework.core.convert.converter.Converter;

public class BooleanToStatusConverter implements Converter<Boolean, String> {
    @Override
    public String convert(Boolean source) {
        if (source.equals(true)) {
            return "authorised";
        }
        else {
            return "unauthorised";
        }
    }
}

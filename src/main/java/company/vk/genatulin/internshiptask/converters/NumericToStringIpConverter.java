package company.vk.genatulin.internshiptask.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class NumericToStringIpConverter implements Converter<Long, String> {
    @Override
    public String convert(Long source) {
        String w = String.valueOf(source << 24);
        String x = String.valueOf(source << 16);
        String y = String.valueOf(source << 8);
        String z = String.valueOf(source << 0);

        return w + "." + x + "." + y + "." + z;
    }
}

package company.vk.genatulin.internshiptask.converters;

import org.springframework.core.convert.converter.Converter;

public class StringToNumericIpConverter implements Converter<String, Long> {
    @Override
    public Long convert(String source) {
        if (!source.equals("")) {
            String[] ipParts = source.split("\\.");
            Long numericIP = 16777216 * Long.parseLong(ipParts[0]) + 65536 * Long.parseLong(ipParts[1]) + 256 * Long.parseLong(ipParts[2]) + Long.parseLong(ipParts[3]);

            return numericIP;
        }
        return 0L;
    }
}

package io.dataease.api.chart.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @Author gin
 */
@Data
public class ChartQuotaDTO {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
}

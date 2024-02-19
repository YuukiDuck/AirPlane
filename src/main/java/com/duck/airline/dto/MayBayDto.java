package com.duck.airline.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MayBayDto {
    @NotBlank(message = "Số hiệu máy bay không được để trống")
    private String soHieu;

    @NotNull(message = "ID loại máy bay không được để trống")
    private Long idLoaiMayBay;
}

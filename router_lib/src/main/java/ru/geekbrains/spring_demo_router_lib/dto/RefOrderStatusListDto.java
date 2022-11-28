package ru.geekbrains.spring_demo_router_lib.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RefOrderStatusListDto {
    private List<RefOrderStatusDto> statuses;

    public RefOrderStatusListDto(List<RefOrderStatusDto> statuses) {
        this.statuses = statuses;
    }
}

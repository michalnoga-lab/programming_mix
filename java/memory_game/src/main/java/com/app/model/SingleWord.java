package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SingleWord {
    private String word;
    private boolean guessed;
    private boolean visible;
    private String firstCoordinate;
    private String secondCoordinate;
}

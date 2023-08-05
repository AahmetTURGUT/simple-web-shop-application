package com.example.simplewebshopapplication.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CargoEnum {
    STANDART("standard"),
    EXPRESS("express");

    private final String value;
}

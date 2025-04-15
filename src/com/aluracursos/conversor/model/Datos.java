package com.aluracursos.conversor.model;

import com.google.gson.annotations.SerializedName;

public record Datos(
        @SerializedName("conversion_result")
        String conversion
) {

}

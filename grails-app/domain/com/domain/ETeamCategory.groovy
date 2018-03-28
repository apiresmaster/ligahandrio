package com.domain

enum ETeamCategory {
    TRINTAECINCOMAIS("Trinta e Cinco+"),
    QUARENTAEDOIS("Quarenta e Dois+"),
    CINQUENTA("Cinquenta+")

    String description

    ETeamCategory(String description){
        this.description = description
    }
}
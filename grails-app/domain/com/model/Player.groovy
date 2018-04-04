package com.model

import java.time.LocalDate

class Player {
    String name
    String nickname
    LocalDate birthDate
    String cpf

    static belongsTo = [team: Team]

    static constraints = {
        name maxSize: 128, unique: true
        nickname maxSize: 80
    }
}

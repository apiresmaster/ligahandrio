package com.domain

class Player {
    String name
    String nickname
    Calendar birthDate
    String cpf

    static belongsTo = [team: Team]

    static constraints = {
        name maxSize: 128, unique: true
        nickname maxSize: 80
    }
}

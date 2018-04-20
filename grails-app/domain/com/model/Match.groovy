package com.model

import java.time.LocalDate

class Match {

    LocalDate roundDate
    String description

    static hasMany = [teamMatch: TeamMatch]

    static constraints = {
    }
}

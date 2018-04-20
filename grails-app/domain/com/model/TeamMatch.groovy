package com.model

class TeamMatch {
    static belongsTo = [teamOne: Team, teamSecond: Team]
}

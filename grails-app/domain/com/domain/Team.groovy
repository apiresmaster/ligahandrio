package com.domain

class Team {
    String name
    String nickname
    List<Player> players

    static belongsTo = [genre: ETeamGenre, category: ETeamCategory]
    static hasMany = [players: Player]
    static constraints = {
        name blank: false , maxSize: 128 , unique: true
        players maxSize: 30
    }
}

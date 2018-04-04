package com.model

class Team {
    String name
    String nickname
    List<Player> players

    static belongsTo = [genre: ETeamGenre, category: ETeamCategory]
    static hasMany = [players: Player]
    static constraints = {
        name blank: false , maxSize: 128 , unique: true
        players maxSize: 30, validator: {pl, obj, errors ->
            pl.find{ p ->
                if((2018 - p.birthDate.getYear().toInteger()) <= obj.category.limitAge)
                    errors.rejectValue('players', 'noMatch')
            }
        }
    }
}

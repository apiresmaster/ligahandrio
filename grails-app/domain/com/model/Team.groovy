package com.model

class Team {
    private def data = new Date()
    String name
    String nickname
    List<Player> players

    static belongsTo = [genre: ETeamGenre, category: ETeamCategory]
    static hasMany = [players: Player]
    static constraints = {
        name blank: false , maxSize: 128 , unique: true
        players maxSize: 30, validator: {pl, obj, errors ->
            pl.find{ p ->
                if((obj.data.format("YYYY").toInteger() - p.birthDate.getYear().toInteger()) <= obj.category.limitAge)
                    errors.rejectValue('players', 'noMatch')
            }
        }
    }
}

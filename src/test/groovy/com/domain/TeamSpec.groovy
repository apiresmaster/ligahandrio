package com.domain

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import static java.util.Calendar.*

class TeamSpec extends Specification implements DomainUnitTest<Team> {

    def setup() {
    }

    def cleanup() {
    }

    void "não permitir inclusão de mais de trinta jogadores"() {

        def legiao = new Team(name: "Legiao"
                ,nickname: "Legiao"
                ,genre: ETeamGenre.MALE
                ,category: ETeamCategory.TRINTAECINCOMAIS
        )

        def dtNascimento = Calendar.instance
        dtNascimento.set(year:1981, month:JANUARY, date:24)

        for (int i = 0; i < 32; i++) {
            legiao.addToPlayers(new Player(name: "Alexandre Pires"
                ,nickname: "A. Pires"
                ,cpf: "09233356760"
                ,birthDate: dtNascimento
            ))
        }

        expect:"foi incluso mais de trinta atletas"
            legiao.save() == null
    }
}

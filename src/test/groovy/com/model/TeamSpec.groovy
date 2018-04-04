package com.model

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification
import java.time.LocalDate
import java.time.Month

class TeamSpec extends Specification implements DomainUnitTest<Team> {

    def setup() {
    }

    def cleanup() {
    }

    @Shared
    def time35Mais = new Team(name: "Time 35 Mais"
            ,nickname: "Time 35 Mais"
            ,genre: ETeamGenre.MALE
            ,category: ETeamCategory.TRINTAECINCOMAIS
    )

    @Shared
    def time42Mais = new Team(name: "Time 42 Mais"
            ,nickname: "Time 42 Mais"
            ,genre: ETeamGenre.MALE
            ,category: ETeamCategory.QUARENTAEDOIS
    )

    void "não permitir inclusão de mais de trinta jogadores"() {

        def dtNascimento = LocalDate.of(1981, Month.JANUARY, 24)

        for (int i = 0; i < 32; i++) {

            time35Mais.addToPlayers(new Player(name: "Alexandre Pires"
                ,nickname: "A. Pires"
                ,cpf: "09233356760"
                ,birthDate: dtNascimento
            ))
        }

        expect:"foi incluso mais de trinta atletas"
            time35Mais.save() == null
    }

    void "valida idade minima por categoria"(){
        def dtNascimento = LocalDate.of(1982, Month.JANUARY, 24)
        time35Mais.addToPlayers(new Player(name: "Alexandre Pires"
                ,nickname: "A. Pires"
                ,cpf: "09233356760"
                ,birthDate: dtNascimento
        ))

        def dtNascimento2 = LocalDate.of(1990, Month.JANUARY, 24)
        time35Mais.addToPlayers(new Player(name: "Atleta sem idade minima"
                ,nickname: "Atleta 2"
                ,cpf: "09233356760"
                ,birthDate: dtNascimento2
        ))
        expect:"Idade do atleta menor que exigido para categoria"
        time35Mais.save() == null
    }

    void "Quarenta e Dois, valida idade minima por categoria"(){
        def dtNascimento = LocalDate.of(1982, Month.JANUARY, 24)
        time42Mais.addToPlayers(new Player(name: "Atleta1"
                ,nickname: "Atleta1"
                ,cpf: "11111111111"
                ,birthDate: dtNascimento
        ))

        def dtNascimento2 = LocalDate.of(1990, Month.JANUARY, 24)
        time42Mais.addToPlayers(new Player(name: "Atleta2"
                ,nickname: "Atleta2"
                ,cpf: "11111111111"
                ,birthDate: dtNascimento2
        ))
        expect:"Idade do atleta menor que exigido para categoria"
        time42Mais.save() == null
    }
}

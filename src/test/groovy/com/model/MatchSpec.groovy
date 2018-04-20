package com.model

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

class MatchSpec extends Specification implements DomainUnitTest<Match> {

    def setup() {
    }

    def cleanup() {
    }

    @Shared
    def timeOne35Mais = new Team(name: "Time 35 Mais"
            ,nickname: "Time 35 Mais"
            ,genre: ETeamGenre.MALE
            ,category: ETeamCategory.TRINTAECINCOMAIS
    )

    @Shared
    def timeSecond35Mais = new Team(name: "Time2 35 Mais "
            ,nickname: "Time2 35 Mais"
            ,genre: ETeamGenre.MALE
            ,category: ETeamCategory.TRINTAECINCOMAIS
    )

    def dtNascimento = LocalDate.of(1981, Month.JANUARY, 24)

    void "Criar rodada com equipes 35 mais masculino"() {

        for (int i = 0; i < 30; i++) {
            timeOne35Mais.addToPlayers(new Player(name: "Alexandre Pires"
                    ,nickname: "Jogador ${i}"
                    ,cpf: "09233356760"
                    ,birthDate: dtNascimento
            ))
        }
        timeOne35Mais.save()

        for (int i = 0; i < 30; i++) {
            timeSecond35Mais.addToPlayers(new Player(name: "Alexandre Pires"
                    ,nickname: "Jogador ${i}"
                    ,cpf: "09233356760"
                    ,birthDate: dtNascimento
            ))
        }
        timeSecond35Mais.save()

        def dtRodada = LocalDate.of(2018, Month.APRIL, 17)
        def rodadaAbril = new Match(roundDate: dtRodada, description: "Ginásio do CEFED")

        rodadaAbril.teamMatch = [new TeamMatch(teamOne: timeOne35Mais, teamSecond: timeSecond35Mais)]


        expect:"fix me"
            rodadaAbril.save() != null
    }
}

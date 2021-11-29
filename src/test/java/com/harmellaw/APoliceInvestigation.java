package com.harmellaw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class APoliceInvestigation {

    PNCId pncId;
    Suspect suspect;
    PoliceInvestigation anInvestigation;

    @BeforeEach
    void setup() {
        pncId = new PNCId("1234-ESDT");
        suspect = new Suspect(CriminalOffence.FALSE_ACCOUNTING);
        anInvestigation = new PoliceInvestigation(pncId, suspect);
    }

    @Test
    void mustHaveAPoliceNationalComputerId() {
        assertNotNull(anInvestigation.pncId);
    }

    @Test
    void cannotBeCreatedWithAnEmptyPoliceNationalComputerId() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> anInvestigation = new PoliceInvestigation(null, suspect));
        assertThat(exception.getMessage()).contains("You must provide a PNC Id");
    }

    @Test
    void cannotBeCreatedWithNoSuspect() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> anInvestigation = new PoliceInvestigation(pncId, null));
        assertThat(exception.getMessage()).contains("You must provide a suspect");
    }
}

package com.harmellaw.investigation;

import java.util.Set;

import com.harmellaw.CriminalOffence;
import com.harmellaw.PNCId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APreChargeDecisionCase {
    private PreChargeDecisionCase preChargeDecisionCase;
    private OffenceAdvice offenceAdvice;
    private Suspect suspect;
    private Set<Suspect> suspects;

    @BeforeEach
    void setup() {
        PNCId pncId = new PNCId("ANOTHER_PNC_ID");
        suspect = new Suspect(CriminalOffence.CUTTING_AWAY_BUOYS_ETC);
        suspects = Set.of(suspect);
        preChargeDecisionCase = new PreChargeDecisionCase(pncId, suspects);
        offenceAdvice = new OffenceAdvice();
    }

    @Test
    void shouldRecordAlternativeOffenceAdviceAgainstSuspects() {
        preChargeDecisionCase.recordAlternativeOffenceAdvice(suspect, offenceAdvice);

        assertThat(offenceAdvice).isEqualTo(preChargeDecisionCase.getOffenceAdviceFor(suspect));
    }


}

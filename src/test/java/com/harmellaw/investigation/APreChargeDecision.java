package com.harmellaw.investigation;

import java.util.Collections;
import java.util.Set;

import com.harmellaw.CriminalOffence;
import com.harmellaw.PNCId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APreChargeDecision {
    private PreChargeDecision preChargeDecision;
    private OffenceAdvice offenceAdvice;
    private Suspect suspect;
    private Set<Suspect> suspects;

    @BeforeEach
    void setup() {
        PNCId pncId = new PNCId("ANOTHER_PNC_ID");
        suspect = new Suspect(CriminalOffence.CUTTING_AWAY_BUOYS_ETC);
        suspects = Set.of(suspect);
        preChargeDecision = new PreChargeDecision(pncId, suspects, Collections.emptyMap());
        offenceAdvice = new OffenceAdvice();
    }

    @Test
    void shouldRecordAlternativeOffenceAdviceAgainstSuspects() {
        preChargeDecision.recordAlternativeOffenceAdvice(suspect, offenceAdvice);

        assertThat(offenceAdvice).isEqualTo(preChargeDecision.getOffenceAdviceFor(suspect));
    }


}

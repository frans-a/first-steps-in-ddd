package com.harmellaw.investigation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.harmellaw.CriminalOffence;
import com.harmellaw.PNCId;

public class PreChargeDecision {
    private final PNCId pncId;
    private final Set<Suspect> suspects;
    private final Map<Suspect, CriminalOffence> offences;
    private Map<Suspect, OffenceAdvice> alternativeOffenceAdvice;

    public PreChargeDecision(PNCId pncId, Set<Suspect> suspects, Map<Suspect, CriminalOffence> offences) {
        this.pncId = pncId;
        this.suspects = suspects;
        this.offences = offences;
        this.alternativeOffenceAdvice = new HashMap<>();
    }

    public void recordAlternativeOffenceAdvice(Suspect suspect, OffenceAdvice offenceAdvice) {
        alternativeOffenceAdvice.put(suspect, offenceAdvice);
    }

    public OffenceAdvice getOffenceAdviceFor(Suspect suspect) {
        return alternativeOffenceAdvice.get(suspect);
    }
}

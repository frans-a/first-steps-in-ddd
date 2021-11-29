package com.harmellaw.investigation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.harmellaw.PNCId;

public class PreChargeDecisionCase {
    private final PNCId pncId;
    private final Map<Suspect, OffenceAdvice> alternativeOffenceAdvice;

    public PreChargeDecisionCase(PNCId pncId, Set<Suspect> suspects) {
        this.pncId = pncId;
        this.alternativeOffenceAdvice = new HashMap<>();
        suspects.stream().forEach(s -> alternativeOffenceAdvice.put(s, null));
    }

    public void recordAlternativeOffenceAdvice(Suspect suspect, OffenceAdvice offenceAdvice) {
        alternativeOffenceAdvice.put(suspect, offenceAdvice);
    }

    public OffenceAdvice getOffenceAdviceFor(Suspect suspect) {
        return alternativeOffenceAdvice.get(suspect);
    }

    public Set<Suspect> suspects() {
        return alternativeOffenceAdvice.keySet();
    }

    public PNCId pncId() {
        return pncId;
    }
}

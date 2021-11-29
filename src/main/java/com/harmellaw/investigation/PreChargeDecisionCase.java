package com.harmellaw.investigation;

import java.util.Set;

import com.harmellaw.PNCId;

public record PreChargeDecisionCase(PNCId pncId, Set<Suspect> suspects) {

}

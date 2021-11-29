package com.harmellaw.investigation;

public class PublicProsecutionService {
    public PreChargeDecisionCase receiveRequestForPreChargeDecision(PreChargeDecisionRequest preChargeDecisionRequest) {
        return new PreChargeDecisionCase(preChargeDecisionRequest.policeInvestigation().pncId,
                preChargeDecisionRequest.policeInvestigation().suspects);
    }
}

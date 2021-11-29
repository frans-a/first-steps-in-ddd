package com.harmellaw;

import com.harmellaw.investigation.PreChargeDecisionCase;
import com.harmellaw.investigation.PreChargeDecisionRequest;
import com.harmellaw.prosecution.CriminalCase;
import com.harmellaw.prosecution.PoliceCaseFile;

public class PublicProsecutionService {
    public PreChargeDecisionCase receiveRequestForPreChargeDecision(PreChargeDecisionRequest preChargeDecisionRequest) {
        return new PreChargeDecisionCase(preChargeDecisionRequest.policeInvestigation().pncId,
                preChargeDecisionRequest.policeInvestigation().suspects);
    }

    public CriminalCase acceptPoliceCaseFile(PoliceCaseFile policeCaseFile) {
        return new CriminalCase();
    }
}

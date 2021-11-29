package com.harmellaw.investigation;

import com.harmellaw.CriminalOffence;
import com.harmellaw.PNCId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThePublicProsecutionService {
    private PublicProsecutionService thePublicProsecutionService;
    private PNCId pncId;
    private Suspect suspect;
    private PreChargeDecisionRequest preChargeDecisionRequest;
    private PoliceInvestigation policeInvestigation;

    @BeforeEach
    public void setup() {
        thePublicProsecutionService = new PublicProsecutionService();
        pncId = new PNCId("AN-ID");
        suspect = new Suspect(CriminalOffence.CUTTING_AWAY_BUOYS_ETC);
        policeInvestigation = new PoliceInvestigation(pncId, suspect);
        preChargeDecisionRequest = new PreChargeDecisionRequest(policeInvestigation);
    }

    @Test
    void shouldCreateACaseWhenReceivingAPcdRequest() {
        PreChargeDecisionCase preChargeDecisionCase =
                thePublicProsecutionService.receiveRequestForPreChargeDecision(preChargeDecisionRequest);

        assertThat(preChargeDecisionCase.pncId()).isEqualTo(pncId);
        assertThat(preChargeDecisionCase.suspects()).isEqualTo(policeInvestigation.suspects);
    }
}
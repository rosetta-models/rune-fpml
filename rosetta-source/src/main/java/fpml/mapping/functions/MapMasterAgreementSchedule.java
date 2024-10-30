package fpml.mapping.functions;

import cdm.legaldocumentation.master.MasterAgreementSchedule;
import cdm.legaldocumentation.master.MasterAgreementSchedule.MasterAgreementScheduleBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMasterAgreementSchedule.MapMasterAgreementScheduleDefault.class)
public abstract class MapMasterAgreementSchedule implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterAgreementClauseList mapMasterAgreementClauseList;

	/**
	* @param fpmlDataDocument 
	* @return masterAgreementSchedule 
	*/
	public MasterAgreementSchedule evaluate(DataDocument fpmlDataDocument) {
		MasterAgreementSchedule.MasterAgreementScheduleBuilder masterAgreementScheduleBuilder = doEvaluate(fpmlDataDocument);
		
		final MasterAgreementSchedule masterAgreementSchedule;
		if (masterAgreementScheduleBuilder == null) {
			masterAgreementSchedule = null;
		} else {
			masterAgreementSchedule = masterAgreementScheduleBuilder.build();
			objectValidator.validate(MasterAgreementSchedule.class, masterAgreementSchedule);
		}
		
		return masterAgreementSchedule;
	}

	protected abstract MasterAgreementSchedule.MasterAgreementScheduleBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterAgreementScheduleDefault extends MapMasterAgreementSchedule {
		@Override
		protected MasterAgreementSchedule.MasterAgreementScheduleBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MasterAgreementSchedule.MasterAgreementScheduleBuilder masterAgreementSchedule = MasterAgreementSchedule.builder();
			return assignOutput(masterAgreementSchedule, fpmlDataDocument);
		}
		
		protected MasterAgreementSchedule.MasterAgreementScheduleBuilder assignOutput(MasterAgreementSchedule.MasterAgreementScheduleBuilder masterAgreementSchedule, DataDocument fpmlDataDocument) {
			masterAgreementSchedule = toBuilder(MasterAgreementSchedule.builder()
				.setClause(new ArrayList(mapMasterAgreementClauseList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(masterAgreementSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

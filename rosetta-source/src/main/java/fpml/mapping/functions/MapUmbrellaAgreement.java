package fpml.mapping.functions;

import cdm.legaldocumentation.common.UmbrellaAgreement;
import cdm.legaldocumentation.common.UmbrellaAgreement.UmbrellaAgreementBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUmbrellaAgreement.MapUmbrellaAgreementDefault.class)
public abstract class MapUmbrellaAgreement implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapUmbrellaAgreementEntityList mapUmbrellaAgreementEntityList;

	/**
	* @param fpmlDataDocument 
	* @return umbrellaAgreement 
	*/
	public UmbrellaAgreement evaluate(DataDocument fpmlDataDocument) {
		UmbrellaAgreement.UmbrellaAgreementBuilder umbrellaAgreementBuilder = doEvaluate(fpmlDataDocument);
		
		final UmbrellaAgreement umbrellaAgreement;
		if (umbrellaAgreementBuilder == null) {
			umbrellaAgreement = null;
		} else {
			umbrellaAgreement = umbrellaAgreementBuilder.build();
			objectValidator.validate(UmbrellaAgreement.class, umbrellaAgreement);
		}
		
		return umbrellaAgreement;
	}

	protected abstract UmbrellaAgreement.UmbrellaAgreementBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapUmbrellaAgreementDefault extends MapUmbrellaAgreement {
		@Override
		protected UmbrellaAgreement.UmbrellaAgreementBuilder doEvaluate(DataDocument fpmlDataDocument) {
			UmbrellaAgreement.UmbrellaAgreementBuilder umbrellaAgreement = UmbrellaAgreement.builder();
			return assignOutput(umbrellaAgreement, fpmlDataDocument);
		}
		
		protected UmbrellaAgreement.UmbrellaAgreementBuilder assignOutput(UmbrellaAgreement.UmbrellaAgreementBuilder umbrellaAgreement, DataDocument fpmlDataDocument) {
			umbrellaAgreement = toBuilder(UmbrellaAgreement.builder()
				.setIsApplicable(null)
				.setLanguage(null)
				.setParties(new ArrayList(mapUmbrellaAgreementEntityList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(umbrellaAgreement)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

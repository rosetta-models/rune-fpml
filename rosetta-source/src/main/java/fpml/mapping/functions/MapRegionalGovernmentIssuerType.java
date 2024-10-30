package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.RegionalGovernmentIssuerType;
import cdm.base.staticdata.asset.common.RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRegionalGovernmentIssuerType.MapRegionalGovernmentIssuerTypeDefault.class)
public abstract class MapRegionalGovernmentIssuerType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return regionalGovernmentIssuerType 
	*/
	public RegionalGovernmentIssuerType evaluate(DataDocument fpmlDataDocument) {
		RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder regionalGovernmentIssuerTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final RegionalGovernmentIssuerType regionalGovernmentIssuerType;
		if (regionalGovernmentIssuerTypeBuilder == null) {
			regionalGovernmentIssuerType = null;
		} else {
			regionalGovernmentIssuerType = regionalGovernmentIssuerTypeBuilder.build();
			objectValidator.validate(RegionalGovernmentIssuerType.class, regionalGovernmentIssuerType);
		}
		
		return regionalGovernmentIssuerType;
	}

	protected abstract RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRegionalGovernmentIssuerTypeDefault extends MapRegionalGovernmentIssuerType {
		@Override
		protected RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder regionalGovernmentIssuerType = RegionalGovernmentIssuerType.builder();
			return assignOutput(regionalGovernmentIssuerType, fpmlDataDocument);
		}
		
		protected RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder assignOutput(RegionalGovernmentIssuerType.RegionalGovernmentIssuerTypeBuilder regionalGovernmentIssuerType, DataDocument fpmlDataDocument) {
			regionalGovernmentIssuerType = toBuilder(RegionalGovernmentIssuerType.builder()
				.setSovereignRecourse(null)
				.build());
			
			return Optional.ofNullable(regionalGovernmentIssuerType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

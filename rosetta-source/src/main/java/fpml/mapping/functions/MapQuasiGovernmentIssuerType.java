package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType;
import cdm.base.staticdata.asset.common.QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapQuasiGovernmentIssuerType.MapQuasiGovernmentIssuerTypeDefault.class)
public abstract class MapQuasiGovernmentIssuerType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return quasiGovernmentIssuerType 
	*/
	public QuasiGovernmentIssuerType evaluate(DataDocument fpmlDataDocument) {
		QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder quasiGovernmentIssuerTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final QuasiGovernmentIssuerType quasiGovernmentIssuerType;
		if (quasiGovernmentIssuerTypeBuilder == null) {
			quasiGovernmentIssuerType = null;
		} else {
			quasiGovernmentIssuerType = quasiGovernmentIssuerTypeBuilder.build();
			objectValidator.validate(QuasiGovernmentIssuerType.class, quasiGovernmentIssuerType);
		}
		
		return quasiGovernmentIssuerType;
	}

	protected abstract QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapQuasiGovernmentIssuerTypeDefault extends MapQuasiGovernmentIssuerType {
		@Override
		protected QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder quasiGovernmentIssuerType = QuasiGovernmentIssuerType.builder();
			return assignOutput(quasiGovernmentIssuerType, fpmlDataDocument);
		}
		
		protected QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder assignOutput(QuasiGovernmentIssuerType.QuasiGovernmentIssuerTypeBuilder quasiGovernmentIssuerType, DataDocument fpmlDataDocument) {
			quasiGovernmentIssuerType = toBuilder(QuasiGovernmentIssuerType.builder()
				.setSovereignEntity(null)
				.setSovereignRecourse(null)
				.build());
			
			return Optional.ofNullable(quasiGovernmentIssuerType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

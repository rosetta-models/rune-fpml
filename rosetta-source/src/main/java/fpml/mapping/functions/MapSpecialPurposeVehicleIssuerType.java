package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.SpecialPurposeVehicleIssuerType;
import cdm.base.staticdata.asset.common.SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSpecialPurposeVehicleIssuerType.MapSpecialPurposeVehicleIssuerTypeDefault.class)
public abstract class MapSpecialPurposeVehicleIssuerType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return specialPurposeVehicleIssuerType 
	*/
	public SpecialPurposeVehicleIssuerType evaluate(DataDocument fpmlDataDocument) {
		SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder specialPurposeVehicleIssuerTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final SpecialPurposeVehicleIssuerType specialPurposeVehicleIssuerType;
		if (specialPurposeVehicleIssuerTypeBuilder == null) {
			specialPurposeVehicleIssuerType = null;
		} else {
			specialPurposeVehicleIssuerType = specialPurposeVehicleIssuerTypeBuilder.build();
			objectValidator.validate(SpecialPurposeVehicleIssuerType.class, specialPurposeVehicleIssuerType);
		}
		
		return specialPurposeVehicleIssuerType;
	}

	protected abstract SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSpecialPurposeVehicleIssuerTypeDefault extends MapSpecialPurposeVehicleIssuerType {
		@Override
		protected SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder specialPurposeVehicleIssuerType = SpecialPurposeVehicleIssuerType.builder();
			return assignOutput(specialPurposeVehicleIssuerType, fpmlDataDocument);
		}
		
		protected SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder assignOutput(SpecialPurposeVehicleIssuerType.SpecialPurposeVehicleIssuerTypeBuilder specialPurposeVehicleIssuerType, DataDocument fpmlDataDocument) {
			specialPurposeVehicleIssuerType = toBuilder(SpecialPurposeVehicleIssuerType.builder()
				.setCreditRisk(null)
				.build());
			
			return Optional.ofNullable(specialPurposeVehicleIssuerType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

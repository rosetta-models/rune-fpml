package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.Security.SecurityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSecurity.MapSecurityDefault.class)
public abstract class MapSecurity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapDebtType mapDebtType;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return security 
	*/
	public Security evaluate(DataDocument fpmlDataDocument) {
		Security.SecurityBuilder securityBuilder = doEvaluate(fpmlDataDocument);
		
		final Security security;
		if (securityBuilder == null) {
			security = null;
		} else {
			security = securityBuilder.build();
			objectValidator.validate(Security.class, security);
		}
		
		return security;
	}

	protected abstract Security.SecurityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSecurityDefault extends MapSecurity {
		@Override
		protected Security.SecurityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Security.SecurityBuilder security = Security.builder();
			return assignOutput(security, fpmlDataDocument);
		}
		
		protected Security.SecurityBuilder assignOutput(Security.SecurityBuilder security, DataDocument fpmlDataDocument) {
			security = toBuilder(Security.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setSecurityType(null)
				.setDebtType(mapDebtType.evaluate(fpmlDataDocument))
				.setEquityType(null)
				.setFundType(null)
				.build());
			
			return Optional.ofNullable(security)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

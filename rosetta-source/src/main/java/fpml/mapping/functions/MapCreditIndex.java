package fpml.mapping.functions;

import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.CreditIndex.CreditIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditIndex.MapCreditIndexDefault.class)
public abstract class MapCreditIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapIndexAnnexSourceWithScheme mapIndexAnnexSourceWithScheme;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapReferenceInformationList mapReferenceInformationList;
	@Inject protected MapSettledEntityMatrix mapSettledEntityMatrix;
	@Inject protected MapTaxonomyList mapTaxonomyList;
	@Inject protected MapTranche mapTranche;

	/**
	* @param fpmlDataDocument 
	* @return creditIndex 
	*/
	public CreditIndex evaluate(DataDocument fpmlDataDocument) {
		CreditIndex.CreditIndexBuilder creditIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditIndex creditIndex;
		if (creditIndexBuilder == null) {
			creditIndex = null;
		} else {
			creditIndex = creditIndexBuilder.build();
			objectValidator.validate(CreditIndex.class, creditIndex);
		}
		
		return creditIndex;
	}

	protected abstract CreditIndex.CreditIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditIndexDefault extends MapCreditIndex {
		@Override
		protected CreditIndex.CreditIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditIndex.CreditIndexBuilder creditIndex = CreditIndex.builder();
			return assignOutput(creditIndex, fpmlDataDocument);
		}
		
		protected CreditIndex.CreditIndexBuilder assignOutput(CreditIndex.CreditIndexBuilder creditIndex, DataDocument fpmlDataDocument) {
			creditIndex = toBuilder(CreditIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.setIndexSeries(null)
				.setIndexAnnexVersion(null)
				.setIndexAnnexDate(null)
				.setIndexAnnexSourceValue(mapIndexAnnexSourceWithScheme.evaluate(fpmlDataDocument))
				.setExcludedReferenceEntity(new ArrayList(mapReferenceInformationList.evaluate(fpmlDataDocument)))
				.setTranche(mapTranche.evaluate(fpmlDataDocument))
				.setSettledEntityMatrix(mapSettledEntityMatrix.evaluate(fpmlDataDocument))
				.setIndexFactor(null)
				.setSeniority(null)
				.build());
			
			return Optional.ofNullable(creditIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

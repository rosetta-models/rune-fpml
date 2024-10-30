package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Loan.LoanBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLoan.MapLoanDefault.class)
public abstract class MapLoan implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapFacilityTypeWithScheme mapFacilityTypeWithScheme;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapLienWithScheme mapLienWithScheme;
	@Inject protected MapTaxonomyList mapTaxonomyList;
	@Inject protected MapTrancheWithScheme mapTrancheWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return loan 
	*/
	public Loan evaluate(DataDocument fpmlDataDocument) {
		Loan.LoanBuilder loanBuilder = doEvaluate(fpmlDataDocument);
		
		final Loan loan;
		if (loanBuilder == null) {
			loan = null;
		} else {
			loan = loanBuilder.build();
			objectValidator.validate(Loan.class, loan);
		}
		
		return loan;
	}

	protected abstract Loan.LoanBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLoanDefault extends MapLoan {
		@Override
		protected Loan.LoanBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Loan.LoanBuilder loan = Loan.builder();
			return assignOutput(loan, fpmlDataDocument);
		}
		
		protected Loan.LoanBuilder assignOutput(Loan.LoanBuilder loan, DataDocument fpmlDataDocument) {
			loan = toBuilder(Loan.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setBorrower(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setLienValue(mapLienWithScheme.evaluate(fpmlDataDocument))
				.setFacilityTypeValue(mapFacilityTypeWithScheme.evaluate(fpmlDataDocument))
				.setCreditAgreementDate(null)
				.setTrancheValue(mapTrancheWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(loan)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}

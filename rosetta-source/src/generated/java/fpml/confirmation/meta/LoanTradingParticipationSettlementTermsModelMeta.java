package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingParticipationSettlementTermsModel;
import fpml.confirmation.validation.LoanTradingParticipationSettlementTermsModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingParticipationSettlementTermsModelValidator;
import fpml.confirmation.validation.exists.LoanTradingParticipationSettlementTermsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingParticipationSettlementTermsModel.class)
public class LoanTradingParticipationSettlementTermsModelMeta implements RosettaMetaData<LoanTradingParticipationSettlementTermsModel> {

	@Override
	public List<Validator<? super LoanTradingParticipationSettlementTermsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingParticipationSettlementTermsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingParticipationSettlementTermsModel> validator() {
		return new LoanTradingParticipationSettlementTermsModelValidator();
	}

	@Override
	public Validator<? super LoanTradingParticipationSettlementTermsModel> typeFormatValidator() {
		return new LoanTradingParticipationSettlementTermsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingParticipationSettlementTermsModel, Set<String>> onlyExistsValidator() {
		return new LoanTradingParticipationSettlementTermsModelOnlyExistsValidator();
	}
}

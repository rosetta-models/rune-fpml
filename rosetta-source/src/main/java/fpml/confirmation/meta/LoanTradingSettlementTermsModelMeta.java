package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingSettlementTermsModel;
import fpml.confirmation.validation.LoanTradingSettlementTermsModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingSettlementTermsModelValidator;
import fpml.confirmation.validation.exists.LoanTradingSettlementTermsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingSettlementTermsModel.class)
public class LoanTradingSettlementTermsModelMeta implements RosettaMetaData<LoanTradingSettlementTermsModel> {

	@Override
	public List<Validator<? super LoanTradingSettlementTermsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingSettlementTermsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingSettlementTermsModel> validator() {
		return new LoanTradingSettlementTermsModelValidator();
	}

	@Override
	public Validator<? super LoanTradingSettlementTermsModel> typeFormatValidator() {
		return new LoanTradingSettlementTermsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingSettlementTermsModel, Set<String>> onlyExistsValidator() {
		return new LoanTradingSettlementTermsModelOnlyExistsValidator();
	}
}

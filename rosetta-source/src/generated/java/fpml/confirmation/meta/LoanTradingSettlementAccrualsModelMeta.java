package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingSettlementAccrualsModel;
import fpml.confirmation.validation.LoanTradingSettlementAccrualsModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingSettlementAccrualsModelValidator;
import fpml.confirmation.validation.exists.LoanTradingSettlementAccrualsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingSettlementAccrualsModel.class)
public class LoanTradingSettlementAccrualsModelMeta implements RosettaMetaData<LoanTradingSettlementAccrualsModel> {

	@Override
	public List<Validator<? super LoanTradingSettlementAccrualsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingSettlementAccrualsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingSettlementAccrualsModel> validator() {
		return new LoanTradingSettlementAccrualsModelValidator();
	}

	@Override
	public Validator<? super LoanTradingSettlementAccrualsModel> typeFormatValidator() {
		return new LoanTradingSettlementAccrualsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingSettlementAccrualsModel, Set<String>> onlyExistsValidator() {
		return new LoanTradingSettlementAccrualsModelOnlyExistsValidator();
	}
}

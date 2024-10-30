package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingTransferFeeDeterminationModel;
import fpml.confirmation.validation.LoanTradingTransferFeeDeterminationModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingTransferFeeDeterminationModelValidator;
import fpml.confirmation.validation.exists.LoanTradingTransferFeeDeterminationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanTradingTransferFeeDeterminationModel.class)
public class LoanTradingTransferFeeDeterminationModelMeta implements RosettaMetaData<LoanTradingTransferFeeDeterminationModel> {

	@Override
	public List<Validator<? super LoanTradingTransferFeeDeterminationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingTransferFeeDeterminationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingTransferFeeDeterminationModel> validator() {
		return new LoanTradingTransferFeeDeterminationModelValidator();
	}

	@Override
	public Validator<? super LoanTradingTransferFeeDeterminationModel> typeFormatValidator() {
		return new LoanTradingTransferFeeDeterminationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingTransferFeeDeterminationModel, Set<String>> onlyExistsValidator() {
		return new LoanTradingTransferFeeDeterminationModelOnlyExistsValidator();
	}
}

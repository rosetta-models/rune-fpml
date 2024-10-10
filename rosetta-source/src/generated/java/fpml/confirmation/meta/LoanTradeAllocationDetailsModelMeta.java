package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeAllocationDetailsModel;
import fpml.confirmation.validation.LoanTradeAllocationDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeAllocationDetailsModelValidator;
import fpml.confirmation.validation.exists.LoanTradeAllocationDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeAllocationDetailsModel.class)
public class LoanTradeAllocationDetailsModelMeta implements RosettaMetaData<LoanTradeAllocationDetailsModel> {

	@Override
	public List<Validator<? super LoanTradeAllocationDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeAllocationDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeAllocationDetailsModel> validator() {
		return new LoanTradeAllocationDetailsModelValidator();
	}

	@Override
	public Validator<? super LoanTradeAllocationDetailsModel> typeFormatValidator() {
		return new LoanTradeAllocationDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeAllocationDetailsModel, Set<String>> onlyExistsValidator() {
		return new LoanTradeAllocationDetailsModelOnlyExistsValidator();
	}
}

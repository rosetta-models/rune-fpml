package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanAllocationPartiesModel;
import fpml.confirmation.validation.LoanAllocationPartiesModelTypeFormatValidator;
import fpml.confirmation.validation.LoanAllocationPartiesModelValidator;
import fpml.confirmation.validation.exists.LoanAllocationPartiesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanAllocationPartiesModel.class)
public class LoanAllocationPartiesModelMeta implements RosettaMetaData<LoanAllocationPartiesModel> {

	@Override
	public List<Validator<? super LoanAllocationPartiesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationPartiesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanAllocationPartiesModel> validator() {
		return new LoanAllocationPartiesModelValidator();
	}

	@Override
	public Validator<? super LoanAllocationPartiesModel> typeFormatValidator() {
		return new LoanAllocationPartiesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationPartiesModel, Set<String>> onlyExistsValidator() {
		return new LoanAllocationPartiesModelOnlyExistsValidator();
	}
}

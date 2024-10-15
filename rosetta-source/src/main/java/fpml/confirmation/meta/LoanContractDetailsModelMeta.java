package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractDetailsModel;
import fpml.confirmation.validation.LoanContractDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.LoanContractDetailsModelValidator;
import fpml.confirmation.validation.exists.LoanContractDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanContractDetailsModel.class)
public class LoanContractDetailsModelMeta implements RosettaMetaData<LoanContractDetailsModel> {

	@Override
	public List<Validator<? super LoanContractDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanContractDetailsModel>create(fpml.confirmation.validation.datarule.LoanContractDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanContractDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractDetailsModel> validator() {
		return new LoanContractDetailsModelValidator();
	}

	@Override
	public Validator<? super LoanContractDetailsModel> typeFormatValidator() {
		return new LoanContractDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractDetailsModel, Set<String>> onlyExistsValidator() {
		return new LoanContractDetailsModelOnlyExistsValidator();
	}
}

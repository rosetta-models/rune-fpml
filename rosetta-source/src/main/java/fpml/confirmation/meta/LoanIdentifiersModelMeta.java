package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanIdentifiersModel;
import fpml.confirmation.validation.LoanIdentifiersModelTypeFormatValidator;
import fpml.confirmation.validation.LoanIdentifiersModelValidator;
import fpml.confirmation.validation.exists.LoanIdentifiersModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanIdentifiersModel.class)
public class LoanIdentifiersModelMeta implements RosettaMetaData<LoanIdentifiersModel> {

	@Override
	public List<Validator<? super LoanIdentifiersModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanIdentifiersModel>create(fpml.confirmation.validation.datarule.LoanIdentifiersModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanIdentifiersModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanIdentifiersModel> validator() {
		return new LoanIdentifiersModelValidator();
	}

	@Override
	public Validator<? super LoanIdentifiersModel> typeFormatValidator() {
		return new LoanIdentifiersModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanIdentifiersModel, Set<String>> onlyExistsValidator() {
		return new LoanIdentifiersModelOnlyExistsValidator();
	}
}

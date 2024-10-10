package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanChoice;
import fpml.confirmation.validation.LoanChoiceTypeFormatValidator;
import fpml.confirmation.validation.LoanChoiceValidator;
import fpml.confirmation.validation.exists.LoanChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanChoice.class)
public class LoanChoiceMeta implements RosettaMetaData<LoanChoice> {

	@Override
	public List<Validator<? super LoanChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanChoice>create(fpml.confirmation.validation.datarule.LoanChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanChoice> validator() {
		return new LoanChoiceValidator();
	}

	@Override
	public Validator<? super LoanChoice> typeFormatValidator() {
		return new LoanChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanChoice, Set<String>> onlyExistsValidator() {
		return new LoanChoiceOnlyExistsValidator();
	}
}

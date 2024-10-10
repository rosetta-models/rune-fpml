package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCredit;
import fpml.confirmation.validation.LetterOfCreditTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditValidator;
import fpml.confirmation.validation.exists.LetterOfCreditOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LetterOfCredit.class)
public class LetterOfCreditMeta implements RosettaMetaData<LetterOfCredit> {

	@Override
	public List<Validator<? super LetterOfCredit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCredit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCredit> validator() {
		return new LetterOfCreditValidator();
	}

	@Override
	public Validator<? super LetterOfCredit> typeFormatValidator() {
		return new LetterOfCreditTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCredit, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditSummary;
import fpml.confirmation.validation.LetterOfCreditSummaryTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditSummaryValidator;
import fpml.confirmation.validation.exists.LetterOfCreditSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LetterOfCreditSummary.class)
public class LetterOfCreditSummaryMeta implements RosettaMetaData<LetterOfCreditSummary> {

	@Override
	public List<Validator<? super LetterOfCreditSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditSummary> validator() {
		return new LetterOfCreditSummaryValidator();
	}

	@Override
	public Validator<? super LetterOfCreditSummary> typeFormatValidator() {
		return new LetterOfCreditSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditSummary, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditSummaryOnlyExistsValidator();
	}
}

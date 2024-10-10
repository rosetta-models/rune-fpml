package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LetterOfCreditReference;
import fpml.confirmation.validation.LetterOfCreditReferenceTypeFormatValidator;
import fpml.confirmation.validation.LetterOfCreditReferenceValidator;
import fpml.confirmation.validation.exists.LetterOfCreditReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LetterOfCreditReference.class)
public class LetterOfCreditReferenceMeta implements RosettaMetaData<LetterOfCreditReference> {

	@Override
	public List<Validator<? super LetterOfCreditReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LetterOfCreditReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LetterOfCreditReference> validator() {
		return new LetterOfCreditReferenceValidator();
	}

	@Override
	public Validator<? super LetterOfCreditReference> typeFormatValidator() {
		return new LetterOfCreditReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LetterOfCreditReference, Set<String>> onlyExistsValidator() {
		return new LetterOfCreditReferenceOnlyExistsValidator();
	}
}

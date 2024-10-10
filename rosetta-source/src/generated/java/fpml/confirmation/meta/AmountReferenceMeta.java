package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmountReference;
import fpml.confirmation.validation.AmountReferenceTypeFormatValidator;
import fpml.confirmation.validation.AmountReferenceValidator;
import fpml.confirmation.validation.exists.AmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmountReference.class)
public class AmountReferenceMeta implements RosettaMetaData<AmountReference> {

	@Override
	public List<Validator<? super AmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AmountReference> validator() {
		return new AmountReferenceValidator();
	}

	@Override
	public Validator<? super AmountReference> typeFormatValidator() {
		return new AmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmountReference, Set<String>> onlyExistsValidator() {
		return new AmountReferenceOnlyExistsValidator();
	}
}

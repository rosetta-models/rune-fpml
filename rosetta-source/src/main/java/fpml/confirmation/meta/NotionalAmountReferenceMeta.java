package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalAmountReference;
import fpml.confirmation.validation.NotionalAmountReferenceTypeFormatValidator;
import fpml.confirmation.validation.NotionalAmountReferenceValidator;
import fpml.confirmation.validation.exists.NotionalAmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalAmountReference.class)
public class NotionalAmountReferenceMeta implements RosettaMetaData<NotionalAmountReference> {

	@Override
	public List<Validator<? super NotionalAmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalAmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalAmountReference> validator() {
		return new NotionalAmountReferenceValidator();
	}

	@Override
	public Validator<? super NotionalAmountReference> typeFormatValidator() {
		return new NotionalAmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalAmountReference, Set<String>> onlyExistsValidator() {
		return new NotionalAmountReferenceOnlyExistsValidator();
	}
}

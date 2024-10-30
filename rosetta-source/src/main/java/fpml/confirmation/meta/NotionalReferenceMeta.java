package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.validation.NotionalReferenceTypeFormatValidator;
import fpml.confirmation.validation.NotionalReferenceValidator;
import fpml.confirmation.validation.exists.NotionalReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NotionalReference.class)
public class NotionalReferenceMeta implements RosettaMetaData<NotionalReference> {

	@Override
	public List<Validator<? super NotionalReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalReference> validator() {
		return new NotionalReferenceValidator();
	}

	@Override
	public Validator<? super NotionalReference> typeFormatValidator() {
		return new NotionalReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalReference, Set<String>> onlyExistsValidator() {
		return new NotionalReferenceOnlyExistsValidator();
	}
}

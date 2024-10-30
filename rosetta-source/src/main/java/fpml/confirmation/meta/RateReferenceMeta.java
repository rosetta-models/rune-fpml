package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateReference;
import fpml.confirmation.validation.RateReferenceTypeFormatValidator;
import fpml.confirmation.validation.RateReferenceValidator;
import fpml.confirmation.validation.exists.RateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RateReference.class)
public class RateReferenceMeta implements RosettaMetaData<RateReference> {

	@Override
	public List<Validator<? super RateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateReference> validator() {
		return new RateReferenceValidator();
	}

	@Override
	public Validator<? super RateReference> typeFormatValidator() {
		return new RateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateReference, Set<String>> onlyExistsValidator() {
		return new RateReferenceOnlyExistsValidator();
	}
}

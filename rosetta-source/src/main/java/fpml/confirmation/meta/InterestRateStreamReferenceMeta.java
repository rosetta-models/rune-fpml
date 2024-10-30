package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestRateStreamReference;
import fpml.confirmation.validation.InterestRateStreamReferenceTypeFormatValidator;
import fpml.confirmation.validation.InterestRateStreamReferenceValidator;
import fpml.confirmation.validation.exists.InterestRateStreamReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterestRateStreamReference.class)
public class InterestRateStreamReferenceMeta implements RosettaMetaData<InterestRateStreamReference> {

	@Override
	public List<Validator<? super InterestRateStreamReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestRateStreamReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestRateStreamReference> validator() {
		return new InterestRateStreamReferenceValidator();
	}

	@Override
	public Validator<? super InterestRateStreamReference> typeFormatValidator() {
		return new InterestRateStreamReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestRateStreamReference, Set<String>> onlyExistsValidator() {
		return new InterestRateStreamReferenceOnlyExistsValidator();
	}
}

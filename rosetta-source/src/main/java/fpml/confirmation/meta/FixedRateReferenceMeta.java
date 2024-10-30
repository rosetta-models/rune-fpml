package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRateReference;
import fpml.confirmation.validation.FixedRateReferenceTypeFormatValidator;
import fpml.confirmation.validation.FixedRateReferenceValidator;
import fpml.confirmation.validation.exists.FixedRateReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedRateReference.class)
public class FixedRateReferenceMeta implements RosettaMetaData<FixedRateReference> {

	@Override
	public List<Validator<? super FixedRateReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedRateReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRateReference> validator() {
		return new FixedRateReferenceValidator();
	}

	@Override
	public Validator<? super FixedRateReference> typeFormatValidator() {
		return new FixedRateReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRateReference, Set<String>> onlyExistsValidator() {
		return new FixedRateReferenceOnlyExistsValidator();
	}
}

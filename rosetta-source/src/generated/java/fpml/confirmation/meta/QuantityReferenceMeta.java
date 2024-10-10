package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuantityReference;
import fpml.confirmation.validation.QuantityReferenceTypeFormatValidator;
import fpml.confirmation.validation.QuantityReferenceValidator;
import fpml.confirmation.validation.exists.QuantityReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=QuantityReference.class)
public class QuantityReferenceMeta implements RosettaMetaData<QuantityReference> {

	@Override
	public List<Validator<? super QuantityReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuantityReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuantityReference> validator() {
		return new QuantityReferenceValidator();
	}

	@Override
	public Validator<? super QuantityReference> typeFormatValidator() {
		return new QuantityReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityReference, Set<String>> onlyExistsValidator() {
		return new QuantityReferenceOnlyExistsValidator();
	}
}

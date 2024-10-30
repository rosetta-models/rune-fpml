package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NumberOfUnitsReference;
import fpml.confirmation.validation.NumberOfUnitsReferenceTypeFormatValidator;
import fpml.confirmation.validation.NumberOfUnitsReferenceValidator;
import fpml.confirmation.validation.exists.NumberOfUnitsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NumberOfUnitsReference.class)
public class NumberOfUnitsReferenceMeta implements RosettaMetaData<NumberOfUnitsReference> {

	@Override
	public List<Validator<? super NumberOfUnitsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NumberOfUnitsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NumberOfUnitsReference> validator() {
		return new NumberOfUnitsReferenceValidator();
	}

	@Override
	public Validator<? super NumberOfUnitsReference> typeFormatValidator() {
		return new NumberOfUnitsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NumberOfUnitsReference, Set<String>> onlyExistsValidator() {
		return new NumberOfUnitsReferenceOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.validation.NumberOfOptionsReferenceTypeFormatValidator;
import fpml.confirmation.validation.NumberOfOptionsReferenceValidator;
import fpml.confirmation.validation.exists.NumberOfOptionsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NumberOfOptionsReference.class)
public class NumberOfOptionsReferenceMeta implements RosettaMetaData<NumberOfOptionsReference> {

	@Override
	public List<Validator<? super NumberOfOptionsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NumberOfOptionsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NumberOfOptionsReference> validator() {
		return new NumberOfOptionsReferenceValidator();
	}

	@Override
	public Validator<? super NumberOfOptionsReference> typeFormatValidator() {
		return new NumberOfOptionsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NumberOfOptionsReference, Set<String>> onlyExistsValidator() {
		return new NumberOfOptionsReferenceOnlyExistsValidator();
	}
}

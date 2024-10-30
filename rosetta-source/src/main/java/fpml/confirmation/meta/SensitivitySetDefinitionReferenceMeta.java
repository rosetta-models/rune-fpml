package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SensitivitySetDefinitionReference;
import fpml.confirmation.validation.SensitivitySetDefinitionReferenceTypeFormatValidator;
import fpml.confirmation.validation.SensitivitySetDefinitionReferenceValidator;
import fpml.confirmation.validation.exists.SensitivitySetDefinitionReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SensitivitySetDefinitionReference.class)
public class SensitivitySetDefinitionReferenceMeta implements RosettaMetaData<SensitivitySetDefinitionReference> {

	@Override
	public List<Validator<? super SensitivitySetDefinitionReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SensitivitySetDefinitionReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SensitivitySetDefinitionReference> validator() {
		return new SensitivitySetDefinitionReferenceValidator();
	}

	@Override
	public Validator<? super SensitivitySetDefinitionReference> typeFormatValidator() {
		return new SensitivitySetDefinitionReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivitySetDefinitionReference, Set<String>> onlyExistsValidator() {
		return new SensitivitySetDefinitionReferenceOnlyExistsValidator();
	}
}

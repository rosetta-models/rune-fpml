package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SensitivityDefinition;
import fpml.confirmation.validation.SensitivityDefinitionTypeFormatValidator;
import fpml.confirmation.validation.SensitivityDefinitionValidator;
import fpml.confirmation.validation.exists.SensitivityDefinitionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SensitivityDefinition.class)
public class SensitivityDefinitionMeta implements RosettaMetaData<SensitivityDefinition> {

	@Override
	public List<Validator<? super SensitivityDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SensitivityDefinition>create(fpml.confirmation.validation.datarule.SensitivityDefinitionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SensitivityDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SensitivityDefinition> validator() {
		return new SensitivityDefinitionValidator();
	}

	@Override
	public Validator<? super SensitivityDefinition> typeFormatValidator() {
		return new SensitivityDefinitionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityDefinition, Set<String>> onlyExistsValidator() {
		return new SensitivityDefinitionOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.validation.EEPParametersTypeFormatValidator;
import fpml.confirmation.validation.EEPParametersValidator;
import fpml.confirmation.validation.exists.EEPParametersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EEPParameters.class)
public class EEPParametersMeta implements RosettaMetaData<EEPParameters> {

	@Override
	public List<Validator<? super EEPParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EEPParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EEPParameters> validator() {
		return new EEPParametersValidator();
	}

	@Override
	public Validator<? super EEPParameters> typeFormatValidator() {
		return new EEPParametersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EEPParameters, Set<String>> onlyExistsValidator() {
		return new EEPParametersOnlyExistsValidator();
	}
}

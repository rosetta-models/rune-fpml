package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericFrequency;
import fpml.confirmation.validation.GenericFrequencyTypeFormatValidator;
import fpml.confirmation.validation.GenericFrequencyValidator;
import fpml.confirmation.validation.exists.GenericFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericFrequency.class)
public class GenericFrequencyMeta implements RosettaMetaData<GenericFrequency> {

	@Override
	public List<Validator<? super GenericFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.GenericFrequency>create(fpml.confirmation.validation.datarule.GenericFrequencyChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericFrequency> validator() {
		return new GenericFrequencyValidator();
	}

	@Override
	public Validator<? super GenericFrequency> typeFormatValidator() {
		return new GenericFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericFrequency, Set<String>> onlyExistsValidator() {
		return new GenericFrequencyOnlyExistsValidator();
	}
}

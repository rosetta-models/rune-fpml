package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.validation.ObservationFrequencyTypeFormatValidator;
import fpml.confirmation.validation.ObservationFrequencyValidator;
import fpml.confirmation.validation.exists.ObservationFrequencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ObservationFrequency.class)
public class ObservationFrequencyMeta implements RosettaMetaData<ObservationFrequency> {

	@Override
	public List<Validator<? super ObservationFrequency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationFrequency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ObservationFrequency> validator() {
		return new ObservationFrequencyValidator();
	}

	@Override
	public Validator<? super ObservationFrequency> typeFormatValidator() {
		return new ObservationFrequencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationFrequency, Set<String>> onlyExistsValidator() {
		return new ObservationFrequencyOnlyExistsValidator();
	}
}

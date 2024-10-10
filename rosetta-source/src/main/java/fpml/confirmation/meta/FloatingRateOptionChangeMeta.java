package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateOptionChange;
import fpml.confirmation.validation.FloatingRateOptionChangeTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateOptionChangeValidator;
import fpml.confirmation.validation.exists.FloatingRateOptionChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRateOptionChange.class)
public class FloatingRateOptionChangeMeta implements RosettaMetaData<FloatingRateOptionChange> {

	@Override
	public List<Validator<? super FloatingRateOptionChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateOptionChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateOptionChange> validator() {
		return new FloatingRateOptionChangeValidator();
	}

	@Override
	public Validator<? super FloatingRateOptionChange> typeFormatValidator() {
		return new FloatingRateOptionChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateOptionChange, Set<String>> onlyExistsValidator() {
		return new FloatingRateOptionChangeOnlyExistsValidator();
	}
}

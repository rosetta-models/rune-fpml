package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingPikOptionChange;
import fpml.confirmation.validation.AccruingPikOptionChangeTypeFormatValidator;
import fpml.confirmation.validation.AccruingPikOptionChangeValidator;
import fpml.confirmation.validation.exists.AccruingPikOptionChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccruingPikOptionChange.class)
public class AccruingPikOptionChangeMeta implements RosettaMetaData<AccruingPikOptionChange> {

	@Override
	public List<Validator<? super AccruingPikOptionChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingPikOptionChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingPikOptionChange> validator() {
		return new AccruingPikOptionChangeValidator();
	}

	@Override
	public Validator<? super AccruingPikOptionChange> typeFormatValidator() {
		return new AccruingPikOptionChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingPikOptionChange, Set<String>> onlyExistsValidator() {
		return new AccruingPikOptionChangeOnlyExistsValidator();
	}
}

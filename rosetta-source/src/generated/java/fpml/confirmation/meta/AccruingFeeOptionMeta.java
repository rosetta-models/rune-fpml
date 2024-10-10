package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeeOption;
import fpml.confirmation.validation.AccruingFeeOptionTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeeOptionValidator;
import fpml.confirmation.validation.exists.AccruingFeeOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AccruingFeeOption.class)
public class AccruingFeeOptionMeta implements RosettaMetaData<AccruingFeeOption> {

	@Override
	public List<Validator<? super AccruingFeeOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeeOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeeOption> validator() {
		return new AccruingFeeOptionValidator();
	}

	@Override
	public Validator<? super AccruingFeeOption> typeFormatValidator() {
		return new AccruingFeeOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeeOption, Set<String>> onlyExistsValidator() {
		return new AccruingFeeOptionOnlyExistsValidator();
	}
}

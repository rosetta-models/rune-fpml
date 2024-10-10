package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionType;
import fpml.confirmation.validation.OptionTypeTypeFormatValidator;
import fpml.confirmation.validation.OptionTypeValidator;
import fpml.confirmation.validation.exists.OptionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionType.class)
public class OptionTypeMeta implements RosettaMetaData<OptionType> {

	@Override
	public List<Validator<? super OptionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionType> validator() {
		return new OptionTypeValidator();
	}

	@Override
	public Validator<? super OptionType> typeFormatValidator() {
		return new OptionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionType, Set<String>> onlyExistsValidator() {
		return new OptionTypeOnlyExistsValidator();
	}
}

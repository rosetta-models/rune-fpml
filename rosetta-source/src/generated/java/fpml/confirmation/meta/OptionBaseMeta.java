package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionBase;
import fpml.confirmation.validation.OptionBaseTypeFormatValidator;
import fpml.confirmation.validation.OptionBaseValidator;
import fpml.confirmation.validation.exists.OptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionBase.class)
public class OptionBaseMeta implements RosettaMetaData<OptionBase> {

	@Override
	public List<Validator<? super OptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionBase> validator() {
		return new OptionBaseValidator();
	}

	@Override
	public Validator<? super OptionBase> typeFormatValidator() {
		return new OptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionBase, Set<String>> onlyExistsValidator() {
		return new OptionBaseOnlyExistsValidator();
	}
}

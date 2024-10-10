package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionBaseExtended;
import fpml.confirmation.validation.OptionBaseExtendedTypeFormatValidator;
import fpml.confirmation.validation.OptionBaseExtendedValidator;
import fpml.confirmation.validation.exists.OptionBaseExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionBaseExtended.class)
public class OptionBaseExtendedMeta implements RosettaMetaData<OptionBaseExtended> {

	@Override
	public List<Validator<? super OptionBaseExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionBaseExtended>create(fpml.confirmation.validation.datarule.OptionBaseExtendedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionBaseExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionBaseExtended> validator() {
		return new OptionBaseExtendedValidator();
	}

	@Override
	public Validator<? super OptionBaseExtended> typeFormatValidator() {
		return new OptionBaseExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionBaseExtended, Set<String>> onlyExistsValidator() {
		return new OptionBaseExtendedOnlyExistsValidator();
	}
}

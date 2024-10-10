package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SimpleFra;
import fpml.confirmation.validation.SimpleFraTypeFormatValidator;
import fpml.confirmation.validation.SimpleFraValidator;
import fpml.confirmation.validation.exists.SimpleFraOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SimpleFra.class)
public class SimpleFraMeta implements RosettaMetaData<SimpleFra> {

	@Override
	public List<Validator<? super SimpleFra>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimpleFra, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SimpleFra> validator() {
		return new SimpleFraValidator();
	}

	@Override
	public Validator<? super SimpleFra> typeFormatValidator() {
		return new SimpleFraTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimpleFra, Set<String>> onlyExistsValidator() {
		return new SimpleFraOnlyExistsValidator();
	}
}

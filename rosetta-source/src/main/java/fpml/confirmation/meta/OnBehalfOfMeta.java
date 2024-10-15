package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OnBehalfOf;
import fpml.confirmation.validation.OnBehalfOfTypeFormatValidator;
import fpml.confirmation.validation.OnBehalfOfValidator;
import fpml.confirmation.validation.exists.OnBehalfOfOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OnBehalfOf.class)
public class OnBehalfOfMeta implements RosettaMetaData<OnBehalfOf> {

	@Override
	public List<Validator<? super OnBehalfOf>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OnBehalfOf, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OnBehalfOf> validator() {
		return new OnBehalfOfValidator();
	}

	@Override
	public Validator<? super OnBehalfOf> typeFormatValidator() {
		return new OnBehalfOfTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OnBehalfOf, Set<String>> onlyExistsValidator() {
		return new OnBehalfOfOnlyExistsValidator();
	}
}

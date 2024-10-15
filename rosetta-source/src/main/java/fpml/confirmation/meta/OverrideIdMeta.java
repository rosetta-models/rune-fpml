package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OverrideId;
import fpml.confirmation.validation.OverrideIdTypeFormatValidator;
import fpml.confirmation.validation.OverrideIdValidator;
import fpml.confirmation.validation.exists.OverrideIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OverrideId.class)
public class OverrideIdMeta implements RosettaMetaData<OverrideId> {

	@Override
	public List<Validator<? super OverrideId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OverrideId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OverrideId> validator() {
		return new OverrideIdValidator();
	}

	@Override
	public Validator<? super OverrideId> typeFormatValidator() {
		return new OverrideIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OverrideId, Set<String>> onlyExistsValidator() {
		return new OverrideIdOnlyExistsValidator();
	}
}

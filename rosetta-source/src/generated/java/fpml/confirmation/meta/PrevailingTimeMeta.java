package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.validation.PrevailingTimeTypeFormatValidator;
import fpml.confirmation.validation.PrevailingTimeValidator;
import fpml.confirmation.validation.exists.PrevailingTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PrevailingTime.class)
public class PrevailingTimeMeta implements RosettaMetaData<PrevailingTime> {

	@Override
	public List<Validator<? super PrevailingTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrevailingTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrevailingTime> validator() {
		return new PrevailingTimeValidator();
	}

	@Override
	public Validator<? super PrevailingTime> typeFormatValidator() {
		return new PrevailingTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrevailingTime, Set<String>> onlyExistsValidator() {
		return new PrevailingTimeOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxBusinessCenterDateTime;
import fpml.confirmation.validation.FxBusinessCenterDateTimeTypeFormatValidator;
import fpml.confirmation.validation.FxBusinessCenterDateTimeValidator;
import fpml.confirmation.validation.exists.FxBusinessCenterDateTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxBusinessCenterDateTime.class)
public class FxBusinessCenterDateTimeMeta implements RosettaMetaData<FxBusinessCenterDateTime> {

	@Override
	public List<Validator<? super FxBusinessCenterDateTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxBusinessCenterDateTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxBusinessCenterDateTime> validator() {
		return new FxBusinessCenterDateTimeValidator();
	}

	@Override
	public Validator<? super FxBusinessCenterDateTime> typeFormatValidator() {
		return new FxBusinessCenterDateTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxBusinessCenterDateTime, Set<String>> onlyExistsValidator() {
		return new FxBusinessCenterDateTimeOnlyExistsValidator();
	}
}

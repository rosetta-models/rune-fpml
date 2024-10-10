package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxStraddle;
import fpml.confirmation.validation.FxStraddleTypeFormatValidator;
import fpml.confirmation.validation.FxStraddleValidator;
import fpml.confirmation.validation.exists.FxStraddleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxStraddle.class)
public class FxStraddleMeta implements RosettaMetaData<FxStraddle> {

	@Override
	public List<Validator<? super FxStraddle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStraddle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxStraddle> validator() {
		return new FxStraddleValidator();
	}

	@Override
	public Validator<? super FxStraddle> typeFormatValidator() {
		return new FxStraddleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStraddle, Set<String>> onlyExistsValidator() {
		return new FxStraddleOnlyExistsValidator();
	}
}

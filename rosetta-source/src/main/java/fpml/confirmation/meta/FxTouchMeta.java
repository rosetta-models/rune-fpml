package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTouch;
import fpml.confirmation.validation.FxTouchTypeFormatValidator;
import fpml.confirmation.validation.FxTouchValidator;
import fpml.confirmation.validation.exists.FxTouchOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTouch.class)
public class FxTouchMeta implements RosettaMetaData<FxTouch> {

	@Override
	public List<Validator<? super FxTouch>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTouch>create(fpml.confirmation.validation.datarule.FxTouchChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTouch, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTouch> validator() {
		return new FxTouchValidator();
	}

	@Override
	public Validator<? super FxTouch> typeFormatValidator() {
		return new FxTouchTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTouch, Set<String>> onlyExistsValidator() {
		return new FxTouchOnlyExistsValidator();
	}
}

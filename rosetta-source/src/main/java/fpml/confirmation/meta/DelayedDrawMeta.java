package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DelayedDraw;
import fpml.confirmation.validation.DelayedDrawTypeFormatValidator;
import fpml.confirmation.validation.DelayedDrawValidator;
import fpml.confirmation.validation.exists.DelayedDrawOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DelayedDraw.class)
public class DelayedDrawMeta implements RosettaMetaData<DelayedDraw> {

	@Override
	public List<Validator<? super DelayedDraw>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DelayedDraw, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DelayedDraw> validator() {
		return new DelayedDrawValidator();
	}

	@Override
	public Validator<? super DelayedDraw> typeFormatValidator() {
		return new DelayedDrawTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DelayedDraw, Set<String>> onlyExistsValidator() {
		return new DelayedDrawOnlyExistsValidator();
	}
}

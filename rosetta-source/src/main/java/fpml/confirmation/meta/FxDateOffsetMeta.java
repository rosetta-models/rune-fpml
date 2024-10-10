package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDateOffset;
import fpml.confirmation.validation.FxDateOffsetTypeFormatValidator;
import fpml.confirmation.validation.FxDateOffsetValidator;
import fpml.confirmation.validation.exists.FxDateOffsetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxDateOffset.class)
public class FxDateOffsetMeta implements RosettaMetaData<FxDateOffset> {

	@Override
	public List<Validator<? super FxDateOffset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDateOffset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDateOffset> validator() {
		return new FxDateOffsetValidator();
	}

	@Override
	public Validator<? super FxDateOffset> typeFormatValidator() {
		return new FxDateOffsetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDateOffset, Set<String>> onlyExistsValidator() {
		return new FxDateOffsetOnlyExistsValidator();
	}
}

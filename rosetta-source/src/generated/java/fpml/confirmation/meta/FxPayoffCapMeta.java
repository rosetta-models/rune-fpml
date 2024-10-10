package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPayoffCap;
import fpml.confirmation.validation.FxPayoffCapTypeFormatValidator;
import fpml.confirmation.validation.FxPayoffCapValidator;
import fpml.confirmation.validation.exists.FxPayoffCapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxPayoffCap.class)
public class FxPayoffCapMeta implements RosettaMetaData<FxPayoffCap> {

	@Override
	public List<Validator<? super FxPayoffCap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxPayoffCap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxPayoffCap> validator() {
		return new FxPayoffCapValidator();
	}

	@Override
	public Validator<? super FxPayoffCap> typeFormatValidator() {
		return new FxPayoffCapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPayoffCap, Set<String>> onlyExistsValidator() {
		return new FxPayoffCapOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Fx;
import fpml.confirmation.validation.FxTypeFormatValidator;
import fpml.confirmation.validation.FxValidator;
import fpml.confirmation.validation.exists.FxOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Fx.class)
public class FxMeta implements RosettaMetaData<Fx> {

	@Override
	public List<Validator<? super Fx>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Fx, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Fx> validator() {
		return new FxValidator();
	}

	@Override
	public Validator<? super Fx> typeFormatValidator() {
		return new FxTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Fx, Set<String>> onlyExistsValidator() {
		return new FxOnlyExistsValidator();
	}
}

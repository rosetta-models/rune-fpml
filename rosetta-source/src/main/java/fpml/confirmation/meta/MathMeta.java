package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Math;
import fpml.confirmation.validation.MathTypeFormatValidator;
import fpml.confirmation.validation.MathValidator;
import fpml.confirmation.validation.exists.MathOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Math.class)
public class MathMeta implements RosettaMetaData<Math> {

	@Override
	public List<Validator<? super Math>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Math, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Math> validator() {
		return new MathValidator();
	}

	@Override
	public Validator<? super Math> typeFormatValidator() {
		return new MathTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Math, Set<String>> onlyExistsValidator() {
		return new MathOnlyExistsValidator();
	}
}

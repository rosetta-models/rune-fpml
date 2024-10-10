package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LimitType;
import fpml.confirmation.validation.LimitTypeTypeFormatValidator;
import fpml.confirmation.validation.LimitTypeValidator;
import fpml.confirmation.validation.exists.LimitTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LimitType.class)
public class LimitTypeMeta implements RosettaMetaData<LimitType> {

	@Override
	public List<Validator<? super LimitType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LimitType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LimitType> validator() {
		return new LimitTypeValidator();
	}

	@Override
	public Validator<? super LimitType> typeFormatValidator() {
		return new LimitTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitType, Set<String>> onlyExistsValidator() {
		return new LimitTypeOnlyExistsValidator();
	}
}

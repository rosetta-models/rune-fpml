package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcType;
import fpml.confirmation.validation.LcTypeTypeFormatValidator;
import fpml.confirmation.validation.LcTypeValidator;
import fpml.confirmation.validation.exists.LcTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LcType.class)
public class LcTypeMeta implements RosettaMetaData<LcType> {

	@Override
	public List<Validator<? super LcType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcType> validator() {
		return new LcTypeValidator();
	}

	@Override
	public Validator<? super LcType> typeFormatValidator() {
		return new LcTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcType, Set<String>> onlyExistsValidator() {
		return new LcTypeOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransformType;
import fpml.confirmation.validation.TransformTypeTypeFormatValidator;
import fpml.confirmation.validation.TransformTypeValidator;
import fpml.confirmation.validation.exists.TransformTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TransformType.class)
public class TransformTypeMeta implements RosettaMetaData<TransformType> {

	@Override
	public List<Validator<? super TransformType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransformType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransformType> validator() {
		return new TransformTypeValidator();
	}

	@Override
	public Validator<? super TransformType> typeFormatValidator() {
		return new TransformTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransformType, Set<String>> onlyExistsValidator() {
		return new TransformTypeOnlyExistsValidator();
	}
}

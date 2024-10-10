package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericDimension;
import fpml.confirmation.validation.GenericDimensionTypeFormatValidator;
import fpml.confirmation.validation.GenericDimensionValidator;
import fpml.confirmation.validation.exists.GenericDimensionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericDimension.class)
public class GenericDimensionMeta implements RosettaMetaData<GenericDimension> {

	@Override
	public List<Validator<? super GenericDimension>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericDimension, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericDimension> validator() {
		return new GenericDimensionValidator();
	}

	@Override
	public Validator<? super GenericDimension> typeFormatValidator() {
		return new GenericDimensionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericDimension, Set<String>> onlyExistsValidator() {
		return new GenericDimensionOnlyExistsValidator();
	}
}

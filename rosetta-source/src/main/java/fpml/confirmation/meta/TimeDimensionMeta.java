package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TimeDimension;
import fpml.confirmation.validation.TimeDimensionTypeFormatValidator;
import fpml.confirmation.validation.TimeDimensionValidator;
import fpml.confirmation.validation.exists.TimeDimensionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TimeDimension.class)
public class TimeDimensionMeta implements RosettaMetaData<TimeDimension> {

	@Override
	public List<Validator<? super TimeDimension>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TimeDimension>create(fpml.confirmation.validation.datarule.TimeDimensionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TimeDimension, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TimeDimension> validator() {
		return new TimeDimensionValidator();
	}

	@Override
	public Validator<? super TimeDimension> typeFormatValidator() {
		return new TimeDimensionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimeDimension, Set<String>> onlyExistsValidator() {
		return new TimeDimensionOnlyExistsValidator();
	}
}

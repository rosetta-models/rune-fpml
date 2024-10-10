package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TimestampTypeScheme;
import fpml.confirmation.validation.TimestampTypeSchemeTypeFormatValidator;
import fpml.confirmation.validation.TimestampTypeSchemeValidator;
import fpml.confirmation.validation.exists.TimestampTypeSchemeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TimestampTypeScheme.class)
public class TimestampTypeSchemeMeta implements RosettaMetaData<TimestampTypeScheme> {

	@Override
	public List<Validator<? super TimestampTypeScheme>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TimestampTypeScheme, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TimestampTypeScheme> validator() {
		return new TimestampTypeSchemeValidator();
	}

	@Override
	public Validator<? super TimestampTypeScheme> typeFormatValidator() {
		return new TimestampTypeSchemeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TimestampTypeScheme, Set<String>> onlyExistsValidator() {
		return new TimestampTypeSchemeOnlyExistsValidator();
	}
}

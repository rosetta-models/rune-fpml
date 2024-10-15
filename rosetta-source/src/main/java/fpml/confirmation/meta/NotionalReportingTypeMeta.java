package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalReportingType;
import fpml.confirmation.validation.NotionalReportingTypeTypeFormatValidator;
import fpml.confirmation.validation.NotionalReportingTypeValidator;
import fpml.confirmation.validation.exists.NotionalReportingTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NotionalReportingType.class)
public class NotionalReportingTypeMeta implements RosettaMetaData<NotionalReportingType> {

	@Override
	public List<Validator<? super NotionalReportingType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalReportingType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalReportingType> validator() {
		return new NotionalReportingTypeValidator();
	}

	@Override
	public Validator<? super NotionalReportingType> typeFormatValidator() {
		return new NotionalReportingTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalReportingType, Set<String>> onlyExistsValidator() {
		return new NotionalReportingTypeOnlyExistsValidator();
	}
}

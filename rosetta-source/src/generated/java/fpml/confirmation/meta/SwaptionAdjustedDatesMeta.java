package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SwaptionAdjustedDates;
import fpml.confirmation.validation.SwaptionAdjustedDatesTypeFormatValidator;
import fpml.confirmation.validation.SwaptionAdjustedDatesValidator;
import fpml.confirmation.validation.exists.SwaptionAdjustedDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SwaptionAdjustedDates.class)
public class SwaptionAdjustedDatesMeta implements RosettaMetaData<SwaptionAdjustedDates> {

	@Override
	public List<Validator<? super SwaptionAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SwaptionAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SwaptionAdjustedDates> validator() {
		return new SwaptionAdjustedDatesValidator();
	}

	@Override
	public Validator<? super SwaptionAdjustedDates> typeFormatValidator() {
		return new SwaptionAdjustedDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SwaptionAdjustedDates, Set<String>> onlyExistsValidator() {
		return new SwaptionAdjustedDatesOnlyExistsValidator();
	}
}

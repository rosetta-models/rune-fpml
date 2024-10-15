package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StartingDate;
import fpml.confirmation.validation.StartingDateTypeFormatValidator;
import fpml.confirmation.validation.StartingDateValidator;
import fpml.confirmation.validation.exists.StartingDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StartingDate.class)
public class StartingDateMeta implements RosettaMetaData<StartingDate> {

	@Override
	public List<Validator<? super StartingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StartingDate>create(fpml.confirmation.validation.datarule.StartingDateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StartingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StartingDate> validator() {
		return new StartingDateValidator();
	}

	@Override
	public Validator<? super StartingDate> typeFormatValidator() {
		return new StartingDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StartingDate, Set<String>> onlyExistsValidator() {
		return new StartingDateOnlyExistsValidator();
	}
}

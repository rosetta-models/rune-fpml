package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DateList;
import fpml.confirmation.validation.DateListTypeFormatValidator;
import fpml.confirmation.validation.DateListValidator;
import fpml.confirmation.validation.exists.DateListOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DateList.class)
public class DateListMeta implements RosettaMetaData<DateList> {

	@Override
	public List<Validator<? super DateList>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DateList, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DateList> validator() {
		return new DateListValidator();
	}

	@Override
	public Validator<? super DateList> typeFormatValidator() {
		return new DateListTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DateList, Set<String>> onlyExistsValidator() {
		return new DateListOnlyExistsValidator();
	}
}

package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequiredIdentifierDate;
import fpml.confirmation.validation.RequiredIdentifierDateTypeFormatValidator;
import fpml.confirmation.validation.RequiredIdentifierDateValidator;
import fpml.confirmation.validation.exists.RequiredIdentifierDateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequiredIdentifierDate.class)
public class RequiredIdentifierDateMeta implements RosettaMetaData<RequiredIdentifierDate> {

	@Override
	public List<Validator<? super RequiredIdentifierDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequiredIdentifierDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequiredIdentifierDate> validator() {
		return new RequiredIdentifierDateValidator();
	}

	@Override
	public Validator<? super RequiredIdentifierDate> typeFormatValidator() {
		return new RequiredIdentifierDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequiredIdentifierDate, Set<String>> onlyExistsValidator() {
		return new RequiredIdentifierDateOnlyExistsValidator();
	}
}

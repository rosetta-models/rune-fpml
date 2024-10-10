package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestClearing;
import fpml.confirmation.validation.RequestClearingTypeFormatValidator;
import fpml.confirmation.validation.RequestClearingValidator;
import fpml.confirmation.validation.exists.RequestClearingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RequestClearing.class)
public class RequestClearingMeta implements RosettaMetaData<RequestClearing> {

	@Override
	public List<Validator<? super RequestClearing>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestClearing>create(fpml.confirmation.validation.datarule.RequestClearingChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearing, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestClearing> validator() {
		return new RequestClearingValidator();
	}

	@Override
	public Validator<? super RequestClearing> typeFormatValidator() {
		return new RequestClearingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearing, Set<String>> onlyExistsValidator() {
		return new RequestClearingOnlyExistsValidator();
	}
}

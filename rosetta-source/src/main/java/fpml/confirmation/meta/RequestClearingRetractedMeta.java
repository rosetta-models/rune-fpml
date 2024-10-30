package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestClearingRetracted;
import fpml.confirmation.validation.RequestClearingRetractedTypeFormatValidator;
import fpml.confirmation.validation.RequestClearingRetractedValidator;
import fpml.confirmation.validation.exists.RequestClearingRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestClearingRetracted.class)
public class RequestClearingRetractedMeta implements RosettaMetaData<RequestClearingRetracted> {

	@Override
	public List<Validator<? super RequestClearingRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestClearingRetracted>create(fpml.confirmation.validation.datarule.RequestClearingRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearingRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestClearingRetracted> validator() {
		return new RequestClearingRetractedValidator();
	}

	@Override
	public Validator<? super RequestClearingRetracted> typeFormatValidator() {
		return new RequestClearingRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearingRetracted, Set<String>> onlyExistsValidator() {
		return new RequestClearingRetractedOnlyExistsValidator();
	}
}

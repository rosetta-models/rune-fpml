package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestExecutionRetracted;
import fpml.confirmation.validation.RequestExecutionRetractedTypeFormatValidator;
import fpml.confirmation.validation.RequestExecutionRetractedValidator;
import fpml.confirmation.validation.exists.RequestExecutionRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestExecutionRetracted.class)
public class RequestExecutionRetractedMeta implements RosettaMetaData<RequestExecutionRetracted> {

	@Override
	public List<Validator<? super RequestExecutionRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestExecutionRetracted>create(fpml.confirmation.validation.datarule.RequestExecutionRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestExecutionRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestExecutionRetracted> validator() {
		return new RequestExecutionRetractedValidator();
	}

	@Override
	public Validator<? super RequestExecutionRetracted> typeFormatValidator() {
		return new RequestExecutionRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestExecutionRetracted, Set<String>> onlyExistsValidator() {
		return new RequestExecutionRetractedOnlyExistsValidator();
	}
}

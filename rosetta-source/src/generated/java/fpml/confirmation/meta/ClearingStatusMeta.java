package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingStatus;
import fpml.confirmation.validation.ClearingStatusTypeFormatValidator;
import fpml.confirmation.validation.ClearingStatusValidator;
import fpml.confirmation.validation.exists.ClearingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingStatus.class)
public class ClearingStatusMeta implements RosettaMetaData<ClearingStatus> {

	@Override
	public List<Validator<? super ClearingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingStatus> validator() {
		return new ClearingStatusValidator();
	}

	@Override
	public Validator<? super ClearingStatus> typeFormatValidator() {
		return new ClearingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingStatus, Set<String>> onlyExistsValidator() {
		return new ClearingStatusOnlyExistsValidator();
	}
}

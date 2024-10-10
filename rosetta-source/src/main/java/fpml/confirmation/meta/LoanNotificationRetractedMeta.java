package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanNotificationRetracted;
import fpml.confirmation.validation.LoanNotificationRetractedTypeFormatValidator;
import fpml.confirmation.validation.LoanNotificationRetractedValidator;
import fpml.confirmation.validation.exists.LoanNotificationRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanNotificationRetracted.class)
public class LoanNotificationRetractedMeta implements RosettaMetaData<LoanNotificationRetracted> {

	@Override
	public List<Validator<? super LoanNotificationRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanNotificationRetracted> validator() {
		return new LoanNotificationRetractedValidator();
	}

	@Override
	public Validator<? super LoanNotificationRetracted> typeFormatValidator() {
		return new LoanNotificationRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationRetracted, Set<String>> onlyExistsValidator() {
		return new LoanNotificationRetractedOnlyExistsValidator();
	}
}

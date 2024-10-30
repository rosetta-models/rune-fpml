package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Approvals;
import fpml.confirmation.validation.ApprovalsTypeFormatValidator;
import fpml.confirmation.validation.ApprovalsValidator;
import fpml.confirmation.validation.exists.ApprovalsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Approvals.class)
public class ApprovalsMeta implements RosettaMetaData<Approvals> {

	@Override
	public List<Validator<? super Approvals>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Approvals, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Approvals> validator() {
		return new ApprovalsValidator();
	}

	@Override
	public Validator<? super Approvals> typeFormatValidator() {
		return new ApprovalsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Approvals, Set<String>> onlyExistsValidator() {
		return new ApprovalsOnlyExistsValidator();
	}
}

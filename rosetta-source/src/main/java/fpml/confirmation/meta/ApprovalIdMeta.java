package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApprovalId;
import fpml.confirmation.validation.ApprovalIdTypeFormatValidator;
import fpml.confirmation.validation.ApprovalIdValidator;
import fpml.confirmation.validation.exists.ApprovalIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ApprovalId.class)
public class ApprovalIdMeta implements RosettaMetaData<ApprovalId> {

	@Override
	public List<Validator<? super ApprovalId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApprovalId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApprovalId> validator() {
		return new ApprovalIdValidator();
	}

	@Override
	public Validator<? super ApprovalId> typeFormatValidator() {
		return new ApprovalIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalId, Set<String>> onlyExistsValidator() {
		return new ApprovalIdOnlyExistsValidator();
	}
}

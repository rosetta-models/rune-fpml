package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.validation.ApprovalTypeTypeFormatValidator;
import fpml.confirmation.validation.ApprovalTypeValidator;
import fpml.confirmation.validation.exists.ApprovalTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ApprovalType.class)
public class ApprovalTypeMeta implements RosettaMetaData<ApprovalType> {

	@Override
	public List<Validator<? super ApprovalType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ApprovalType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApprovalType> validator() {
		return new ApprovalTypeValidator();
	}

	@Override
	public Validator<? super ApprovalType> typeFormatValidator() {
		return new ApprovalTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApprovalType, Set<String>> onlyExistsValidator() {
		return new ApprovalTypeOnlyExistsValidator();
	}
}
